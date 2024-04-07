def solution(dartResult):
    scores = []
    num = ''
    for char in dartResult:
        if char.isdigit():
            num += char
        elif char in ['S', 'D', 'T']:
            n = int(num)
            if char == 'S':
                scores.append(n)
            elif char == 'D':
                scores.append(n ** 2)
            elif char == 'T':
                scores.append(n ** 3)
            num = ''
        elif char == '*':
            if len(scores) > 1:
                scores[-2] *= 2
            scores[-1] *= 2
        elif char == '#':
            scores[-1] *= -1

    return sum(scores)
