#include <iostream>
#include <vector>
#include <map>

using namespace std;

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        vector<int> arr(n);
        for (int& a : arr) {
            cin >> a;
        }

        // Prefix Sum
        vector<long long> prefixSum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        // Find the number of subarrays with sum greater than or equal to 0
        long long count = 0;
        map<long long, long long> prefixCounts;
        prefixCounts[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (auto it = prefixCounts.lower_bound(prefixSum[i]); it != prefixCounts.end(); it++) {
                count += it -> second;
            }
            prefixCounts[prefixSum[i]]++;
        }

        cout << count << endl;
    }

    return 0;
}