import sys

str = sys.stdin.readline()
arr = []
calculatedArr = []

str = str.split('-')
for s in str:
    arr.append(list(map(int, s.split('+'))))

for i in range(len(arr)):
    sum = 0
    for x in arr[i]:
        sum += x
    calculatedArr.append(sum)

answer = calculatedArr[0]
for j in range(1, len(calculatedArr)):
    answer -= calculatedArr[j]
print(answer)
