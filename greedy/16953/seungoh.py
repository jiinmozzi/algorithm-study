import sys

A, B = map(int, sys.stdin.readline().split())

count = 1
while True:
    if B == A:
        break
    if B < A:
        count = -1
        break

    if B % 2 == 0:
        B /= 2
        count += 1
        continue
    elif B % 10 == 1:
        B //= 10
        count += 1
        continue
    else:
        count = -1
        break

print(count)