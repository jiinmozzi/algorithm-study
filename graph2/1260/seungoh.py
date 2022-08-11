import sys
from collections import deque

def dfs(graph, n, visited):
    visited[n] = True
    print(n, end=" ")
    if len(graph[n]) == 0:
        return
    for i in graph[n]:
        if not visited[i]:
            dfs(graph, i, visited)

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    print("")
    print(start, end=" ")
    while queue:
        v = queue.popleft()
        if len(graph[n]) == 0:
            return
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                print(i, end=" ")
    print("")
 
n, m, start = map(int, sys.stdin.readline().split())
visited = [False] * (n+1)
graph = [[] for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)
for i in range(len(graph)):
    graph[i].sort()

dfs(graph, start, visited)
visited = [False] * (n+1)
bfs(graph, start, visited)
