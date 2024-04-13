#감소하는 수
import sys
from itertools import combinations
input = sys.stdin.readline

N = int(input())
de_num = []
#조합 문제
#조합으로 0~9 숫자들로 나올 수 있는 수를 구하고
#해당 경우를 감소하는 수로 만들어서 저장한다.
for i in range(1, 11): #1자리 ~ 10자리 수 까지만 생성 가능
    #감소하는 수의 최댓값은 9876543210이 될 것임
    for n in combinations(range(0,10), i): #0~9
        n = list(n)
        n.sort(reverse=True) #감소하는 수로 만들어서
        de_num.append(int("".join(map(str, n)))) #정수로 만들어서 넣기

de_num.sort() #오름차순으로 만들기
#감소하는 수는 총 1023개이므로 그 1022 이상은 -1 출력
if N < len(de_num):
    print(de_num[N])
else:
    print(-1)