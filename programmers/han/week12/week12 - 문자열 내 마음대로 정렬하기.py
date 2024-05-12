def solution(strings, n):
    dict = {i: i[n] for i in strings}    
    answer = sorted(dict.items(), key=lambda item: (item[1], item[0]))
    return [i[0] for i in answer]

print(solution(["abce", "abcd", "cdx"], 1))