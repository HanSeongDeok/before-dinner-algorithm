## 내일 다시 풀어보기!!
def solution(s):
    answer = 0
    open_close_map = {
        "(" : ")",
        "[" : "]",
        "{" : "}",
    }
    
    size = len(s)
    s *= 2
    for index in range(size):
        check = True
        close_list = []
        for v in s[index : index + size]:
            if not close_list and v not in open_close_map:
                check = False
                break
            if v in open_close_map:
                close_list.append(open_close_map[v])
            else:
                if not close_list or v != close_list.pop():
                    check = False
                    break
        if check and not close_list:
            answer += 1
    return answer

print(solution("[)(]"))