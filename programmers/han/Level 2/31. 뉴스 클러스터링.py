def solution(str1, str2):
    answer = 0
    cnt = 0
    jacard_1, jacard_2 = [], []
    chr_1, chr_2 = '', '' 
    for i, j in str1, str2:
       chr_1 += i
       chr_2 += j
       cnt += 1
       if cnt == 2:
           jacard_1.append(i)
           jacard_2.append(j)
           cnt = 0 
    return answer