def solution(board, moves):
    answer = 0
    board_dict = {}
    for i in range(len(board)):
        for j in board:
            if(j[i] == 0):
                continue
            if(i in board_dict):
                board_dict[i].append(j[i])
            else:
                board_dict[i] = [j[i]]
    
    q = []
    count = 0
    for i in moves:
        if(len(board_dict[i-1])>0):
           v = board_dict[i-1].pop(0)
           q.append(v) 
        else:
            continue
        
        if(len(q)>=2 and 
           q[len(q)-2] == q[len(q)-1]):
           del(q[len(q)-2:len(q)])
           count += 2 
    return count

print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], 
         [1,5,3,5,1,2,1,4]))