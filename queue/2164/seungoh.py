from collections import deque

queue = deque()

n = int(input())
for i in range(1, n+1):
    queue.append(i)

while len(queue) > 1:
    queue.popleft()
    top = queue.popleft()
    queue.append(top)

result = queue.popleft()
print(result)