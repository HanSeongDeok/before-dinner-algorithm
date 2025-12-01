index = int(input())
OX_list = list(input() for _ in range(index))

for i in OX_list:
    print_cnt = 0
    temp_cnt = 0
    for ox in i:
        if ox == 'O':
           temp_cnt += 1
           print_cnt += temp_cnt
        else:
           temp_cnt = 0
    print(print_cnt)
