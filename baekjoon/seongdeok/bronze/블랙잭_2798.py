import sys
import itertools as iter

input = sys.stdin.read
data = input().splitlines()
max_value = int(data[0].split()[1])
numbers = list(map(int, data[1].split()))
comb_list = []
comb_iter_list = [sum(n) for n in list(iter.combinations(numbers, 3))]

def add_combination(arr, index):
    if len(arr) == 3:
        comb_list.append(sum(arr[:]))
        return
    
    for i in range(index, len(numbers)):
        arr.append(numbers[i])
        add_combination(arr, i+1)
        arr.pop()
        
add_combination([], 0)
print(max(n for n in comb_iter_list if n <= max_value))
print(max(n for n in comb_list if n <= max_value))

