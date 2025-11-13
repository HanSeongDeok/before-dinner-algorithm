def solution(m, n, board):
    board = [list(row) for row in board]
    answer = 0

    while True:
        remove = set()
        for i in range(m - 1):
            for j in range(n - 1):
                block = board[i][j]
                if block == "0":
                    continue
                if (board[i][j+1] == block and 
                    board[i+1][j] == block and 
                    board[i+1][j+1] == block):
                    remove.add((i, j))
                    remove.add((i, j+1))
                    remove.add((i+1, j))
                    remove.add((i+1, j+1))
        if not remove:
            break

        for x, y in remove:
            board[x][y] = '0'
        answer += len(remove)

        for j in range(n):
            stack = []
            for i in range(m-1, -1, -1):
                if board[i][j] != '0':
                    stack.append(board[i][j])
            for i in range(m-1, -1, -1):
                if stack:
                    board[i][j] = stack.pop(0)
                else:
                    board[i][j] = '0'
    return answer

#@ Day1
from collections import deque
def solution(m, n, board):
    answer = 0
    board_list = [list(row) for row in board] 
    isDone = False
    while not isDone:
        row_col_set = set() 
        for row in range(len(board_list)-1):
            for col in range(len(board_list[row])-1):
                base_block = board_list[row][col]
                if base_block == "X":
                    continue
                if base_block == board_list[row][col+1] and\
                    base_block == board_list[row+1][col] and\
                    base_block == board_list[row+1][col+1]:

                    row_col_set.add((row, col))
                    row_col_set.add((row, col+1))
                    row_col_set.add((row+1, col))
                    row_col_set.add((row+1, col+1))        
        
        if not row_col_set:
            isDone = True
            break

        for row, col in row_col_set:
            board_list[row][col] = 'X'
            answer += 1
        
        # [print(b) for b in board_list]

        for col in range(len(board_list[0])):
            dq = deque()
            for row in range(len(board_list)):
                if board_list[row][col] == 'X':
                    continue
                dq.appendleft(board_list[row][col])
                board_list[row][col] = 'X'
            # for row in range(len(board_list)):
            # print(dq)    
            for i in range(len(dq)):
                board_list[len(board_list)-i-1][col] = dq.popleft()

        # [print(b) for b in board_list]
        # break
    return answer






print(solution(4, 5, 
    ["CCBDE", "AAADE", "AAABF", "CCBBF"]))