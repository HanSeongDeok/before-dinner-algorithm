def solution(m, n, puddles):
    MOD = 1000000007

    # dp[i][j]: (j,i) 좌표까지 오는 경로의 수
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    dp[1][1] = 1  # 시작점

    # 웅덩이 위치를 set에 미리 저장 (x, y)
    puddle_set = set(tuple(p) for p in puddles)

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if (j, i) == (1, 1):
                continue
            if (j, i) in puddle_set:
                dp[i][j] = 0
            else:
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD

    return dp[n][m]

# @Day 1
def solution(m, n, puddles):
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    dp[1][1] = 1

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if i == 1 and j == 1:
                continue
            elif [j, i] in puddles:
                dp[i][j] = 0
            else:
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007

    return dp[n][m]



print(solution(4, 3, [[2, 2]]))