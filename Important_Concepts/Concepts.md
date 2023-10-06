# Important Concepts from DSA

## Bit Manipulation

### XOR

- XOR of a number with itself is 0.

- XOR of a number with 1 return the complement of the number.

- XOR of a number with 0 return the number itself.

- XOR of two numbers is 0 if both numbers are same.

- A ^ B ^ A = B

- A ^ B ^ C = A ^ C ^ B

- A ^ B = B ^ A

- A ^ B ^ A = B ^ A ^ A = B ^ (A ^ A) = B ^ 0 = B

### Complement

- Complement of a number is the number obtained by changing all the 1s to 0s and all 0s to 1s.

- Complement of a number can be found by XORing it with all 1s i.e. 2^n - 1.

## Bitwise Operators

### Left Shift Operator(<<)

- Left shift operator is used to shift the bits of the number to the left side.

- Left shifting a number by one is equivalent to multiplying it by 2.

- A << B = A \* 2^B

### Right Shift Operator(>>)

- Right shift operator is used to shift the bits of the number to the right side.

- Right shifting a number by one is equivalent to dividing it by 2.

- A >> B = A / 2^B

## Number of digits trick

$$
\log_x{n} = y
$$

This means that n has int(y) + 1 number of digits in base x.

## Pascal's Traingle's Sum

$$
\sum_{i=0}^{n} \binom{n}{i} = 2^{n-1}
$$

This can be calculated using bit manipulation.

$$
1 \ll (n-1) = 2^{(n-1)}
$$

## What does n & (n-1) do?

- It removes the last set bit of n.

For example:

$$
n = 10101000
$$

$$
n-1 = 10100111
$$

$$
n \& (n-1) = 10100000
$$
