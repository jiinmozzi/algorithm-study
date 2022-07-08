#
# 1966. 프린터 큐
# https://www.acmicpc.net/problem/1966
#

import sys
from collections import deque

T = int(sys.stdin.readline())

for _ in range(T):
    N, M = map(int, sys.stdin.readline().split(" "))
    docs = list(map(int, sys.stdin.readline().split(" ")))

    q = deque()

    for i, v in enumerate(docs):
        q.append((i, v))
    
    cnt = 1

    while True:
        isPrintable = True

        for i in range(1, len(q)):
            if q[0][1] < q[i][1]:
                q.append(q.popleft())
                isPrintable = False
                break

        if isPrintable:
            if q[0][0] == M:    # M is printed
                print(cnt)
                break
            else:
                q.popleft()
                cnt += 1
