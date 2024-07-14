#include<vector>
#include<bits/stdc++.h>
#include<iostream>
using namespace std;

const int MAX = 1e6 + 1;
int divisors[MAX];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;

    cin >> n;

    int nums[n];

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    for(int i = 0; i < n; i++) {
        int upper = sqrt(nums[i]);
        for(int div = 1; div <= upper; div++) {
            if(nums[i] % div == 0) {
                divisors[div]++;
                if(div != nums[i] / div) {
                    divisors[nums[i] / div]++;
                }
            }
        }
    }

    for(int i = MAX; i >= 1; i--) {
        if(divisors[i] > 1) {
            cout << i << endl;
            break;
        }
    }

    return 0;
}