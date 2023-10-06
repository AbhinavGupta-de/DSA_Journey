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
