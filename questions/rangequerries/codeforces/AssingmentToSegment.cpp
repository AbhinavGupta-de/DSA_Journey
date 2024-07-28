#include<vector>
#include<iostream>
#include<bits/stdc++.h>
#define int long long

using namespace std;

class SegmentTree {
public:
    int N;
    vector<int> tree;
    vector<bool> lazy;

    SegmentTree(int n) {
        N = n;
        tree.assign(4 * N, 0);
        lazy.assign(4 * N, false);
    }

    void propagate(int tIdx, int tL, int tR) {
        if(!lazy[tIdx] or tL == tR) return;

        tree[2 * tIdx + 1] = tree[tIdx];
        tree[2 * tIdx + 2] = tree[tIdx];

        lazy[2 * tIdx + 1] = true;
        lazy[2 * tIdx + 2] = true;

        lazy[tIdx] = false;
        tree[tIdx] = 0;
    }

//    a[i] = x
    void update(int l, int r, int val) {
        function<void(int, int, int)> func = [&](int tIdx, int tL, int tR) {
            propagate(tIdx, tL, tR);
            if (r < tL || l > tR) {
                return;
            }

            if (l <= tL && tR <= r) {
                tree[tIdx] = val;
                lazy[tIdx] = true;
                return;
            }

            int tM = tL + (tR - tL) / 2;
            func(2 * tIdx + 1, tL, tM);
            func(2 * tIdx + 2, tM + 1, tR);
        };
        func(0, 0, N - 1);
    }

    int query(int qIdx) {
        function<int(int, int, int)> func = [&](int tIdx, int tL, int tR) {
            propagate(tIdx, tL, tR);
            if (tL == tR) {
                return tree[tIdx];
            }

            int tM = tL + (tR - tL) / 2;

            int ans = 0;

            if (qIdx <= tM) {
                ans = func(2 * tIdx + 1, tL, tM);
            } else {
                ans = func(2 * tIdx + 2, tM + 1, tR);
            }

            return ans;

        };
        return func(0, 0, N - 1);
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
            int l, r, x;
            cin >> l >> r >> x;
            st.update(l, r - 1, x);
        } else {
            int i;
            cin >> i;
            cout << st.query(i) << endl;
        }
    }
}

signed main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    solve();
    return 0;
}

