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