def solution(n: int) -> int:
    return three_to_ten_numeral(
        str(ten_to_three_numeral(n, 0))[::-1])

def three_to_ten_numeral(n: str) -> int:
    size = len(n)
    value = 0
    for i in range(size):
        value += int(n[i]) * pow(3, size - i -1)
    return value

def ten_to_three_numeral(n: int, v: int) -> int:
    if n == 0:
        return v
    
    cnt, i = 1, 1
    while(n >= pow(3, cnt)): 
        cnt += 1
    
    target = pow(3, cnt-1)  
    while(3 > i and n >= target * i):
        i += 1
    
    n -= target * (i - 1)  
    v += pow(10, cnt - 1) * (i - 1)
    return ten_to_three_numeral(n, v)

print(solution(125))