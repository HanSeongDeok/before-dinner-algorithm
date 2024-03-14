def solution(s):
    s = s.lower()
    count = {'p': 0, 'y': 0}
    
    for char in s:
        if char in count:
            count[char] += 1
    
    return count['p'] == count['y']
