#include <iostream>
#include <vector>
using namespace std;

int main() {
    int max = 1000001;
    vector<int> divisors(max, 0);
    for(int i = 1; i < max; i++) {
        for(int j = i; j < max; j += i) {
            divisors[j]++;
        }
    }

    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        int x;
        cin >> x;
        cout << divisors[x] << endl;
    }

    return 0;
}
