def solution(numbers, hand):
    numbers_dict = {1: "L", 4: "L", 7: "L",
                    3: "R", 6: "R", 9: "R"}
    mids_dict ={2: 2, 5: 5, 8: 8, 0: 10}
    memo_R, memo_L = 10, 12
    answer = ''
    for n in numbers:
        if n in numbers_dict:
            h = numbers_dict[n]
            answer += h
            if h == "L":
                memo_L = n
            else:
                memo_R = n
        else :
            answer += mid_check(n, memo_R, memo_L, hand, mids_dict)
    return answer

def mid_check(n, memo_R, memo_L, hand, mids_dict):
    if memo_R in mids_dict and memo_L in mids_dict:
        if abs(memo_R - n) < abs(memo_L - n):
            memo_R = mids_dict[n]
            return "R"
        elif abs(memo_L - n) < abs(memo_R - n):
            memo_L = mids_dict[n]
            return "L"
        else: 
            return hand
    elif memo_R in mids_dict:
        if abs(mids_dict[memo_R] - mids_dict[n]) - 2 < abs(memo_L - mids_dict[n]):
            memo_R = mids_dict[n]
            return "R"
        elif abs(mids_dict[memo_R] - mids_dict[n]) - 2 > abs(memo_L - mids_dict[n]):
            memo_L = mids_dict[n]
            return "L"
        else:
            return hand
    elif memo_L in mids_dict:
        if abs(mids_dict[memo_L] - mids_dict[n]) - 2 < abs(memo_R - mids_dict[n]):
            memo_L = mids_dict[n]
            return "L"
        elif abs(mids_dict[memo_L] - mids_dict[n]) - 2 > abs(memo_R - mids_dict[n]):
            memo_R = mids_dict[n]
            return "R"
        else:
            return hand    
    if memo_R == 10 and memo_L == 12:
        return hand
    elif abs(memo_R - n) == abs(memo_L - n):
        return hand
    if abs(memo_R - n) < abs(memo_L - n):
        memo_R = n
        return "R"
    elif abs(memo_R - n) > abs(memo_L - n):
        memo_L = n
        return "L"
    
print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))

def solution2(numbers, hand):
    answer = ''
    # 키패드 위치를 좌표로 표현
    key_positions = {1: (0, 0), 2: (0, 1), 3: (0, 2),
                     4: (1, 0), 5: (1, 1), 6: (1, 2),
                     7: (2, 0), 8: (2, 1), 9: (2, 2),
                     '*': (3, 0), 0: (3, 1), '#': (3, 2)}
    
    # 초기 위치 설정
    left_thumb = key_positions['*']
    right_thumb = key_positions['#']
    
    def get_distance(pos1, pos2):
        return abs(pos1[0] - pos2[0]) + abs(pos1[1] - pos2[1])
    
    for number in numbers:
        if number in [1, 4, 7]:
            answer += 'L'
            left_thumb = key_positions[number]
        elif number in [3, 6, 9]:
            answer += 'R'
            right_thumb = key_positions[number]
        else:
            left_distance = get_distance(left_thumb, key_positions[number])
            right_distance = get_distance(right_thumb, key_positions[number])
            
            if left_distance < right_distance:
                answer += 'L'
                left_thumb = key_positions[number]
            elif right_distance < left_distance:
                answer += 'R'
                right_thumb = key_positions[number]
            else:  # 거리가 같은 경우
                if hand == 'left':
                    answer += 'L'
                    left_thumb = key_positions[number]
                else:
                    answer += 'R'
                    right_thumb = key_positions[number]
    
    return answer

# 예제 입력
numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = "right"
print(solution(numbers, hand))  # "LRLLLRLLRRL"