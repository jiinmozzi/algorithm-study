import sys
import math

K = int(sys.stdin.readline())
count = 0

def downgrade():
    global K
    global count
    x = 1
    N = 0
    while N < K:
        N = math.pow(2, x)
        x += 1
    N = int(N // 2)
    K = K - N
    count += 1

while K != 1:
    downgrade()

if(count % 2 == 0):
    print(0)
else:
    print(1)