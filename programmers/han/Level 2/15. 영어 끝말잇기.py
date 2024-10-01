def solution(n, words):
    cycle, turn_now = 1, 1
    checkpoints = {
        0 : [], # duple point
        1 : "", # wrong point
    }
    
    for v in words:    
        if(len(checkpoints[0]) > 0 and v in checkpoints[0]):
            return [turn_now, cycle]
        
        if(checkpoints[1] != "" and checkpoints[1] != v[:1]):
            return [turn_now, cycle]
        
        checkpoints[0].append(v)
        checkpoints[1] = v[-1:]
        
        if(turn_now % n == 0):
            turn_now = 0
            cycle += 1
        
        turn_now += 1
        
            
    return [0, 0]

print(solution(3, 	["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]))