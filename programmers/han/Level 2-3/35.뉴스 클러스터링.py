from collections import Counter
from itertools import count
def solution(str1, str2):
    def make_bigrams(s):
        s = s.lower()
        bigrams = []
        for i in range(len(s) - 1):
            a, b = s[i], s[i + 1]
            if a.isalpha() and b.isalpha():
                bigrams.append(a + b)
        return bigrams

    str1_bigrams = make_bigrams(str1)
    str2_bigrams = make_bigrams(str2)

    c1 = Counter(str1_bigrams)
    c2 = Counter(str2_bigrams)

    intersection = c1 & c2
    union = c1 | c2

    inter_cnt = sum(intersection.values())
    union_cnt = sum(union.values())

    if union_cnt == 0:
        return 65536
    answer = int(inter_cnt / union_cnt * 65536)
    return answer


# @Day 1
from collections import Counter
def solution(str1, str2):
    str1_arr = create_str_arr(str1)
    str2_arr = create_str_arr(str2)
    
    str1_arr_cntr = Counter(str1_arr)
    str2_arr_cntr = Counter(str2_arr)

    union = sum((str1_arr_cntr | str2_arr_cntr).values())
    intersection = sum((str1_arr_cntr & str2_arr_cntr).values())

    if not union:
        return 65536

    return int(intersection / union * 65536)


def create_str_arr(s):
    str_arr = []
    s = s.upper() 
    for i in range(len(s)-1):
        if s[i].isalpha() and s[i+1].isalpha():
            str_arr.append(s[i] + s[i+1])
    return str_arr



def solution(str1, str2):
    def create_str_arr(s):
        temp = []
        for i in range(len(s)-1):
            if s[i:i+2].isalpha():
                temp.append(s[i:i+2].upper())
        return temp 
    
    str1_arr = create_str_arr(str1)
    str2_arr = create_str_arr(str2)
    
    def create_intersection_value(arr1, arr2):
        arr2_copy = arr2[:]
        cnt = 0
        for a1 in arr1:
            if a1 in arr2_copy:
                cnt += 1
                arr2_copy.remove(a1)
        return cnt
 
    intersection = create_intersection_value(str1_arr, str2_arr)
    union = len(str1_arr) + len(str2_arr) - intersection

    ## arr의 Counter로 &는 교집합 |는 합집합을 구할 수 있다.  
    a = Counter(str1_arr) & Counter(str2_arr)
    b = Counter(str1_arr) | Counter(str2_arr)

    if not union:
        return 65536
    return int((intersection / union) * 65536)




    
print(solution("FRANCE", "french"))       # 16384
print(solution("handshake", "shake hands"))   # 65536
print(solution("aa1+aa2", "AAAA12"))      # 43690
print(solution("E=M*C^2", "e=m*c^2"))    # 65536
print(solution("ABCD", "EFGH"))    # 65536
