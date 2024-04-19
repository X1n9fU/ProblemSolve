#DFS 와 BFS

import sys
input = sys.stdin.readline
from collections import deque

N,M,V = map(int, input().split())

graph = {}
visited = [0 for _ in range(N)]
route = []

for i in range(N):
    graph[i+1] = []

for _ in range(M):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

for i in graph.values():
    i.sort()

def dfs(edge):
    route.append(edge)
    visited[edge-1] = 1
    for i in graph[edge]:
        if visited[i-1] == 0:
            dfs(i)
                
def bfs(edge):
    q = deque()
    q.appendleft(edge)
    while q:
        e = q.popleft()
        route.append(e)
        visited[e-1] = 1
        for i in graph[e]:
            if visited[i-1] == 0:
                visited[i-1] = 1
                q.append(i) 
                
dfs(V)

print(" ".join(map(str, route)))
route.clear()
visited = [0 for _ in range(N)]

bfs(V)

print(" ".join(map(str, route)))
