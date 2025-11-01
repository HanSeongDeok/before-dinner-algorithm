
# @Day 1
def solution(land):
    dp = [[0] * 4 for l in land]
    dp[0] = land[0]

    for l in range(1, len(land)):
        for idx, v in enumerate(land[l]):
            dp[l][idx] = max(dp[l-1][i] + v for i in range(4) if i != idx)

    return max(dp[-1])


print(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1]]))
