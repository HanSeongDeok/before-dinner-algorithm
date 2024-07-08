def solution(board, h, w):
    n = len(board)
    
    count = 0
    
    color = board[h][w]
    
    dh = [0, 1, -1, 0]
    dw = [1, 0, 0, -1]

    for i in range(4):
        new_height = h + dh[i]
        new_width = w + dw[i]
        
        if 0 <= new_height < n and 0 <= new_width < n:
            if board[new_height][new_width] == color:
                count += 1
                
    return count
