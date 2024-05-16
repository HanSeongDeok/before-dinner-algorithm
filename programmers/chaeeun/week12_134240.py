def solution(food):
    front = ""
    
    for i in range(1, len(food)):
        for j in range(food[i] // 2):
            front += str(i)
    
    end = front[::-1]  # 문자열을 역순으로 뒤집음
    return front + "0" + end
