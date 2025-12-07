def solution(n: int) -> int:
    n_list = [int(i) for i in str(n)]
    n_list.sort(reverse=True)
    
    #result = 0
    #for i in n_list:
    #    result = result * 10 + i
   
    return int("".join(map(str,n_list))) 

print(solution(1234))