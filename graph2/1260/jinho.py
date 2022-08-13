import sys
from collections import deque

N, M, init = map(int, sys.stdin.readline().split())
bfs_matrix = [[0] * (N + 1) for _ in range(N + 1)] 
dfs_matrix = [[0] * (N + 1) for _ in range(N + 1)] 
for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())
    dfs_matrix[i][j] = 1
    dfs_matrix[j][i] = 1
    bfs_matrix[i][j] = 1
    bfs_matrix[j][i] = 1

dfs_visited = [init]
def dfs(graph, v):
    for i in range(len(graph[v])):
        if graph[v][i] == 1 and i not in dfs_visited:
            
            dfs_visited.append(i)
            dfs(graph, i)

dfs(dfs_matrix, init)


bfs_visited = []
queue = deque([init])
def bfs(graph, v):
    while len(queue)>0:
        
        tgt = queue.popleft()
        if tgt not in bfs_visited:
            bfs_visited.append(tgt)
        for i in range(len(graph[tgt])):
            if graph[tgt][i] == 1 and i not in bfs_visited:
                queue.append(i)
                
bfs(bfs_matrix, init)

print(*dfs_visited)
print(*bfs_visited)
