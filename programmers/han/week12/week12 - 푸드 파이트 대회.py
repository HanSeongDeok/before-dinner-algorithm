def solution(food):
    answer = []
    for i in range(1, len(food)):
        cnt = 0
        while(cnt < int(food[i]/2)):
            answer.append(i)
            cnt += 1    
    return ''.join(map(str, answer)) + '0' + ''.join(map(str, sorted(answer, reverse=True)))

print(solution([1, 3, 4, 6]))