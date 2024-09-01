import math
## wow ㅋㅋㅋ 다음 자연수인데 소수까지 판별해버렸네
def solution(n):
    cnt = convert_func(n, lambda n: custom_bin_1_cnt(n))
    for i in range(n+1, 1000000):
        if (cnt == convert_func(i, lambda n: custom_bin_1_cnt(n))):
            return i
    return 10000000

# convert_func(i, lambda n: check_natural_number(n))
# def check_natural_number(n):
#     check = True
#     for i in range(2, int(math.sqrt(n))+1):
#         if(n % i == 0):
#             check = False
#             break
#     return check

def custom_bin_1_cnt(n):
    bin_number, digit = 0, 1
    while(n > 0):
       bin_number += n % 2 * digit
       digit *= 10
       n //= 2
    return sum(1 for i in str(bin_number) if i == '1')

def convert_func(n, convert):
    return convert(n)

# python에서 제공해주는 bin 함수를 이용하면 편하긴 하나
# 연습중에는 custom으로 만들어 보자
def solution2(n):
    cnt = sum(1 for i in bin(n).replace('0b','') if i == '1')
    for i in range(n+1, 1000000):
        if(cnt == sum(1 for j in bin(i).replace('0b','') if j == '1')):
            return i
    return 1000000

print(solution2(78))
print(solution(15))



