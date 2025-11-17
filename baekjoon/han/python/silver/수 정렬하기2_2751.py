index = int(input())
number_list = list(int(input()) for _ in range(index))
def quick_sort(numbers, start, end):
    if start < end:
        p = select_pivot(numbers, start, end)
        quick_sort(numbers, start, p-1)
        quick_sort(numbers, p+1, end)
    return numbers
        
def select_pivot(numbers, start, end):
    pivot = numbers[end]
    index = start -1
    for i in range(start, end):
        if numbers[i] <= pivot:
            index += 1
            numbers[index]
    numbers[index+1], numbers[end] = numbers[end], numbers[index+1]    
    return index+1      
 
[print(n) for n in quick_sort(number_list, 0, index-1)]

# Input은 무조건 한번에 받아야 한다.
import sys
input = sys.stdin.read
data = input().splitlines()

index = int(data[0])
number_list = list(int(data[i]) for i in range(1, index+1))
[print(n) for n in sorted(number_list)]

# def quick_sort(numbers, start, end):
#     if len(numbers) <= 1:
#         return numbers
#     p = numbers[0]
#     left_numbers = [n for n in numbers if n <= p]
#     right_numbers = [n for n in numbers if n > p]
#     return quick_sort(left_numbers) + [p] + quick_sort(right_numbers)