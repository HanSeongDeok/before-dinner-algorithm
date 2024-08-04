# 오답
def solution2(today, terms, privacies):
    answer = []
    cnt = 1
    terms_dicts,privacies_dicts = {}, {}
    
    for i in terms:
        terms_dicts[i.split(" ")[0]] = i.split(" ")[1] 
    
    for i in privacies:
        privacies_dicts[i.split(" ")[0]] = i.split(" ")[1]
    
    today = today.split('.')[0] + today.split('.')[1] + today.split('.')[2]
    for j, i in zip(privacies_dicts,privacies_dicts.values()): 
        year,mon,day = int(j.split('.')[0]),int(j.split('.')[1]),j.split('.')[2] 
        term = int(terms_dicts[i])
        is_update = (term + mon) > 12
        update = ''
        if is_update:
            update = '0'+str((term + mon)-12)\
                if (term + mon)-12 < 10\
                else str((term + mon)-12)
        else:
            update = '0'+str((term + mon))\
                if (term + mon) < 10\
                else str((term + mon)) 
        update_day = str(year+1)+update+str(day)\
            if term + mon > 12\
            else str(year)+update+str(day)
        if int(update_day) <= int(today):
            answer.append(cnt)
        cnt += 1 
    return answer

def solution(today, terms, privacies):
    answer = []
    term_dict = {t.split(' ')[0]: int(t.split(' ')[1]) for t in terms}
    ymd = today.split('.')
    today_y, today_m, today_d = int(ymd[0]), int(ymd[1]), int(ymd[2])
    cnt = 1
    for p in privacies:
        date, term = p.split(' ')[0], term_dict[p.split(' ')[1]] 
        ymd = date.split('.') 
        date_y, date_m, date_d = int(ymd[0]), int(ymd[1]), int(ymd[2]) 
        
         # 유효기간 계산에서 24개월 이상 즉 36개월 이상 초과 될 가능성을 배재하여 오답이 되었다.
        date_m += term
        while date_m > 12:
            date_m -= 12
            date_y += 1
            
        compare_today = today_y * 10000 + today_m * 100 + today_d
        compare_date = date_y * 10000 + date_m * 100 + date_d 
        
        if compare_today >= compare_date:
            answer.append(cnt)
        cnt += 1
    return answer


print(solution("2022.05.19",
               ["A 6", "B 12", "C 3"],
               ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]))