#include<vector>
#include<iostream>
#include<functional>
#define int long long

using namespace std;

class SegmentTree {
public:
    int N;
    vector<int> tree;

    SegmentTree(int n) {
        N = n;
        tree.assign(4 * N, 0);
    }

    void update(int left, int right, int val) {
        function<void(int, int, int)> func = [&](int tIdx, int tL, int tR) {
            if (left > tR || right < tL) {
                return;
            }

            // Fixed the condition to properly update the range
            if (left <= tL && tR <= right) {
                tree[tIdx] = tree[tIdx] + val;
                return;
            }

            int tM = tL + (tR - tL) / 2;
            func(2 * tIdx + 1, tL, tM);
            func(2 * tIdx + 2, tM + 1, tR);
        };
        func(0, 0, N - 1);
    }

    int query(int qIdx) {
        // Fixed the lambda function and added the missing return statement
        function<int(int, int, int)> func = [&](int tIdx, int tL, int tR) {
            if (tL == tR) {
                return tree[tIdx];
            }

            int tM = tL + (tR - tL) / 2;
            int ans = tree[tIdx];

            if (qIdx <= tM) {
                ans = ans + func(2 * tIdx + 1, tL, tM);
            } else {
                ans = ans + func(2 * tIdx + 2, tM + 1, tR);
            }

            return ans;
        };
        return func(0, 0, N - 1); // Added the missing return statement
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

signed main()
{
    cin.tie(nullptr)->sync_with_stdio(false);
    solve();
}
