def minimizeStringValue(s: str) -> str:
    freq = [0] * 26
    for char in s:
        if char.isalpha():
            freq[ord(char) - ord('a')] += 1

    for char in s:
        if char == '?':
            minDASH = min(freq)
            for i in range(26):
                if freq[i] == minDASH:
                    s = s.replace('?', chr(i + ord('a')), 1)
                    freq[i] += 1
                    break
    return s


print(minimizeStringValue("???"))
