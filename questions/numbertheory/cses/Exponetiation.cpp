using namespace std;

const long long MOD = 1e9 + 7;

long long power(long long n, long long pow) {
    if (pow == 0) return 1;

    if (pow % 2 == 0) {
        long long half = power(n, pow / 2);
        return (half%MOD * half%MOD)%MOD;
    } else {
        return (n * power(n, pow - 1)%MOD)%MOD;
    }
}