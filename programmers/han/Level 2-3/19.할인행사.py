from collections import Counter

# @ Day 1
# 슬라이딩 윈도우(Sliding Window)와 해시맵(딕셔너리, Counter)을 활용한 구현 문제
def solution(want, number, discount):
    want_dict = dict(zip(want, number))
    result = 0
    for i in range(len(discount) - sum(number) + 1):
        window = discount[i:i+sum(number)]
        window_counter = Counter(window)
        if window_counter == want_dict:
            result += 1
    return result

print(solution(["banana", "apple", "rice", "pork", "pot"],[3, 2, 2, 2, 1],["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]))
# print(solution(	["apple"], [10], ["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"]))