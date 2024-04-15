from collections import defaultdict


def dfs(graph, start):
    n = len(graph)
    dist = [0]*n
    subtree = [1]*n
    visited = [False]*n
    stack = [start]
    parents = {start: -1}

    while stack:
        node = stack[-1]
        if not visited[node]:
            visited[node] = True
            for child in graph[node]:
                if child != parents[node]:
                    parents[child] = node
                    stack.append(child)
        else:
            stack.pop()
            for child in graph[node]:
                if child != parents[node]:
                    subtree[node] += subtree[child]
                    dist[node] += dist[child] + subtree[child]

    return dist, subtree


def dfs2(graph, start, dist, subtree):
    n = len(graph)
    visited = [False]*n
    stack = [start]
    parents = {start: -1}

    while stack:
        node = stack[-1]
        if not visited[node]:
            visited[node] = True
            for child in graph[node]:
                if child != parents[node]:
                    parents[child] = node
                    stack.append(child)
        else:
            stack.pop()
            if parents[node] != -1:
                dist[node] = dist[parents[node]] - \
                    subtree[node] + n - subtree[node]

    return dist


n = int(input())
graph = defaultdict(list)
for _ in range(n-1):
    u, v = map(int, input().split())
    graph[u-1].append(v-1)
    graph[v-1].append(u-1)

dist, subtree = dfs(graph, 0)
dist = dfs2(graph, 0, dist, subtree)
min_dist = min(dist)
min_nodes = [i+1 for i in range(n) if dist[i] == min_dist]
print(len(min_nodes))
print(*min_nodes)
