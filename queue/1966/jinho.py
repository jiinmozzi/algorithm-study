import sys
from collections import deque

N = int(input())

for _ in range(N):
    queue = deque()
    n, target = map(int, sys.stdin.readline().split())
    lst = list(map(int, sys.stdin.readline().split()))
    [queue.append(i) for i in lst]
    
    count = 0
    while True:
        if queue[0] == max(queue) and target == 0:
            queue.popleft()
            count += 1
            break
        elif queue[0] == max(queue):
            queue.popleft()
            count += 1
        else:
            queue.append(queue.popleft())
        
        target = target-1 if target-1 >= 0 else target-1+len(queue)
        print(f"queue : {queue}")
        print(f"count : {count}")

    print(count)
