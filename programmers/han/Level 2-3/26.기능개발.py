
# 프로그래머스 Level 2 - 기능개발
# 각 기능의 남은 작업 일수를 계산한 뒤, 앞에서부터 배포 가능한 기능을 묶어서 배포 횟수를 센다.
# 이 문제는 "큐(Queue) 시뮬레이션" 또는 "그리디(Greedy)" 유형의 알고리즘 문제입니다.
# 각 기능의 완료 일자를 계산한 뒤, 앞에서부터 순서대로 배포 가능한 기능을 묶어 배포 횟수를 세는 방식입니다.
def solution(progresses, speeds):
    answer = []
    days = []
    # 각 기능이 완료되기까지 걸리는 일수 계산
    for p, s in zip(progresses, speeds):
        remain = (100 - p)
        day = remain // s
        if remain % s != 0:
            day += 1
        days.append(day)
    
    # 배포 묶음 계산
    cnt = 1
    prev = days[0]
    for d in days[1:]:
        if d <= prev:
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
            prev = d
    answer.append(cnt)
    return answer

import math
def solution(progresses, speeds):
    answer = []
    date_list = []
    for p, s in zip(progresses, speeds):
        progress = 100 - p
        date = math.ceil(progress / s) 
        date_list.append(date)

    s_p, e_p = 0, 0
    cnt = 0
    while(e_p < len(date_list)):
        if date_list[s_p] >= date_list[e_p]:
           e_p += 1
           cnt += 1
           continue
        s_p = e_p
        answer.append(cnt)
        cnt = 0
    answer.append(cnt)
    return answer

# @ Day 1
def solution(progresses, speeds):
    result = []
    remainder_days = []
    for p, s in zip(progresses, speeds):
        v, remainder = divmod(100 - p, s)
        remainder_days.append(v+1 if remainder else v)

    prev = remainder_days[0]
    cnt = 1

    for d in remainder_days[1:]:
        if prev >= d:
            cnt += 1 
        else:
            result.append(cnt)
            cnt = 1
            prev = d
    result.append(cnt)
    return result
    



# 예시 테스트
print(solution([93, 30, 55], [1, 30, 5]))  # [2, 1]
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]))  # [1, 3, 2]











