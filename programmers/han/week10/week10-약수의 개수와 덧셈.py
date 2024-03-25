
def solution(left: int, right: int) -> int:
    answer = 0
    for i in range(left, right+1):
        answer = answer + i\
            if(divmod(divisor_count(i, 0, 0), 2)[1] == 0)\
            else answer - i
    return answer

def divisor_count(target: int, val: int, count: int):
    val += 1
    if(pow(val, 2) > target):
        return count
    if(pow(val, 2) == target):
        count += 1
    elif(divmod(target, val)[1] == 0):
        count += 2
    return divisor_count(target, val, count)

print(solution(13, 17))