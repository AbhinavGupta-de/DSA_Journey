#include <iostream>
#include <vector>
#include <functional>

#define int long long
using namespace std;

int merge(int a, int b) {
    return a + b;
}

template<typename T>
class SegmentTree {
public:
    int N;
    T identity;
    vector<T> tree;

    SegmentTree(int n, T identity) {
        N = n;
        this->identity = identity;
        tree.assign(4 * N, identity);
    }

    void update(int qIdx, T val) {
        function<void(int, int, int)> func = [&](int tIdx, int tLeft, int tRight) {
            if (tLeft == tRight) {
                tree[tIdx] = val; // Correctly set the value, not increment
                return;
            }
            int tMid = tLeft + (tRight - tLeft) / 2;
            if (tLeft <= qIdx && qIdx <= tMid) {
                func(2 * tIdx + 1, tLeft, tMid);
            } else {
                func(2 * tIdx + 2, tMid + 1, tRight);
            }
            tree[tIdx] = merge(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
        };
        func(0, 0, N - 1);
    }

    T query(int l, int r) {
        function<T(int, int, int)> func = [&](int tIdx, int tLeft, int tRight) {
            if (r < tLeft || l > tRight) {
                return identity;
            }
            if (l <= tLeft && tRight <= r) {
                return tree[tIdx];
            }
            int tMid = tLeft + (tRight - tLeft) / 2;
            return merge(func(2 * tIdx + 1, tLeft, tMid), func(2 * tIdx + 2, tMid + 1, tRight));
        };
        return func(0, 0, N - 1);
    }
};

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n, q;
    cin >> n >> q;

    SegmentTree<int> st(n + 2, 0); // Correct initialization with n + 2
    vector<int> a(n + 1); // Correct initialization with size n + 1

    for (int i = 1; i <= n; i++) { // Read input with 1-based indexing
        cin >> a[i];
    }

    while (q--) {
        int t;
        cin >> t;
        if (t == 1) {
            int l, r, u;
            cin >> l >> r >> u;
            st.update(l, st.query(l, l) + u); // Correctly handle range update
            st.update(r + 1, st.query(r + 1, r + 1) - u);
        } else {
            int k;
            cin >> k;
            cout << a[k] + st.query(1, k) << endl; // Correct query range
        }
    }

    return 0;
}
