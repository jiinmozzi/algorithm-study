n = int(input())

for _ in range(n):
    ok = True
    count = 0
    string = input()
    for x in string:
        if x == '(':
            count -= 1
        if x == ')':
            count += 1
        if count > 0:
            ok = False
            break
    if(ok and count == 0):
        print('YES')
    else:
        print('NO')