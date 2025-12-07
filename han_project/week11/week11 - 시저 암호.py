def solution(s: str, n: int) -> str:
    answer = ''
    for i in s:
        change_chr = i
        for j in range(n):
            if change_chr == ' ':
                break
            if change_chr == "z" or change_chr == "Z":
                    change_chr = "a"\
                    if change_chr == "z"\
                    else "A"
            else:     
                change_chr = chr(ord(change_chr) + 1)
        answer += change_chr 
    return answer

print(solution("a B z", 4))