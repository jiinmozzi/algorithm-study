import sys

N = int(sys.stdin.readline())
graph = []

for _ in range(N):
    graph.append(list(map(lambda a: [int(a), dict({
        'H': 0,
        'V': 0,
        'D': 0
    })], sys.stdin.readline().split())))

graph[0][1][1]['H'] = 1
print(graph)

## bfs 갈 수 있는 후보지는 3개
