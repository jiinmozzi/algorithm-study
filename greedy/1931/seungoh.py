import sys

array = []
N = int(sys.stdin.readline())
for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    array.append((x, y))

newArray = sorted(array, key = lambda x : (x[1], x[0]))

count = 0
curTime = -1

for m in newArray:
    print(m)
    if m[0] >= curTime:
        curTime = m[1]
        count += 1

print(count)