import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
data = list(map(int, sys.stdin.readline().split()))

queue = deque()
for i in range(1, N+1):
    queue.append(i)

count = 0
while len(data) > 0:
    idx = queue.index(data[0])
    distance = min(idx, len(queue) - idx)
    if distance == idx:
        for _ in range(idx):
            queue.append(queue.popleft())
    else:
        for _ in range(len(queue)-idx):
            queue.appendleft(queue.pop())
    count += distance
    data.pop(0)
    queue.popleft()
    
print(count)