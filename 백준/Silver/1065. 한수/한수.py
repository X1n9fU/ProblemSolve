#한수
import sys
input = sys.stdin.readline

N = int(input())
numbers = list(_ for _ in range(1,N+1))
cnt = 0

for num in numbers:
    isSame = True
    num = list(map(int, str(num)))  #정수를 배열로 만들기 위해서는
    if len(num) < 3:
       cnt += 1
    else:
        diff = num[1] - num[0]
        for i in range(1, len(num)-1):
            if num[i+1] - num[i] != diff:
                isSame = False
                break
        if isSame:
            cnt += 1 

print(cnt)