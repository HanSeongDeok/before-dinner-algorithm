# 1 TRY 실패
def solution(n, t, m, p):
    answer = ''
    hex_expression = {10: "A", 11: "B", 12: "C", 13: "D", 14: "E", 15: "F"}
    def convert_form(v):
        result = ''
        if v == 0:
            return '0'
        while v > 0:
            remainder = v % n
            if remainder >= 10:
                result = hex_expression[remainder] + result
            else:
                result = str(remainder) + result
            v //= n
        return result
    
    form_list = []    
    for i in range(0, 1000 * m): 
        form_list.extend(list(convert_form(i)))
        if len(form_list) >= t * m:
            break
    
    for i in range(p - 1, len(form_list), m):
        answer += form_list[i]
        if len(answer) == t:
            break
    return answer

print(solution(16, 16, 2, 1))
    