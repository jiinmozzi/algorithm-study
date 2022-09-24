import sys

N = int(sys.stdin.readline())
answerArr = [0, 0, 0]

graph = [[] for _ in range(N)]

for i in range(N):
    graph[i] = list(map(int, sys.stdin.readline().split()))

# 전체 동일한 숫자만 있는지 체크, 동일하면 해당 숫자를, 없으면 -2를 리턴
def check_box(graph, x, y, length):
    k = graph[x][y]
    for i in range(x, x+length):
        for j in range(y, y+length):
            if graph[i][j] != k:
                return -2
    return k

# 9개의 작은 박스로 나누기. 3 나눗셈을 활용하여 어디 집어넣을지 계산
def divide(box):
    K = len(box)
    division = K // 3
    small_box_list = [
        [[0 for _ in range(division)] for _ in range(division)] for _ in range(9)
    ]
    
    for i in range(K):
        for j in range(K):
            x = i // division
            y = j // division
            box_num = 3 * x + y
            box_x = i % division
            box_y = j % division
            small_box_list[box_num][box_x][box_y] = box[i][j]   
    
    return small_box_list

# 현재 박스를 체크해본뒤, 동일 숫자면 answerArr 업데이트 & 아니면 9개로 나눠서 재귀반복 실행
def main(graph, x, y, length):
    check_num = check_box(graph, x, y, length)
    if check_num == -2:
        division = length // 3
        main(graph, x, y, division)
        main(graph, x + (division * 1), y, division)
        main(graph, x + (division * 2), y, division)
        main(graph, x, y + (division * 1), division)
        main(graph, x + (division * 1), y + (division * 1), division)
        main(graph, x + (division * 2), y + (division * 1), division)
        main(graph, x, y + (division * 2), division)
        main(graph, x + (division * 1), y + (division * 2), division)
        main(graph, x + (division * 2), y + (division * 2), division)

    else:
        answerArr[check_num+1] += 1


main(graph, 0, 0, len(graph))

for answer in answerArr:
    print(answer)