def solution(s, skip, index):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    skip_set = set(skip)
    
    answer = ''
    
    for char in s:
        cur_index = alphabet.index(char)
        steps = 0
        
        while steps < index:
            cur_index = (cur_index + 1) % 26
            if alphabet[cur_index] not in skip_set:
                steps += 1
        
        answer += alphabet[cur_index]
    return answer
