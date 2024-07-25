def solution(new_id):
    answer = new_id.lower()
    
    answer = ''.join(char for char in answer if char.isalnum() or char in '-_.')
    
    while '..' in answer:
        answer = answer.replace('..', '.')
    
    answer = answer.strip('.')
    
    if len(answer) == 0:
        answer = 'a'

    if len(answer) >= 16:
        answer = answer[:15]
        answer = answer.rstrip('.')
    
    while len(answer) <= 2:
        answer += answer[-1]
    
    return answer
