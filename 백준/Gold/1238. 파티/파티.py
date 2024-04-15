#파티

#"오고 간다"에 초점을 맞추자

import sys
import heapq
from collections import deque

input = sys.stdin.readline

N,M,X = map(int, input().split())
INF = int(1e9)
graph = [[] for _ in range(N+1)]

for _ in range(M):
    s,e,t = map(int, input().split())
    graph[s].append((e,t))

hometoX = [INF for _ in range(N+1)]
XtoHome = [INF for _ in range(N+1)]

def go():
    for i in range(1,N+1):
        tmp = [INF for _ in range(N+1)]
        if i==X:
            hometoX[i] = 0
            continue
        tmp[i] = 0
        q= []
        heapq.heappush(q, (0,i))
        while q:
            dist, now = heapq.heappop(q)
            
            if tmp[now] < dist:
                continue
            
            for node, cost in graph[now]:
                if tmp[node] > cost+dist:
                    tmp[node] = cost+dist
                    heapq.heappush(q, (cost+dist, node))
        hometoX[i] = tmp[X]
        

def come(s):
    XtoHome[s] = 0
    q= []
    heapq.heappush(q, (0,s))
    while q:
        dist, now = heapq.heappop(q)
        
        if XtoHome[now] < dist:
            continue
        
        for node, cost in graph[now]:
            if XtoHome[node] > cost+dist:
                XtoHome[node] = cost+dist
                heapq.heappush(q, (cost+dist, node))

go()
come(X)

tmp = []
for i in range(1,N+1):
    tmp.append(hometoX[i] + XtoHome[i])

print(max(tmp))
        
        