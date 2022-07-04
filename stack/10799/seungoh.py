curBars = 0
lazerCounts = []
result = 0

strX = input()
strY = strX.replace('()', 'L')

for y in strY:
    if y == '(':
        curBars += 1
    if y == 'L':
        result += curBars
    if y == ')':
        result += 1
        curBars -= 1

print(result)
