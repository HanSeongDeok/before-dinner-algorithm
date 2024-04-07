def solution(participant, completion):
    map = {}
    for p in participant:
        map[p] = map.get(p, 0) + 1
        
    for c in completion:
        map[c] -= 1
    
    for key in map:
        if map[key] != 0:
            return key
