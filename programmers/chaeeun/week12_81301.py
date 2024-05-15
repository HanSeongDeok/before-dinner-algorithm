def solution(s):
    str_answer = ""
    str_temp = ""
    
    for ch in s:
        if '0' <= ch <= '9':
            str_answer += ch
        else:
            str_temp += ch
            if change(str_temp) == '':
                continue
            else:
                str_answer += change(str_temp)
                str_temp = ""
    
    answer = int(str_answer)
    return answer

def change(s):
    words = {
        "zero": '0',
        "one": '1',
        "two": '2',
        "three": '3',
        "four": '4',
        "five": '5',
        "six": '6',
        "seven": '7',
        "eight": '8',
        "nine": '9'
    }
    return words.get(s, '')
