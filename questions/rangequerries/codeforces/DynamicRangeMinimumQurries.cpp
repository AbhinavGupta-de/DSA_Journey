#include<vector>
#include<iostream>
#include<bits/stdc++.h>
#define int long long

using namespace std;

int merge (int a, int b) {
    return min(a, b);
}

template<typename T>
class SegmentTree{
    public:
    vector<T> tree;
    int N;
    T identity;

    SegmentTree(int n, T id) {
        N = n;
        this->identity = id;
        tree.assign(4*N, id);
    }

    void update(int qIdx, T val) {

        function<void(int, int, int)> func = [&](int idx, int left, int right) {

            if(left == right) {
                tree[idx] = val;
                return;
            }

            int mid = left + (right - left) / 2;

            if(left <= qIdx and qIdx <= mid) {
                func(2*idx+1, left, mid);
            } else {
                func(2*idx+2, mid+1, right);
            }

            tree[idx] = merge(tree[2*idx + 1], tree[2*idx + 2]);
        };

        func(0, 0, N-1);
    }

    T query(int l, int r) {

        function<T(int, int, int)> func = [&](int idx, int tL, int tR) {

            if(r < tL or l > tR) {
                return identity;
            }

            if(l <= tL and r >= tR) { // corrected condition
                return tree[idx];
            }

            int mid = tL + (tR - tL) / 2;

            return merge(func(2*idx + 1, tL, mid), func(2*idx + 2, mid+1, tR));
        };

        return func(0, 0, N-1);
    }

};

signed main() {

    int n, q;
    cin >> n >> q;

    SegmentTree<int> st(n, INT_MAX);

    for(int i = 0; i < n; i++) {
        int x;
        cin >> x;
        st.update(i, x);
    }

    while(q--) {
        int t, a, b;
        cin >> t >> a >> b;

        if(t == 1) {
            st.update(a-1, b);
        } else {
            cout << st.query(a-1, b-1) << endl;
        }

    }

}
