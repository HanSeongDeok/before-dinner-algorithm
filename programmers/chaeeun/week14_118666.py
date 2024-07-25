def solution(survey, choices):
    result = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0}
    
    for i, n in enumerate(survey):
        num = choices[i] - 4
        if num != 0:
            if num < 0:  # 비동의
                result[n[0]] += abs(num)
            else:
                result[n[1]] += num
    
    first = 'R' if result['R'] >= result['T'] else 'T'
    second = 'C' if result['C'] >= result['F'] else 'F'
    third = 'J' if result['J'] >= result['M'] else 'M'
    fourth = 'A' if result['A'] >= result['N'] else 'N'
    
    return first + second + third + fourth
