import bisect


def solve(queries):
    S = []
    X = [0]
    for query in queries:
        if query[0] == 1:
            temp = S[:]
            x = query[1]
            S.append(x)
            for i in range(len(temp)):
                y = temp[i] ^ x
                S.append(y)
                bisect.insort(X, y)
            bisect.insort(X, x)
        else:
            print(X[query[1]-1] if query[1] <= len(X) else -1)


Q = int(input())
queries = []
for _ in range(Q):
    queries.append(list(map(int, input().split())))
solve(queries)
