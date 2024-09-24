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
    
    
    
 
def solution2(people, limit):
    people = sorted(people, reverse= True)
    l_p, r_p, result = 0, len(people)-1, 0
    while(r_p >= l_p):
        if(people[l_p] + people[r_p] <= limit):
            r_p -= 1
        l_p += 1
        result += 1
    return result
 
 
 
    

print(solution2([70, 50, 80, 50], 100))