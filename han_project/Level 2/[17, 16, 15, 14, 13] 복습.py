# 17. 예상 대진표
def solution(n,a,b):
    answer = 0
    for i in range(1, int(n / 2)+1):
        a = divmod(a, 2)[0] + divmod(a, 2)[1]
        b = divmod(b, 2)[0] + divmod(b, 2)[1]
        answer = i
        if a == b:
            break
    return answer
print(solution(8, 4, 7))

# 16. 멀리 뛰기 
def solution(n):    
    # n이 1일 경우 필히 한가지의 경우의 수가 나오며 n이 2일 때는 필히 2가지의 경우의 수가 나온다
    # 즉 n이 3일 경우 n이 1일 경우와 2일 경우의 합의 경우의 수와 같은 걸 알 수 있다
    n_1, n_2  = 1, 2
    result = 0
    if n == n_1:
        return n_1
    elif n == n_2:
        return n_2
    for _ in range(3, n + 1):
        result = n_1 + n_2
        n_1, n_2 = n_2, result
    return result % 1234567
print(solution(4)) 

# 15. 귤 고르기
def solution(k, tangerine):
    answer = 0
    dupl_map = {}
    for i in tangerine:
        if i in dupl_map:
            dupl_map[i] += 1
        else:
            dupl_map[i] = 1
    
    dupl_list = sorted(dupl_map.values(), reverse=True)
    
    cnt = 0
    for i in dupl_list:
        if cnt >= k:
            break
        cnt += i
        answer += 1
    return answer

print(solution(6, [1,3,2,5,4,5,2,3]))

# 14. 구명보트
def solution(people, limit):
    people = sorted(people, reverse=True)
    s_point, e_point = 0, len(people)-1
    answer = 0
    while(s_point <= e_point):
        if people[s_point] + people[e_point] <= limit:
            s_point += 1
            e_point -= 1
        else:
            s_point += 1
        answer += 1
    return answer 

# 13. 영어 끝말잇기
# 12. 점프와 순간 이동
 