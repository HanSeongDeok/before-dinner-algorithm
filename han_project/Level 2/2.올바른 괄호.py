def solution(s):
    signal_dict = {"(" : 1, ")" : -1}
    cnt = 0
    for i in s:
        if cnt == 0 and i == ")":
            return False
        cnt += signal_dict[i]
    return True if cnt == 0 else False

print(solution("(())()"))