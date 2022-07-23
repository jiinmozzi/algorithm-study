import sys

N = int(sys.stdin.readline())

answer = 0
x = N // 5
while True:

    rest = N - (x * 5)
    if rest % 3 == 0:
        y = rest / 3
        answer = x + y
        break
    else:
        if x <= 0:
            answer = -1
            break
        x -= 1

print(int(answer))
