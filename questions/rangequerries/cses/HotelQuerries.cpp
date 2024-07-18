#include <vector>
#include <iostream>
#include <functional>

#define int long long

using namespace std;

int merge(int a, int b) {
    return max(a, b);
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
        function<void(int, int, int)> func = [&](int tIdx, int tL, int tR) {
            if (tL == tR) {
                tree[tIdx] = val;
                return;
            }
            int tM = tL + (tR - tL) / 2;

            if (tL <= qIdx && qIdx <= tM) func(2 * tIdx + 1, tL, tM);
            else func(2 * tIdx + 2, tM + 1, tR);

            tree[tIdx] = merge(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
        };
        func(0, 0, N - 1);
    }

    T query(int l, int r) {
        function<T(int, int, int)> func = [&](int tIdx, int tL, int tR) -> T {
            if (r < tL || l > tR) {
                return identity;
            }

            if (l <= tL && tR <= r) {
                return tree[tIdx];
            }

            int tM = tL + (tR - tL) / 2;

            return merge(func(2 * tIdx + 1, tL, tM), func(2 * tIdx + 2, tM + 1, tR));
        };
        return func(0, 0, N - 1);
    }
};

signed main() {
    int n, m;
    cin >> n >> m;

    SegmentTree<int> st(n + 1, 0ll);

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        st.update(i, x);
    }

    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;

        if (st.query(0, n - 1) < x) {
            cout << 0 << " ";
            continue;
        }

        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (st.query(0, mid) < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        cout << l + 1 << " ";
        st.update(l, st.query(l, l) - x);
    }

    return 0;
}
