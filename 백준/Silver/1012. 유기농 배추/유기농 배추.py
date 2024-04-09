#유기농 배추
#BFS

import sys
from collections import deque

input = sys.stdin.readline

q = deque()
T = int(input())

def bfs(Cabbage):
    while len(q) > 0:
        i, j = q.popleft()
        Cabbage[i][j] = 0
        if i - 1 >= 0 and Cabbage[i - 1][j] == 1:
            q.appendleft((i - 1, j))
        if i + 1 < N and Cabbage[i + 1][j] == 1:
            q.appendleft((i + 1, j))
        if j - 1 >= 0 and Cabbage[i][j - 1] == 1:
            q.appendleft((i, j - 1))
        if j + 1 < M and Cabbage[i][j + 1] == 1:
            q.appendleft((i, j + 1))
    
for _ in range(T):
    M,N,K = map(int, input().split())
    cnt = 0

    Cabbage = []
    for _ in range(N):
        Cabbage.append(list(0 for _ in range(M)))
        
    for _ in range(K):
        X,Y = map(int, input().split())
        Cabbage[Y][X] = 1

    for i in range(N):
        for j in range(M):
            if Cabbage[i][j] == 1:
                cnt += 1
                q.appendleft((i,j))
                bfs(Cabbage)

    print(cnt)