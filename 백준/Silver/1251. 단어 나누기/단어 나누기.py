w = input()

words=[]
# 반복문에서 범위를 조절하여 나올 수 있는 두 부분을 모두 구현한다.
for i in range(1, len(w)-2):
    #마지막 범위를 -2하는 이유는 나누는 처음 부분이 갈 수 있는 최대의 위치는 길이-2이기 때문
    #mobitel 를 두 부분을 골라 나눴을 때 첫 부분의 최대 위치는 moboit/e/l로 t와e 사이, 즉 길이 -2까지이다.
    #뒤에 두번째 부분도 존재해야 하기 때문!
    for j in range(i+1, len(w)):
        #윗 부분과 같은 이유로 두번째 부분의 최소 위치는 m/o/boitel로 시작하는 위치를 첫 부분의 위치인 i +1로 놓는다.
        first = w[:i][::-1]
        second = w[i:j][::-1]
        third = w[j:][::-1]
        #인덱싱을 통해서 부분적으로 가져오고 [::-1]를 통해 뒤집어서 대입한다.
        new = first+second+third #새로운 단어는 인덱싱하고 뒤집어진 세 단어들을 연결한 단어
        words.append(new) #words 배열에 넣는다.

words.sort() #words 배열을 정렬한다.
print(words[0]) #가장 처음에 위치한 단어가 사전순으로 가장 앞서는 단어이다.
        
        