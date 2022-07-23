import sys

# data = list(map(int, sys.stdin.readline().split()))
input = sys.stdin.readline().rstrip()
data = input.split("-")
_data = list(map(lambda x : list(map(int, x.split("+"))),data))

sum = 0
for _ in range(len(_data[0])):
    sum += _data[0][_]

for i in range(1, len(_data)):
    for j in range(len(_data[i])):
        sum -= _data[i][j]

print(sum)