def solution(s):
    max_number = max(int(i) for i in s.split(' '))
    min_number = min(int(i) for i in s.split(' '))
    return f"{min_number} {max_number}"

print(solution("1 2 3 4"))