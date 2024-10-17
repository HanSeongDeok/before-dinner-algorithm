## 내일 다시 풀어보기!!
def solution(s):
    answer = 0
    open_number_map = {
        "(" : 1,
        "[" : 2,
        "{" : 3,
        ")" : -1,
        "]" : -2,
        "}" : -3,
    }
    
    open_close_map = {
        "(" : ")",
        "[" : "]",
        "{" : "}",
    }
    
    size = len(s)
    s *= 2
    for index in range(size):
        cnt = 0
        for v in s[index : index + size]:
            
            cnt += open_close_map[v]
            if cnt < 0:
                break
            
        answer = answer + 1 if cnt == 0 else answer 
    return answer

print(solution("[)(]"))