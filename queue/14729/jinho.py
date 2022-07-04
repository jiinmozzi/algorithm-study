import sys
from collections import deque

queue = deque()
N = int(input())
for _ in range(N):
    queue.append(float(sys.stdin.readline().strip()))
# data = list(map(float, sys.stdin.readline().split())) 
# [queue.append(i) for i in data]
min_score = min(queue)

count = 0
while count < 7:
    num = queue.popleft()
    if num == min_score:
        count +=1
        print("%.3f" %num)
        min_score = min(queue)
    else:
        queue.append(num)