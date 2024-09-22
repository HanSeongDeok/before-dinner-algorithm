# 이 친구도 다음날 같이 풀어보기!
def solution(people, limit):
    # KEY POINT 이런 탐욕 문제는 정렬을 최우선으로 한다.
    people.sort()
    left_point, right_point = 0, len(people)-1
    boats = 0
    
    while left_point <= right_point:
        if people[right_point] + people[left_point] <= limit:
            left_point += 1
        right_point -= 1
        boats += 1
    return boats
    

print(solution([70, 50, 80, 50], 100))