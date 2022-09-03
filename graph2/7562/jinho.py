import sys
from collections import deque

n = int(sys.stdin.readline())

def validate(x, y, N):
    if N*x+y not in visited and x >=0 and x<N and y >= 0 and y < N:
        return True
    return False

def bfs(x, y, tgt_x, tgt_y, N):
    result = [ [0] * N for i in range(N) ]
    
    queue = deque()
    queue.append((x, y))
    
    while queue:
        
        if result[tgt_x][tgt_y] > 0:
            break
        x, y = queue.popleft()
        if N*x + y not in visited:
            visited.append(N*x + y)

            if validate(x+2, y+1, N):
                queue.append((x+2, y+1))
                result[x+2][y+1] = result[x][y] + 1

            if validate(x+2, y-1, N):
                queue.append((x+2, y-1))
                result[x+2][y-1] = result[x][y] + 1

            if validate(x-2, y+1, N):
                queue.append((x-2, y+1))
                result[x-2][y+1] = result[x][y] + 1

            if validate(x-2, y-1, N):
                queue.append((x-2, y-1))
                result[x-2][y-1] = result[x][y] + 1

            if validate(x+1, y+2, N):
                queue.append((x+1, y+2))
                result[x+1][y+2] = result[x][y] + 1

            if validate(x+1, y-2, N):
                queue.append((x+1, y-2))
                result[x+1][y-2] = result[x][y] + 1

            if validate(x-1, y+2, N):
                queue.append((x-1, y+2))
                result[x-1][y+2] = result[x][y] + 1

            if validate(x-1, y-2, N):
                queue.append((x-1, y-2))
                result[x-1][y-2] = result[x][y] + 1 

    return result[tgt_x][tgt_y]

results = []
for i in range(n):
    N = int(sys.stdin.readline())
    init_x, init_y = map(int, sys.stdin.readline().split())
    end_x, end_y = map(int, sys.stdin.readline().split())
    visited = []
    
    if init_x == end_x and init_y == end_y:
        results.append(0)
    else:
        results.append(bfs(init_x, init_y, end_x, end_y, N))

print(*results, sep="\n")
    