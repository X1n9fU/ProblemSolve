#구간 합 구하기 4

import sys
input = sys.stdin.readline

N,M = map(int, input().split())

num = [0]
numbers = input().split()
tmp = 0
for i in range(N):
    tmp += int(numbers[i])
    num.append(tmp)


for _ in range(M):
    start, end = map(int, input().split())
    result = num[end] - num[start-1]
    print(result)