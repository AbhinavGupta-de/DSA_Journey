#include<vector>
#include<bits/stdc++.h>
#include<iostream>

using namespace std;

int main() {

//    standard input output operations
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, q;

    cin >> n >> q;

    vector<int> a(n);

    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    vector<int> prefixXOR(n);

    prefixXOR[0] = a[0];
    for(int i = 1; i < n; i++) {
       prefixXOR[i] = prefixXOR[i-1] ^ a[i];
    }

    while(q--) {
        int l, r;
        cin >> l >> r;

        if(l == 1) {
            cout << prefixXOR[r-1] << endl;
        } else {
            cout << (prefixXOR[r-1] ^ prefixXOR[l-2]) << endl;
        }
    }

    return 0;

}