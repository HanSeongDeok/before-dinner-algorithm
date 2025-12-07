import math
def solution(number, limit, power):
    divison_count_arr = [1]
    for i in range(2, number+1):
        cnt = divison_count(i)
        divison_count_arr.append(power)\
            if cnt > limit\
            else divison_count_arr.append(cnt)
    return sum(divison_count_arr)

def divison_count(number):
    return sum(1 if i**2 == number else 2 
            for i in range(1, int(math.sqrt(number))+1)
            if divmod(number,i)[1] == 0)

print(solution(10, 3, 2))
