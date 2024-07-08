def solution(keymap, targets):
    answer = []
    count = {}
    for i, keys in enumerate(keymap):
        for j, char in enumerate(keys):
            if char in count:
                count[char] = min(count[char], j + 1)
            else:
                count[char] = j + 1

    
    for target in targets:
        press = 0
        for char in target:
            if char in count:
                press += count[char]
            else:
                press = -1
                break
        answer.append(press)
            
    return answer
