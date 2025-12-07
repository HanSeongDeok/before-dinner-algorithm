def solution2(A,B):
    permutation_list = []
    sum_arr = []
    custom_permutation(0, B, lambda x: permutation_list.append(x))
    for i in permutation_list:
        sum_arr.append(sum(k * n for k, n in zip(A, i)))
    return min(sum_arr)

def custom_permutation(start, arr, add_list_func):
    for i in range(start, len(arr)):
        if start == len(arr)-1:
            add_list_func(arr[:])
            return
        arr[i], arr[start] = arr[start], arr[i]
        custom_permutation(start + 1, arr, add_list_func)
        arr[i], arr[start] = arr[start], arr[i]

def solution(A,B):
    return sum(i * j for i, j in zip(sorted(A), sorted(B, reverse=True)))

print(solution([1, 4, 2], [5, 4, 4]))