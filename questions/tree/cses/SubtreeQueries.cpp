#include <bits/stdc++.h>
using namespace std;

template<typename T>
class SegmentTree {
public:
    size_t n;
    vector<T> tree;

    SegmentTree(size_t size) : n(size) {
        tree.assign(4 * n, 0);
    }

    void update(size_t index, T value) {
        function<void(size_t, size_t, size_t)> update_impl =
            [&](size_t node, size_t start, size_t end) {
            if (start == end) {
                tree[node] = value;
            } else {
                size_t mid = start + (end - start) / 2;
                if (index <= mid) {
                    update_impl(2 * node, start, mid);
                } else {
                    update_impl(2 * node + 1, mid + 1, end);
                }
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        };
        update_impl(1, 0, n - 1);
    }

    T query(size_t left, size_t right) {
        function<T(size_t, size_t, size_t)> query_impl =
            [&](size_t node, size_t start, size_t end) -> T {
            if (left > end || right < start) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            size_t mid = start + (end - start) / 2;
            T leftQuery = query_impl(2 * node, start, mid);
            T rightQuery = query_impl(2 * node + 1, mid + 1, end);
            return leftQuery + rightQuery;
        };
        return query_impl(1, 0, n - 1);
    }
};

int main() {
    size_t n, q;
    cin >> n >> q;
    vector<int64_t> a(n + 1);

    for (size_t i = 1; i <= n; ++i) {
        cin >> a[i];
    }

    vector<vector<size_t>> edges(n + 1);

    for (size_t i = 0; i < n - 1; ++i) {
        size_t u, v;
        cin >> u >> v;
        edges[u].push_back(v);
        edges[v].push_back(u);
    }

    vector<vector<size_t>> adjList(n + 1);
    vector<size_t> in(n + 1), out(n + 1);
    size_t timer = 0;
    vector<size_t> subtree;
    subtree.reserve(2 * n + 1);

    function<void(size_t, size_t)> dfs =
        [&](size_t node, size_t parent) {
        in[node] = timer++;
        subtree.push_back(node);
        for (size_t child : edges[node]) {
            if (child != parent) {
                adjList[node].push_back(child);
                dfs(child, node);
            }
        }
        subtree.push_back(node);
        out[node] = timer++;
    };

    dfs(1, 0);

    SegmentTree<int64_t> tree(subtree.size());

    for (size_t i = 0; i < subtree.size(); ++i) {
        tree.update(i, a[subtree[i]]);
    }

    while (q--) {
        int type;
        cin >> type;
        if (type == 1) {
            size_t node;
            int64_t value;
            cin >> node >> value;
            tree.update(in[node], value);
            tree.update(out[node], value);
        } else {
            size_t node;
            cin >> node;
            cout << tree.query(in[node], out[node])/2 << endl;
        }
    }

    return 0;
}