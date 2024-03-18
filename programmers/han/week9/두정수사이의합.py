def solution(a: int, b: int) -> int:
    a_to_b_list = [i for i in range(a, b+1)]\
        if b > a\
        else [i for i in range(b, a+1)]
    return sum(a_to_b_list)

print(solution(5, 3))