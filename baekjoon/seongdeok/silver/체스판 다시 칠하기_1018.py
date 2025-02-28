import sys
input = sys.stdin.read
data = input().splitlines()
row, col = int(data[0].split()[0]), int(data[0].split()[1])
boards = data[1:]

def check_BW_pattern(board, index):
    if index % 2 == 1:
        return check_WB_pattern(board, 0)
    cnt = 0
    for p, b in zip("BW"*4, board):
        if p != b:
           cnt += 1 
    return cnt

def check_WB_pattern(board, index):
    if index % 2 == 1:
        return check_BW_pattern(board, 0)
    cnt = 0
    for p, b in zip("WB"*4, board):
        if p != b:
           cnt += 1 
    return cnt

min_value_list = list()
for r in range(0, row - 7):
    cut_board = boards[r:r+8]
    for c in range(0, col - 7):
        BW_value = 0
        WB_value = 0
        index = 0
        for line in cut_board:
            board = line[0+c:8+c]            
            BW_value += check_BW_pattern(board, index)
            WB_value += check_WB_pattern(board, index)
            index += 1
        min_value = min(BW_value, WB_value)
        min_value_list.append(min_value)
        
print(min(min_value_list))