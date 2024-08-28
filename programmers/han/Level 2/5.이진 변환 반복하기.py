def solution(s):
    seq, cnt, len = 0, 0, 0
    while (len != 1):
        len= 0
        for i in s:
            if i == '0':
                cnt += 1
            else:
                len += 1
        seq += 1
        s = custom_bin(int(len))
    return [seq, cnt]

def custom_bin(n):
    bin_number = 0
    cnt = 1
    while(n > 0):
        bin_number += int(n % 2) * cnt
        cnt *= 10
        n //= 2 
    return str(bin_number)   

print(solution("1111111"))