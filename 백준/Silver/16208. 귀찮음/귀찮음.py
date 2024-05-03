'''
비용 : 자르는 막대기 길이 x 남은 막대기 
가 되는데 최소값을 출력하기 위해서는 
제일 긴 막대기는 그냥 남는 막대기가 되도록 해야함 

따라서 제일 작은 막대기부터 잘라내면 된다.
''' 

n = int(input())

stick = list(map(int, input().split()))


# stick.sort() #오름차순으로 정렬


'''cost = 0 #제일 작은 것을 뺀 비용 값으로 초기화
idx = 0

while len(stick) != 1:
    length_stick = sum(stick) #이어져있는 stick의 길이
    smallest = min(stick)
    cost += smallest * (length_stick-smallest) #작은 막대기부터 잘라내는 비용 더하기
    stick.remove(smallest)

print(cost)'''

stick.sort()
cost = 0

length = sum(stick)
for i in range(0,len(stick)-1):
    length -= stick[i]
    cost += stick[i] * length
print(cost)