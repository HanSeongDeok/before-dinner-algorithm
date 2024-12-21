# 오답 
def solution(maps):
    answer = -1
    def map_dfs(row, col, value, map_set):
        nonlocal answer
        if row == len(maps) or col == len(maps[0]) or row < 0 or col < 0:
            return 
        
        if  maps[row][col] == 0 or [row, col] in map_set:
            return 

        if row == len(maps)-1 and col == len(maps[0])-1:
            answer = value
            return
    
        map_set.append([row, col])
        map_dfs(row + 1, col, value + maps[row][col], map_set)
        map_dfs(row, col + 1, value + maps[row][col], map_set)
        map_dfs(row - 1, col, value + maps[row][col], map_set)

    map_dfs(0,0,1,[])
    return answer

# Assert 11
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))


# 해답
