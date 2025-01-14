def solution(word):
    words = ['A', 'E', 'I', 'O', 'U']
    # 자리수가 증가 할 때 바로뒤의 자리수가 없는 것 까지 포함되어야 하기 때문에
    # 5가 아닌 6(1 * 5 + 1), 25가 아닌 31(6 * 5 + 1), 125가 아닌 156(31 * 5 + 1) ... 이다. 
    weights = sorted([1, 6, 31, 156, 781], reverse=True)  
    order = 0

    for i, char in enumerate(word):
        index = words.index(char) 
        order += index * weights[i]
        order += 1 
    return order
