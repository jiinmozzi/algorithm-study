import sys

count = 0
melody, pret = map(int, sys.stdin.readline().split())
curPos = dict() 
for _ in range(melody):
    m, p = map(int, sys.stdin.readline().split())
    if m in curPos:
        target = curPos[m][-1]
        if p > target:
            count += 1
            curPos[m].append(p)
        elif p == target:
            continue
        else:
            while(len(curPos[m]) > 0 and  p < curPos[m][-1]):
                curPos[m].pop()
                count += 1
            if(len(curPos[m]) > 0 and p == curPos[m][-1]):
                continue
            curPos[m].append(p)
            count += 1
    else:
        curPos[m] = [p]
        count += 1

print(count)