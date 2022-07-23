import sys

n = int(sys.stdin.readline())

scores = []

for _ in range(n):
    score = float(input())
    scores.append(score)

scores.sort()

for i in range(7):
    print('{:.3f}'.format(scores[i]))

