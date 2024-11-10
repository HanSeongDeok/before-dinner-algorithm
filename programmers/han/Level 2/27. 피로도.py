def solution(k, dungeons):
    permute = []
    custom_permute([], dungeons, permute)
    count, max_count = 0, 0
    for dungeons in permute:
        init_fatigue = k
        count = 0
        for need, consumption in dungeons:
            if init_fatigue >= need:
                init_fatigue -= consumption
                count += 1
            else:
                break
        max_count = max(count, max_count)
    return max_count

def custom_permute(current, remaining, permute):
        if not remaining:
            permute.append(current[:])
            return
        
        for i in range(len(remaining)):
            current.append(remaining[i])
            custom_permute(current, remaining[:i] + remaining[i+1:], permute)
            current.pop()

# def custom_combination(index, current, dungeons):
#         if len(dungeons) == len(current):
#             combination.append(current[:])
#             return
#         for i in range(index, len(dungeons)):
#             current.append(dungeons[i])
#             custom_combination(index + 1, current)
#             current.pop()

print(solution(80, [[80,20],[50,40],[30,10]]))