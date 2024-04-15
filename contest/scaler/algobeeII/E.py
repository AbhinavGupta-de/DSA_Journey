def find_kth_number(L, R, k, S, mn, mx):
    prime_digits = {2, 3, 5, 7}
    numbers = []

    for num in range(L, R+1):
        str_num = str(num)
        if not (mn <= min(map(int, str_num)) <= max(map(int, str_num)) <= mx):
            continue
        prime_sum, non_prime_sum = 0, 0
        for digit in map(int, str_num):
            if digit in prime_digits:
                prime_sum += digit
            else:
                non_prime_sum += digit
        if abs(prime_sum - non_prime_sum) <= S:
            numbers.append(num)

    return numbers[k-1] if k <= len(numbers) else -1

L, R, k, S, mn, mx = map(int, input().split())
print(find_kth_number(L, R, k, S, mn, mx))