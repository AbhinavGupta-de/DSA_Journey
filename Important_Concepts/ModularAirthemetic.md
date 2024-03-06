# Modular Airthemetic

## Modular Airthemetic

- Modular Airthemetic is a system of arithmetic for integers, where numbers "wrap around" upon reaching a certain value—the modulus (plural moduli).

- The congruence relation is defined as follows:

  - a ≡ b (mod n) if and only if n | (a - b)
  - a ≡ b (mod n) if and only if a and b leave the same remainder when divided by n

- The modulus is the number n in the congruence relation. For example, 38 ≡ 14 (mod 12) because 12 | (38 - 14).

## Some Properties

- (a + b) % m = (a % m + b % m) % m
- (a - b) % m = (a % m + -b % m + m) % m
- (a _ b) % m = (a % m _ b % m) % m
- (a / b) % m = (a % m \* b^-1 % m) % m
- (a ^ b) % m = (a % m ^ b % m) % m

## Modular Inverse

- The modular inverse of a number a (mod m) is a number x such that:

  - a \* x ≡ 1 (mod m)
  - x is the multiplicative inverse of a modulo m

- The modular inverse exists if and only if a and m are coprime (i.e. gcd(a, m) = 1)
