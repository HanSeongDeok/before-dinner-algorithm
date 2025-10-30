def solution(skill, skill_trees):
    answer = 0
    skill_list = list(skill)
    for st in skill_trees:
        valid = ""
        for s in st:
            if s in skill_list:
                valid += s
        if not valid or (valid in skill and valid[0] == skill[0]):
            answer += 1
    return answer

print(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))