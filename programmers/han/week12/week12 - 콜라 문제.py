result = {
    'return': 0,
    'remainer': 0
}
sum_cola = 0

def solution(a, b, n):
    global sum_cola
    sum_cola = 0
    result['remainer'] = 0
    
    while n >= a:
        return_colas, remainder = divmod(n, a)
        return_colas *= b
        sum_cola += return_colas
        n = return_colas + remainder
    
    return sum_cola
    
print(solution(3, 1, 20))