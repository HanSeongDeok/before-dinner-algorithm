def solution(s):
    answer, temp = [], [] 
    number, cnt = 0, 1
    flag = False
    for c in s[1:-1]:
        if c == '{':
            flag = True
            continue
        if c == ',':
            if flag:
                temp.append(number)
            number, cnt = 0, 1
            continue
        if c == '}':
            flag = False
            temp.append(number)
            answer.append(temp[:])
            temp.clear()
            continue
        number *= cnt
        number += int(c) 
        cnt = 10
    answer = sorted(answer, key=lambda k: len(k))
    tuple_list = []
    for i in answer:
        value = [v for v in i if v not in tuple_list]
        tuple_list.append(value.pop())
    return tuple_list

print(solution("{{20,111},{111}}"))