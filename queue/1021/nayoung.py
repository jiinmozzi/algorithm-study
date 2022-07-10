#
# 1021. 회전하는 큐
# https://www.acmicpc.net/problem/1021
#

import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
q = deque()
result = 0

for i in range(N):
    q.append(i+1)

for i in range(M):
    index = q.index(arr[i])
    if index <= len(q) // 2:     # move left
        for _ in range(index):
            q.append(q.popleft())
            result += 1
        q.popleft()
    else:   # move right
        for _ in range(len(q) - index):
            q.appendleft(q.pop())
            result += 1
        q.popleft()
    
print(result)
