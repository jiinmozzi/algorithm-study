n = int(input())

pivot = 0
results = []
targetArr = []
answerArr = []
stack = []
fail = False
for _ in range(n):
    m = int(input())
    targetArr.append(m)

for target in targetArr:
    if target > pivot:
        for i in range(1, target - pivot + 1):
            stack.append(pivot + i)
            results.append('+')
        pivot = target
        results.append('-')
        answerArr.append(stack.pop())
    else:
        prev = stack.pop()
        if prev != target:
            fail = True
            break
        results.append('-')
        answerArr.append(prev)

if fail:
    print('NO')
else:
    for x in results:
        print(x)

