def solution(n, words):
    cycle, number = 1, 1
    dupl, last_word = [], []
    for w in words:
        if dupl and w in dupl:
            return [number, cycle]

        if last_word and last_word.pop() != w[:1]:
            return [number, cycle]

        dupl.append(w)
        last_word.append(w[-1])

        if number % n == 0:
            number = 1
            cycle += 1
        else :
            number += 1
    return [0, 0]




# @ Day 2
def solution(n, arr):
    cycle, number = 1, 1
    dupl_valid, wrong_valid = [], []
     
    for a in arr:
        if a in dupl_valid:
            return [cycle, number]
        
        if wrong_valid and wrong_valid[0] != a[:1]:
            return [cycle, number]
        
        dupl_valid.append(a)
        wrong_valid = [a[-1]]  

        if number % n == 0:
            cycle += 1
            number = 1
        else: 
            number += 1 
    return [cycle, number]


print(solution(3, ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]))
print(solution(2, ["hello", "one", "even", "never", "now", "world", "draw"]))