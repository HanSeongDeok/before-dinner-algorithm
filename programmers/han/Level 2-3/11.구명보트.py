from collections import deque
# 탐욕적 기법
# @ Day 1
def solution(people, limit):
    people = sorted(people, reverse=True)
    base = deque(sorted(people))
    cnt = 0
    for p in people:
        if base:
            base.pop()
        if base and p + base[0] <= limit:
            base.popleft()
            continue
        cnt += 1
    return cnt
            
# def solution(people, limit):
#     people = sorted(people, reverse=True)
#     s_point, e_point = 0, len(people)-1
#     answer = 0
#     while(s_point <= e_point):
#         if people[s_point] + people[e_point] <= limit:
#             s_point += 1
#             e_point -= 1
#         else:
#             s_point += 1
#         answer += 1
#     return answer 

# @ Day 2
def solution(people, limit):
    sort_people = sorted(people, reverse=True)
    people_dq = deque(sorted(people))
    count = 0
    for p in sort_people:
        if  people_dq: 
            people_dq.pop()
        if people_dq and p + people_dq[0] <= limit:
            people_dq.popleft()
            continue
        count += 1
    return count



def solution(p, limit):
    small_p, big_p  = deque(sorted(p)), sorted(p, reverse=True) 
    result = 0
    for b in big_p: 
        if small_p:
            small_p.pop()
        if small_p and small_p[0] + b <= limit:
            small_p.popleft()
            continue
        result += 1
    return result





print(solution([70, 50, 80, 50], 100))
print(solution([70, 80, 50], 100))