#구간 합 구하기 5

import sys
input = sys.stdin.readline

N,M = map(int, input().split())

matrix = [[(0,0) for _ in range(N+1)]]
for i in range(N):
    fromleft = 0
    fromabove = 0
    num = []
    numbers = ['0']
    numbers.extend(input().split())
    for j in range(N+1):
        fromleft += int(numbers[j])
        fromabove = int(matrix[i][j][1]) + fromleft
        num.append((fromleft, fromabove))
    matrix.append(num)


for _ in range(M):
    x1,y1,x2,y2 = map(int, input().split())
    result = matrix[x2][y2][1] - matrix[x1-1][y2][1] - matrix[x2][y1-1][1] + matrix[x1-1][y1-1][1]
    print(result)
    
    
