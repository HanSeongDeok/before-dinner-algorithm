def solution(n, m, section):
    count = 0
    i = 0
    
    while i < len(section):
        count += 1
        current = section[i]
        
        max_range = current + m - 1
        
        while i < len(section) and section[i] <= max_range:
            i += 1
    
    return count
