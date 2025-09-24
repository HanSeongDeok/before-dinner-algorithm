# 완전 탐색(브루트포스)
# @ Day 1
def solution(n):
    cnt = custom_bin(n).count('1')
    up_number = n + 1
    while up_number <= 1000000:
        if cnt == custom_bin(up_number).count('1'):
            break
        up_number += 1
    return up_number

def custom_bin(n):
    number_bin = 0
    cnt = 1
    while n > 0:
        number_bin += n % 2 * cnt
        cnt *= 10
        n //= 2
    return str(number_bin) 

print(solution(78))
print(solution(15))