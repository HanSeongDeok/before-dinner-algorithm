def solution(name, yearning, photo):
    dict_tmp = dict(zip(name, yearning))
    result = []
    for i in photo:
        sum_j = 0 
        for j in dict_tmp:
            if j in i:
                sum_j += dict_tmp[j]
        result.append(sum_j)
    return result