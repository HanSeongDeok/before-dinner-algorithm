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


print(solution(3, ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]))
print(solution(2, ["hello", "one", "even", "never", "now", "world", "draw"]))