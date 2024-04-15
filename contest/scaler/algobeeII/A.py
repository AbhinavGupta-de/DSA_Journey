MOD = 10**9+7


def pow_mod(x, y):
    if y == 0:
        return 1
    elif y % 2 == 0:
        return pow_mod((x*x) % MOD, y//2) % MOD
    else:
        return (x*pow_mod((x*x) % MOD, y//2)) % MOD


def sum_divisors(n, p):
    return (pow_mod(n, p+1) - 1) * pow_mod(n-1, MOD-2) % MOD


def solve():
    n = int(input().strip())
    result = 1
    for _ in range(n):
        p, a = map(int, input().strip().split())
        result *= sum_divisors(pow_mod(p, 69), a)
        result %= MOD
    return result


print(solve())
