board = input().split('.')

answer = []
for i in board:
    length = len(i)
    if length%2==0:
        two = 0
        four = 0
        while(length%4!=0):
            length -=2
            two += 1
        four = int(length/4)
        answer.append('AAAA'*four + 'BB'*two)
    else:
        answer.clear()
        print(-1)
        exit()
print('.'.join(answer))