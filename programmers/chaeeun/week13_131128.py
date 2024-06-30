def solution(X, Y):
    countX = [0] * 10
    countY = [0] * 10
    
    for char in X:
        countX[int(char)] += 1
    for char in Y:
        countY[int(char)] += 1
    
    common = []
    
    for i in range(9, -1, -1):
        if countX[i] > 0 and countY[i] > 0:
            common += str(i) * min(countX[i], countY[i])
    
    if not common:
        return "-1"
    
    if common[0] == '0':
        return '0'
    
    return ''.join(common)
