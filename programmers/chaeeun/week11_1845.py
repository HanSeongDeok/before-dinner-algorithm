def solution(nums):
    choice_num = len(nums) // 2
    unique_mon = set(nums)
    
    if choice_num > len(unique_mon):
        return len(unique_mon)
    else:
        return choice_num
