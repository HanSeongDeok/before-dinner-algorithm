def solution(s):
    answer = [] 
    i = 0 

    for char in s:
        if char == " ":
            i = 0
        else:
            if i % 2 == 0:
                char = char.upper()
            else: 
                char = char.lower()
            i += 1  
        answer.append(char)

    return ''.join(answer)
