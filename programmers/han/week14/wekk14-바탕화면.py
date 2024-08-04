def solution(wallpaper):
    start, end = [-1, -1], [-1, -1]
    cnt = 0
    for i in wallpaper:
        if '#' in i and start[0] == -1:
            start[0] = cnt
        if '#' in i and start[1] == -1:
            start[1] = i.index('#')  
        if '#' in i:
            end[0] = cnt + 1
            start[1] = min(i.index('#'), start[1])
            end[1] = max(len(i) - i[::-1].index('#'), end[1])
        cnt += 1   
    return start + end

print(solution(["..........", ".....#....", "......##..", "...##.....", "....#....."]))
