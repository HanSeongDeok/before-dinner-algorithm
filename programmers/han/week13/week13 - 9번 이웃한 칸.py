def solution(board, h, w):
    keyword = board[h][w]
    board_dict = {i: arr for i, arr in enumerate(board)}
    answer = 0
    for i in range(len(board_dict)):
        if h - 1 == i or h + 1 == i:
            if (board_dict[i][w] == keyword):
                answer += 1
        elif h == i:
            for j in range(len(board_dict[i])):
                if(j == w or (j != w - 1 and j != w + 1)):
                    continue
                
                if board_dict[i][j] == keyword:
                    answer += 1
    return answer

print(solution([["yellow", "green", "blue"], ["blue", "green", "yellow"], ["yellow", "blue", "blue"]], 0, 1))