from collections import defaultdict


def min_swaps(n, colors, values):
    # Create a dictionary to store indices for each color group
    color_groups = defaultdict(list)

    # Store indices in their respective color groups
    for i, (color, value) in enumerate(zip(colors, values)):
        color_groups[color].append((value, i))

    swaps = 0

    # Process each color group
    for group in color_groups.values():
        # Sort the values in each group
        group.sort()

        # Swap elements to their correct positions
        for i, (value, idx) in enumerate(group):
            if i != idx:
                values[i], values[idx] = values[idx], values[i]
                swaps += 1

    # Check if it's possible to sort the array
    if sorted(values) == values:
        return swaps
    else:
        return -1


# Take input from the user
n = int(input())
colors = list(map(int, input().split()))
values = list(map(int, input().split()))

print(min_swaps(n, colors, values))
