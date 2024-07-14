import re 
def solution(new_id):
    # 1
    answer = new_id.lower()
    # 2
    ignore_special_key = "[\~!@#$%^&*()=+\\[{\\]}:?,<>/]"
    answer = re.sub(ignore_special_key,"",answer)
    # 3
    cnt = 0
    while '..' in answer:
        while ('..' + (cnt + 1) * '.' in answer):
            cnt += 1
        answer = answer.replace('..' + cnt * '.', '.')
        cnt = 0
    # 4
    answer = first_end_dot_remove(answer)
    # 5
    if len(answer) == 0:
        answer = "a"
    # 6
    if len(answer) > 15:
        answer = answer[:15]
        answer = first_end_dot_remove(answer)  
    # 7
    if len(answer) < 3:
        while(len(answer) < 3):
           answer += answer[-1:] 
    return answer

def first_end_dot_remove(answer):
    if answer[:1] == '.':
        answer = answer[1:]
    if answer[-1:] == '.':
        answer = answer[:-1]
    return answer

print(solution("...!@BaT#*..y.abcdefghijklm"))
print(solution(".BBB._AAVCD!@#BDEFEF@..#$!#4234@#...."))