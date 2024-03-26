def count_divisors(n):
    if n == 1:
        return 1
    count = 2
    for i in range(2, int(n**0.5 + 1)):
        if n % i == 0:
            if i * i == n:
                count += 1
            else: 
                count += 2
    return count
def solution(left, right):
    answer = 0
    for i in range(left, right + 1):
        if count_divisors(i) % 2 == 0:
            answer += i
        else:
            answer -= i
    return answer
