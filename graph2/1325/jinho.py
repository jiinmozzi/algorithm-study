import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

matrix = []
for _ in range(N+1):
    matrix.append([])

for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())
    matrix[j].append(i)

counts = []

def bfs(graph, v):
    while len(queue)>0:
        tgt = queue.popleft()
        if tgt not in bfs_visited:
            bfs_visited.append(tgt)
            for i in range(len(graph[tgt])):
                queue.append(graph[tgt][i])
    return len(bfs_visited)

for i in range(N):
    queue = deque([i+1])
    bfs_visited = []
    cnt = bfs(matrix, i+1)
    counts.append(cnt)

max = max(counts)

for i in range(len(counts)):
    if counts[i] is max:
        print(i+1)