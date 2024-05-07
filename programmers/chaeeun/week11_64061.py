def solution(board, moves):
    answer = 0
    
    basket = []
    for move in moves:
        col = move - 1
        for row in range(len(board)):
            if board[row][col] != 0:
                basket.append(board[row][col])
                board[row][col] = 0  
                if len(basket) > 1 and basket[-1] == basket[-2]:
                    basket.pop()  
                    basket.pop()
                    answer += 1  
                break
                
    return answer * 2
