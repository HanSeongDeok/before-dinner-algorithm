def solution(answers):
    first = [1, 2, 3, 4, 5]
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    scores = [0, 0, 0]
    
    # 맞춘 문제 수 구하기
    for i, answer in enumerate(answers):
        if first[i % len(first)] == answer:
            scores[0] += 1
        if second[i % len(second)] == answer:
            scores[1] += 1
        if third[i % len(third)] == answer:
            scores[2] += 1
    
    # 최고 점수 구하기
    max_score = max(scores)
    
    # 최고 점수와 같은 점수를 가진 사람 찾기
    result = []
    for i in range(len(scores)):
        if scores[i] == max_score:
            result.append(i + 1)
    
    return result
