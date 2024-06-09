def solution(babbling):
    possible = ["aya", "ye", "woo", "ma"]
    answer = 0
    for i in babbling:
        check = i
        for j in possible:
            if is_dupl(j, check):
               continue
            check = check.replace(j, " ") #ayayeayaye 일 경우 때문에 " "를 해야 하네...
        if check == "":
            answer += 1      
    return answer

def is_dupl(j, check):
    if j * 2 in check: 
        return True
    return False
        
print(solution(["ayaya", "uuu", "yeye", "yemawoo", "ayaayaa"]))