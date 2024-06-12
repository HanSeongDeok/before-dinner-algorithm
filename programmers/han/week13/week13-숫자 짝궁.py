def solution(X, Y):
    max_ = str(max(int(X), int(Y)))
    min_ = list(str(min(int(X), int(Y))))
    same_num = []
    for i in max_:
        if i in min_:
            min_[min_.index(i)] = "x"
            same_num.append(i)
    
    same_num = sorted(same_num, reverse=True)
    if(len(same_num)==0):
        return "-1"
    elif(same_num[0]==0):
        return "0"
    
    return "".join(same_num)

print(solution("100", "123450"))

# 시간 초과 어떻게 하는 지 몰라서 답지 참고
def solution2(X, Y):
    result = ''
    a = [0,0,0,0,0,0,0,0,0,0]
    b = [0,0,0,0,0,0,0,0,0,0]
    
    for i in X:
        value = int(i)
        a[value] += 1
    
    for i in Y:
        value = int(i)
        b[value] += 1
    
    for i in range(9,-1,-1):
        value = str(i) * min(a[i],b[i])
        result += value
 
    if(len(result) == 0):
        return '-1'
    if(result[0] == '0'):
        return '0'
              
    return result
 