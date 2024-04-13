def solution(answers):
    give_up_patterns = [[1, 2, 3, 4, 5]*2000, [2, 1, 2, 3, 2, 4, 2, 5]*1900, [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]*1000]
    one, two, three = 0, 0, 0
    for i in range(len(answers)):
        one += 1 if answers[i] == give_up_patterns[0][i] else 0
        two += 1 if answers[i] == give_up_patterns[1][i] else 0
        three += 1 if answers[i] == give_up_patterns[2][i] else 0
    giver = {
        1: one,
        2: two,
        3: three 
    }
    max_value = max(one, two, three)
    result = [key for key in giver if giver[key] == max_value]
    return result

print(solution([1,2,3,4,5]))