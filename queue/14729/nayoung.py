#
# 14729. 칠무해
# https://www.acmicpc.net/problem/14729
#

import sys

N = int(sys.stdin.readline())

grades = []

for _ in range(N):
    grades.append(float(sys.stdin.readline()))

grades.sort()

for i in range(7):
    print('{:.3f}'.format(grades[i]))
