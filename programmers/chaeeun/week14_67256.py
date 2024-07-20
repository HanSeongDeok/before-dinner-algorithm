def solution(numbers, hand):
    answer = ""
    left = 10
    right = 12
        
    for num in numbers:
        if num == 1 or num == 4 or num == 7:
            answer += "L"
            left = num
        elif num == 3 or num == 6 or num == 9:
            answer += "R"
            right = num
        else:
            leftF = cal(left, num)
            rightF = cal(right, num)
                
            if leftF > rightF:
                answer += "R"
                right = num
            elif leftF < rightF:
                answer += "L"
                left = num
            else:
                if hand == "right":
                    answer += "R"
                    right = num
                else:
                    answer += "L"
                    left = num
        
    return answer

def cal(hand_location, num):
    if hand_location == 0:
        hand_location = 11
        
    if num == 0:
        num = 11
        
    locationX = (hand_location - 1) // 3
    locationY = (hand_location - 1) % 3
        
    numX = (num - 1) // 3
    numY = (num - 1) % 3
        
    result = abs(locationX - numX) + abs(locationY - numY)
        
    return result
