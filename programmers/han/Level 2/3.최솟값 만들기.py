
def solution(A,B):
    arr_list = []
    permutation_custom(0, B, lambda B: arr_list.append(B))
    return arr_list

def permutation_custom(start, arr, arr_list):
    for i in range(start, len(arr)):
        if start == len(arr) -1 :  
            arr_list(arr[:])
            return
        arr[start], arr[i] = arr[i], arr[start] 
        permutation_custom(start + 1, arr, arr_list)
        arr[i], arr[start] = arr[start], arr[i]
        
    
print(solution([1, 4, 2], [5, 4, 3]))
        