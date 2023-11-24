# Bit Manipulation

## XOR

- XOR of a number with itself is 0.

- XOR of a number with 1 return the complement of the number.

- XOR of a number with 0 return the number itself.

- XOR of two numbers is 0 if both numbers are same.

- A ^ B ^ A = B

- A ^ B ^ C = A ^ C ^ B

- A ^ B = B ^ A

- A ^ B ^ A = B ^ A ^ A = B ^ (A ^ A) = B ^ 0 = B

## Complement

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
n\  \& \ (n-1) = 10100000
$$

## What does n & (-n) do?

- It gives the last set bit of n.

For example:

$$
n = 10101000
$$

$$
-n = 01011000
$$

$$
n\  \& \ (-n) = 00001000
$$

## What does n | (n-1) do?

- It gives the number formed by setting all the bits after the last set bit of n.

For example:

$$
n = 10101000
$$

$$
n-1 = 10100111
$$

$$
n\  | \ (n-1) = 10101111
$$

## Questions

### Check ith bit is set or not

We can check if the ith bit is set or not by using the following formula

$$
n\  \& \ (1 << i) \neq 0
$$

What does it do?

- It shifts 1 by i bits to the left and then performs AND operation with n.
- If the ith bit is set then the result will be non-zero.
- If the ith bit is not set then the result will be zero.

Example:

$$
n = 10101000
$$

$$
1 << 3 = 00001000
$$

$$
n\  \& \ (1 << 3) = 00001000 \neq 0
$$

Code

```java
boolean checkIthBit(int n, int i) {
    return (n & (1 << i)) != 0;
}
```

---

### Set ith bit

We can set the ith bit by using the following formula

$$
n\  | \ (1 << i)
$$

What does it do?

- It shifts 1 by i bits to the left and then performs OR operation with n.
- If the ith bit is not set then it will be set.
- If the ith bit is already set then it will remain set.

Example:

$$
n = 10101000
$$

$$
1 << 3 = 00001000
$$

$$
n\  | \ (1 << 3) = 10101000
$$

Code

```java
int setIthBit(int n, int i) {
    return n | (1 << i);
}
```

---

### Unset ith bit

We can unset the ith bit by using the following formula

$$
n\  \& \ \sim (1 << i)
$$

What does it do?

- It shifts 1 by i bits to the left and then performs AND operation with n.
- If the ith bit is set then it will be unset.
- If the ith bit is already unset then it will remain unset.

Example:

$$
n = 10101000
$$

$$
1 << 3 = 00001000
$$

$$
n\  \& \ \sim (1 << 3) = 10100000
$$

Code

```java
int unsetIthBit(int n, int i){
 return n & ~(i << i);
}
```

---

### Toggle ith bit

We can toggle the ith bit by using the following formula

$$
n\  \oplus \ (1 << i)
$$

What does it do?

- It shifts 1 by i bits to the left and then performs XOR operation with n.
- If the ith bit is set then it will be unset.
- If the ith bit is already unset then it will be set.

Example:

$$
n = 10101000
$$

$$
1 << 3 = 00001000
$$

$$
n\  \oplus \ (1 << 3) = 10100000
$$

Code

```java
int toggleIthBit(int n, int i){
 return n ^ (i << i);
}
```

---

### Find Minimum XOR value pair

Given an array of integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

Example:

```
Input: arr[] = {9, 5, 3}
Output: 6
Explanation: Minimum XOR value is 6 for the pair (9, 3).
```

Code

```java
int minxorpair(int n, int arr[]) {
    Arrays.sort(arr);
    int minxor = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++) {
        minxor = Math.min(minxor, arr[i] ^ arr[i + 1]);
    }
    return minxor;
}
```

---

### Find max AND value pair

Given an array of integers, find the pair of integers in the array which have maximum AND value.

Example:

```
Input: arr[] = {27, 18, 20}
Output: 18
Explanation: Maximum AND value is 26 for the pair (18, 27).
```

Code

```java
int maxAND (int arr[], int n) {
  int ans = 0;
  for (int i = 31; i >= 0; i--) {
   int count = 0;
   for (int j : arr) {
    if ((j & (1 << i)) > 0) {
     count++;
    }
   }

   if (count >= 2) {
    ans |= (1 << i);
    for (int j : arr) {
     if ((j & (1 << i)) > 0) {
      j = 0;
     }
    }
   }
  }

  return ans;
}
```
