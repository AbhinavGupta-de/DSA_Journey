def count_subarrays(arr):
    prefix_sum = 0
    count = 0
    # Initialize with 0 to handle cases where prefix sum is equal to 0
    prefix_counts = {0: 1}

    for num in arr:
        prefix_sum += num
        if prefix_sum >= 0:
            count += 1
        if prefix_sum in prefix_counts:
            count += prefix_counts[prefix_sum]
            prefix_counts[prefix_sum] += 1
        else:
            prefix_counts[prefix_sum] = 1

    return count


def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = list(map(int, input().split()))
        print(count_subarrays(arr))


main()
