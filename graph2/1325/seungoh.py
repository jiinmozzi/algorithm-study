import sys

INF = int(1e9)

N, M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]
distance = [-1] * (N+1)
visited = [False] * (N+1)

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)  

def get_biggest_node():
    max_value = -1
    index = 0
    for i in range(N+1):
        if distance[i] > max_value and not visited[i]:
            max_value = distance[i]
            index = i
    return index

def dijkstra(start):
    distance[start] = 0
    visited[start] = True
    for k in graph[start]:
        distance[k] = 1
    
    for i in range(N-1):
        now = get_biggest_node()

        visited[now] = True
        for j in graph[now]:
            cost = distance[now] + 1    


