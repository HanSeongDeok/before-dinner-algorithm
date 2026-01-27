def solution(x: int) -> bool:
    x_list = [int(i) for i in str(x)]  
    return divmod(x, sum(x_list))[1] == 0

print(solution(12))