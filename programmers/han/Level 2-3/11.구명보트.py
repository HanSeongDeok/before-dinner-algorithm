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

print(solution([70, 50, 80, 50], 100))
print(solution([70, 80, 50], 100))