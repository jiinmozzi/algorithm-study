from collections import deque

N, M = map(int, input().split())
matrix = []
result = []

for _ in range(N):
    matrix.append(list(map(int, input())))
    result.append([0] * M)

result[0][0] = 1
visited = []
def bfs(x, y):
    queue = deque()
    queue.append([x,y])
    while queue:
        x, y = queue.popleft()
        if result[N-1][M-1] > 1:
            return result[N-1][M-1]
        if 101*x + y not in visited:
            visited.append(101*x + y)
            if x+1<N and matrix[x+1][y]==1:
                result[x+1][y] = result[x][y] + 1
                # bfs_visited.append([x+1, y])
                queue.append([x+1, y])

            if y+1<M and matrix[x][y+1]==1:
                result[x][y+1] = result[x][y] + 1
                # bfs_visited.append([x, y+1])
                queue.append([x, y+1])
            
            if x>0 and matrix[x-1][y]==1:
                result[x-1][y] = result[x][y] + 1
                # bfs_visited.append([x-1, y])
                queue.append([x-1, y])

            if y>0 and matrix[x][y-1]==1:
                result[x][y-1] = result[x][y] + 1
                # bfs_visited.append([x, y-1])
                queue.append([x, y-1])

    return result[N-1][M-1]

print(bfs(0, 0))
