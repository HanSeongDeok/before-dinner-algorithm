import sys
input = sys.stdin.read
data = input().splitlines()
number_list = list(map(int, data[1].split()))
def decimal_number_count(number_list):
    count = 0
    for number in number_list:
        if number < 2: continue
        is_decimal = True
        for n in range(2, int(number/2) + 1):
            if divmod(number, n)[1] == 0:
                is_decimal = False
                break
        if is_decimal:
            count += 1
    return count
print(decimal_number_count(number_list))