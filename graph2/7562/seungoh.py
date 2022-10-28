### 시간 초과 ㅠㅠ ###
import sys
from collections import deque

def bfs(x, y):
    if start == end:
        return 0
    queue = deque()
    queue.append((x, y))
    stop = False
    while queue:
        x, y = queue.popleft()
        for k in range(8):
            nx = x + dx[k]
            ny = y + dy[k]
            if nx < 0 or nx > (N-1) or ny < 0 or ny > (N-1):
                continue
            if graph[nx][ny] == 0:
                queue.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1
            if [nx, ny] == end:
                stop = True
                break
        if stop:
            break
    return graph[end[0]][end[1]]

answers = []
X = int(sys.stdin.readline())

for _ in range(X):
    N = int(sys.stdin.readline())
    start = list(map(int, sys.stdin.readline().split()))
    end = list(map(int, sys.stdin.readline().split()))
    graph = [[0 for _ in range(N)] for _ in range(N)]

    dx = [1, 1, 2, 2, -1, -1, -2, -2]
    dy = [-2, 2, -1, 1, -2, 2, -1, 1]

    answers.append(bfs(start[0], start[1]))

for answer in answers:
    print(answer)