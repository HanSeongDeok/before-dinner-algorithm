number_list = [i for i in map(int, input().split())]
sort_list = ["ascending", "descending", "mixed"]

if number_list == sorted(number_list):
    print(f"{sort_list[0]}")
elif number_list == sorted(number_list, reverse=True):
    print(f"{sort_list[1]}")
else:
    print(f"{sort_list[2]}")