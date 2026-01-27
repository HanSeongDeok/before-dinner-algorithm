from collections import Counter
from itertools import count
from pydoc import resolve
from unittest import result

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

from collections import Counter
def solution(want, number, discount):
    want_number_dict = dict(zip(want, number))
    # want_number_dict = dict(sorted(want_number_dict.items(), key=lambda x: x[1]))
    total_sum = sum(number)
    result = 0
    for i in range(len(discount)-total_sum+1):
        # discount_dict = dict(sorted(Counter(discount[i:total_sum+i]).items(), key=lambda x: x[1]))
        if want_number_dict == Counter(discount[i:total_sum+i]):
            result += 1
    return result

print(solution(["banana", "apple", "rice", "pork", "pot"],[3, 2, 2, 2, 1],["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]))
# print(solution(	["apple"], [10], ["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"]))