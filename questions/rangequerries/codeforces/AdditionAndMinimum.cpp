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
        tree.resize(4 * n, 0);
        lazy.resize(4 * n, false);
        lazyValues.resize(4 * n, 0);
        N = n;
    }

    void propagate(int tid, int tl, int tr) {
        if (!lazy[tid]) return;

        if (tl < tr) {
            lazyValues[2 * tid + 1] += lazyValues[tid];
            lazy[2 * tid + 1] = true;
            lazyValues[2 * tid + 2] += lazyValues[tid];
            lazy[2 * tid + 2] = true;
        }

        tree[tid] += lazyValues[tid];
        lazyValues[tid] = 0;
        lazy[tid] = false;
    }

    void update(int l, int r, int x) {
        function<void(int, int, int)> f = [&](int tid, int tl, int tr) {
            propagate(tid, tl, tr);

            if (tl > r || tr < l) return;

            if (l <= tl && tr <= r) {
                lazy[tid] = true;
                lazyValues[tid] += x;
                propagate(tid, tl, tr);
                return;
            }

            int tm = (tl + tr) / 2;

            f(2 * tid + 1, tl, tm);
            f(2 * tid + 2, tm + 1, tr);

            tree[tid] = min(tree[2 * tid + 1], tree[2 * tid + 2]);
        };
        f(0, 0, N - 1);
    }

    long long query(int l, int r) {
        function<long long(int, int, int)> f = [&](int tid, int tl, int tr) {
            propagate(tid, tl, tr);

            if (tl > r || tr < l) return LLONG_MAX;

            if (l <= tl && tr <= r) {
                return tree[tid];
            }

            int tm = (tl + tr) / 2;

            return min(f(2 * tid + 1, tl, tm), f(2 * tid + 2, tm + 1, tr));
        };
        return f(0, 0, N - 1);
    }
};

void solve() {
    int n, q;
    cin >> n >> q;

    SegmentTree st(n);
    while (q--) {
        int t;
        cin >> t;
        if (t == 1) {
            int l, r, v;
            cin >> l >> r >> v;
            st.update(l, r - 1, v);
        } else {
            int l, r;
            cin >> l >> r;
            cout << st.query(l, r - 1) << endl;
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
