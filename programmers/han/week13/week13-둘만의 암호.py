def solution(s, skip, index):
    answer = []
    skip_list = list(skip)
    for c in s:
        cnt = 0
        while cnt < index:
            c = chr((ord(c) - ord('a') + 1) % 26 + ord('a'))
            if c not in skip_list:
                cnt += 1
        answer.append(c)
    return ''.join(answer)

print(solution("aukks","wbqd",5))