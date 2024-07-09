#include <iostream>
#include <vector>
using namespace std;

const int MAX = 1000001;
const long long MOD = 1000000007;

vector<long long> fact(MAX);
vector<long long> invFact(MAX);

long long power(long long a, long long b, long long mod) {
    if(b == 0) return 1;
    long long res = power(a, b / 2, mod);
    res = (res * res) % mod;
    if(b % 2 != 0) res = (res * a) % mod;
    return res;
}

void precomputeFactorials(long long mod) {
    fact[0] = 1;
    for(int i = 1; i < MAX; ++i) {
        fact[i] = fact[i - 1] * i % mod;
    }
    invFact[MAX - 1] = power(fact[MAX - 1], mod - 2, mod);
    for(int i = MAX - 2; i >= 0; --i) {
        invFact[i] = invFact[i + 1] * (i + 1) % mod;
    }
}

long long binomial(long long a, long long b, long long mod) {
    if(a < b) return 0;
    return fact[a] * invFact[b] % mod * invFact[a - b] % mod;
}

int main() {
    precomputeFactorials(MOD);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        long long a, b;
        cin >> a >> b;
        cout << binomial(a, b, MOD) << endl;
    }

    return 0;
}