def solution(num: int) -> int:
    return pipeline_counter(num, 0)

def pipeline_counter(num: int, count: int) -> int:
    if num == 1: return count
    if count == 500: return -1
    return pipeline_counter(odd_even_operation(num), 
                            count + 1)

def odd_even_operation(num: int) -> int:
    return num / 2\
        if(divmod(num, 2)[1] == 0)\
        else num * 3 + 1

print(solution(16))