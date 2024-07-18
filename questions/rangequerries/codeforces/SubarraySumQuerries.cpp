#include <iostream>
#include <bits/stdc++.h>
#define int long long
#define mod 1000000007

// similar https://codeforces.com/edu/course/2/lesson/4/2/practice/contest/273278/problem/A

using namespace std;

class Node{
public:
    int mx_prefix = 0;
    int mx_suffix = 0;
    int mx_subarr = 0;
    int total_sum=0;
};

Node merge(Node a, Node b){
    Node ans;
    ans.mx_prefix = max(a.mx_prefix,a.total_sum+b.mx_prefix);
    ans.mx_suffix = max(b.mx_suffix,b.total_sum+a.mx_suffix);
    ans.mx_subarr= max({a.mx_subarr,b.mx_subarr,a.mx_suffix+b.mx_prefix});
    ans.total_sum = a.total_sum+b.total_sum;
    return ans;
}

template<typename T>
class SegmentTree{
public:
    int N;
    T identity;
    vector<T> tree;

    SegmentTree(int n,T identity){
        N = n;
        this->identity = identity;
        tree.assign(4*N,identity);
    }

    void update(int qIdx, T val){
        function<void(int,int,int)> func = [&](int tIdx,int tLeft, int tRight){
            if(tLeft == tRight){
                tree[tIdx] = val;
                return;
            }
            int tMid = tLeft + (tRight-tLeft)/2;
            if(tLeft<=qIdx and qIdx<=tMid){
                func(2*tIdx+1,tLeft,tMid);
            }else{
                func(2*tIdx+2,tMid+1,tRight);
            }
            tree[tIdx] = merge(tree[2*tIdx+1],tree[2*tIdx+2]);
        };
        func(0,0,N-1);
    }

    T query(int l, int r){
        function<T(int,int,int)> func = [&](int tIdx, int tLeft, int tRight){
            // no overlap
            if(r<tLeft or l>tRight){
                return identity;
            }

            // complete overlap
            if(l<=tLeft and tRight<=r){
                return tree[tIdx];
            }

            // partial overlap
            int tMid = tLeft + (tRight-tLeft)/2;
            return merge(func(2*tIdx+1,tLeft,tMid),func(2*tIdx+2,tMid+1,tRight));
        };
        return func(0,0,N-1);
    }
};

int solve(){

}

signed main(){
    int n,m;
    cin >> n >> m;
    SegmentTree<Node> st(n,Node{0,0,0,0});
    for(int i=0;i<n;i++){
        int x;
        cin >> x;
        st.update(i,{x,x,x,x});
    }
    cout << max(0LL,st.query(0,n-1).mx_subarr) << endl;
    for(int i=0;i<m;i++){
        int idx,val;
        cin >> idx >> val;
        st.update(idx,{val,val,val,val});
        cout << max(0LL,st.query(0,n-1).mx_subarr) << endl;
    }
    return 0;
}