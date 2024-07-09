#include <iostream>
#include <vector>
using namespace std;

const int MAX = 2000010;
const long long MOD = 1000000007;

vector<long long> fact(MAX);
vector<long long> invFact(MAX);

long long power(long long a, long long b) {
    if (b == 0) return 1;
    long long res = power(a, b / 2);
    res = (res * res) % MOD;
    if (b % 2 != 0) res = (res * a) % MOD;
    return res;
}

void precomputeFactorials() {
    fact[0] = 1;
    for (int i = 1; i < MAX; ++i) {
        fact[i] = fact[i - 1] * i % MOD;
    }
    invFact[MAX - 1] = power(fact[MAX - 1], MOD - 2);
    for (int i = MAX - 2; i >= 0; --i) {
        invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }
}

long long binomial(long long a, long long b) {
    if (a < b) return 0;
    return fact[a] * invFact[b] % MOD * invFact[a - b] % MOD;
}

int main() {
    precomputeFactorials();

    int a, b;
    cin >> a >> b;

    cout << binomial(a + b - 1, a - 1) % MOD << endl;

    return 0;
}
