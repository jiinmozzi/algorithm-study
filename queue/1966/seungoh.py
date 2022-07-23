from collections import deque

queue = deque()

dict = dict()
n, m = map(int, input().split())
numArr = list(map(int, input().split()))
numset = set(numArr)
count = 0

for n in numArr:
    queue.append(n)
    if n in dict:
        dict[n] += 1
    else:
        dict[n] = 1

print(dict)
print(numset)