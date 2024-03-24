def solution(numbers):
    check = [False for i in range(10)]
    for i in numbers:
        check[i] = True
    answer = 0
    for i in range(10):
        if check[i] == False:
            answer += i
    return answer
