import sys
# sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input())

tree = [[] for _ in range(N+1)]
visited = []
for _ in range(N+1):
    visited.append(0)

for i in range(N-1):
    x, y = map(int, input().split())
    tree[x].append(y)
    tree[y].append(x)

def dfs(node):
    for i in tree[node]:
        if visited[i] == 0:
            visited[i] = node
            dfs(i)

dfs(1)

for i in range(2, N+1):
    print(visited[i])

