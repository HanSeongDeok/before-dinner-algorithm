def solution(numbers):
    result_set = set()
    
    for i in range(len(numbers) - 1):
        for j in range(i + 1, len(numbers)):
            sum_value = numbers[i] + numbers[j]
            result_set.add(sum_value)
    
    result_list = sorted(result_set)
    return result_list
