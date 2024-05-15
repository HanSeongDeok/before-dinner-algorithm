import itertools
def solution(number):
    answer = 0
    for i in itertools.combinations(number, 3):
        if sum(i) == 0:
            answer += 1
    return answer
