range_number = int(input())

for i in range(range_number):
    k, v = input().split()
    result = ""
    for j in v:
        result += j * int(k)
    print(result)