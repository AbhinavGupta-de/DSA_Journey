#include <bits/stdc++.h>
using namespace std;

#define fastio() ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
#define int long long

class SegmentTree {
public:
    vector<int> tree;
    vector<bool> lazy;
    vector<int> lazyValues;
    int N;

    SegmentTree(int n) {
        tree.resize(4 * n, LLONG_MAX); // Initialize with maximum values
        lazy.resize(4 * n, false);
        lazyValues.resize(4 * n, 0); // Initialize lazy values with 0 (identity for bitwise OR)
        N = n;
    }

    void propagate(int tid, int tl, int tr) {
        if (!lazy[tid]) return;

        if (tl < tr) {
            lazyValues[2 * tid + 1] |= lazyValues[tid];
            lazy[2 * tid + 1] = true;
            lazyValues[2 * tid + 2] |= lazyValues[tid];
            lazy[2 * tid + 2] = true;
        }

        tree[tid] |= lazyValues[tid];
        lazyValues[tid] = 0;
        lazy[tid] = false;
    }

    void pointUpdate(int qIdx, int val) {
        function<void(int, int, int)> func = [&](int tIdx, int tL, int tR) {
            propagate(tIdx, tL, tR);

            if (tL == tR) {
                tree[tIdx] = val;
                return;
            }

            int tM = tL + (tR - tL) / 2;

            if (qIdx <= tM) {
                func(2 * tIdx + 1, tL, tM);
            } else {
                func(2 * tIdx + 2, tM + 1, tR);
            }

            tree[tIdx] = tree[2 * tIdx + 1] & tree[2 * tIdx + 2];
        };
        func(0, 0, N - 1);
    }

    void rangeUpdate(int l, int r, int x) {
        function<void(int, int, int)> f = [&](int tid, int tl, int tr) {
            propagate(tid, tl, tr);

            if (tl > r || tr < l) return;

            if (l <= tl && tr <= r) {
                lazy[tid] = true;
                lazyValues[tid] |= x;
                propagate(tid, tl, tr);
                return;
            }

            int tm = (tl + tr) / 2;

            f(2 * tid + 1, tl, tm);
            f(2 * tid + 2, tm + 1, tr);

            tree[tid] = tree[2 * tid + 1] & tree[2 * tid + 2];
        };
        f(0, 0, N - 1);
    }

    long long rangeQuery(int l, int r) {
        function<long long(int, int, int)> f = [&](int tid, int tl, int tr) {
            propagate(tid, tl, tr);

            if (tl > r || tr < l) return LLONG_MAX;

            if (l <= tl && tr <= r) {
                return tree[tid];
            }

            int tm = (tl + tr) / 2;

            return f(2 * tid + 1, tl, tm) & f(2 * tid + 2, tm + 1, tr);
        };
        return f(0, 0, N - 1);
    }
};

void solve() {
    int n, q;
    cin >> n >> q;
    SegmentTree st(n);

    for (int i = 0; i < n; i++) {
        st.pointUpdate(i, 0);
    }

    while (q--) {
        int t;
        cin >> t;
        if (t == 1) {
            int l, r, v;
            cin >> l >> r >> v;
            st.rangeUpdate(l, r - 1, v);
        } else {
            int l, r;
            cin >> l >> r;
            cout << st.rangeQuery(l, r - 1) << endl;
        }
    }
}

signed main() {
    fastio();
    int t = 1;
    while (t--) {
        solve();
    }
    return 0;
}
