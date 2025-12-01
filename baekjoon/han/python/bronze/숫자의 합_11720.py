index = int(input())
values = list(input())
answer = 0
s_p, e_p = 0, index - 1
while (e_p >= s_p):
    if e_p == s_p:
        answer += int(values[s_p])
        break    
    answer += int(values[s_p]) + int(values[e_p]) 
    s_p += 1
    e_p -= 1
print(answer)