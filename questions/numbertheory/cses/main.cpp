#include <iostream>
using namespace std;

long long power(long long n, long long pow, long long MOD) {
    if (pow == 0) return 1;

    if (pow % 2 == 0) {
        long long half = power(n, pow / 2, MOD) % MOD;
        return (half * half) % MOD;
    } else {
        return (n * power(n, pow - 1, MOD) % MOD) % MOD;
    }
}

long long ans(long long a, long long b, long long c) {
    long long MOD = 1e9 + 7;
    long long r = power(b, c, MOD - 1);
    return power(a, r, MOD) % MOD;
}

int main() {
    int t;
    cin >> t;

    while (t-- > 0) {
        long long a, b, c;
        cin >> a >> b >> c;

        cout << ans(a, b, c) << endl;
    }

    return 0;
}
