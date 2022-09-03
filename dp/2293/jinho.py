import collections
from collections import deque

n, k = map(int, input().split())

# sorting input in ascending order & less than k
lst = []
for _ in range(n):
    lst.append(int(input()))
lst.sort()
lst = list(filter(lambda x : x<=k, lst))
# print(lst)
# dynamic programming result
result = [0 for i in range(k+1)]
result[0] = 1;   

for i in lst:
    for j in range(i, k+1):
        if j-i >= 0:
            result[j] += result[j-i]
# for i in range(n):
#     for j in range(lst[i], k+1):
#         if j-lst[i] >= 0:
#             result[j] += result[j-lst[i]]

print(result[k])
# for i in range(len(lst)):
#     for j in range(lst[i], k+1):
#         idx = 0
#         tmp = 0
#         while idx <= i:
#             tmp += result[idx][j-lst[i]]
#             idx += 1
#         result[i].append(tmp)
#         # print(result)

# answer = 0
# for _ in range(len(result)):
#     answer += result[_][k]

# print(answer)
# # for i in range(lst[0], k+1):
# #     new_lst = []
# #     for j in range(len(lst)):
# #         if i < lst[j]:
# #             break
# #         else:
# #             for _ in range(result[i-lst[j]]):
# #                 new_lst.append(result[i-lst[j]][_])
# #                 new_lst[i-lst[j]][_][j] += 1

# #     for a in range(len(new_lst)-1, -1, -1):
# #         for b in range(len(new_lst)-2, -1, -1):
#             # if collections.Counter(new_lst[a]) == collections.Counter(new_lst[b]):
