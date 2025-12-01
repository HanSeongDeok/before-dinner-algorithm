
input_list = []
for i in range(9):
    input_list.append(int(input()))

max = max(input_list)

for i in range(len(input_list)):
    if(input_list[i] == max):
        print(max)
        print(i + 1)