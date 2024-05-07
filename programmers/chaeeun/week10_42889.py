def solution(N, stages):
    answer = []
    
    failure = {}
    playerNum = len(stages)
    for i in range(1, N + 1):
        if playerNum == 0:
            failure[i] = 0
        else:
            failure[i] = stages.count(i) / playerNum
            playerNum -= stages.count(i)
        
    answer = sorted(failure, key = lambda x : failure[x], reverse=True)

    return answer
