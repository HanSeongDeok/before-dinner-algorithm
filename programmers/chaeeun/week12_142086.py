def solution(s):
    answer = []
    last = {}
    
    for i, char in enumerate(s):
        if char in last:
            answer.append(i - last[char])
        else:
            answer.append(-1)
        
        last[char] = i
    
    return answer
