def solution(participant, completion):
    participant.sort()
    completion.sort()
    i = 0
    result = ""
    for a in completion:
        if a != participant[i]:
            result = participant[i]
            break
        i += 1
    if result == "":
        result = participant[-1]
    return result

def solution2(participant, completion):
    result = ''.join(list(set(participant) - set(completion)))
    if result == '':
        previous = ''
        participant.sort()
        for i in participant:
            if(previous == i):
                result = previous
                break
            previous = i
    return result

print(solution2(["mislav", "bstanko", "mislav", "ana"], ["bstanko", "ana", "mislav"]))