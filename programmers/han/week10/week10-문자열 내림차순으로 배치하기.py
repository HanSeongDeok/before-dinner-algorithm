def solution(s: str):
    return "".join(sorted(s, reverse=True))

print(solution("Zbcdefg"))