def solution(n):
    answer = 0
    prime = [True] * (n + 1)
    for i in range(2, int(n**0.5) + 1):
        if prime[i]:
            for j in range(i * i, n + 1, i):
                prime[j] = False
    
    for i in range(2, n + 1):
        if prime[i]:
            answer += 1
    return answer
