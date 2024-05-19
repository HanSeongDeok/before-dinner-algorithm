def solution(name, yearning, photo):
    dict_tmp = dict(zip(name, yearning))
    result = []
    for i in name:
        cnt, sum_i = 0, 0
        while cnt < len(photo):
            if i in photo[cnt]:
                sum_i += dict_tmp[i]
            cnt += 1
        result.append(sum_i)      
    return result