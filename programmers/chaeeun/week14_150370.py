def solution(today, terms, privacies):
    answer = []
    
    today_year, today_month, today_day = map(int, today.split('.'))
    
    term_dict = {}
    for term in terms:
        key, value = term.split()
        term_dict[key] = int(value)
    
    for idx, privacy in enumerate(privacies):
        privacy_date, privacy_category = privacy.split()
        
        year, month, day = map(int, privacy_date.split('.'))
        
        # 약관 기간 추가
        month += term_dict[privacy_category]
        
        while month > 12:
            year += 1
            month -= 12
        
        # 날짜 비교
        if (year < today_year or 
            (year == today_year and month < today_month) or 
            (year == today_year and month == today_month and day <= today_day)):
            answer.append(idx + 1)
    
    return answer
