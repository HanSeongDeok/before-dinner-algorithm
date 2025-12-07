def solution2(s):
    check = s
    for i in s:
        check = check.replace(f'{i*2}', '')
        if len(check) == 0:
            return 1
    return 0

def solution(s):
    stack = []
    for i in s:
        if(stack and stack[-1] == i):
            stack.pop()
        else:
            stack.append(i)
    return 1 if len(stack) == 0 else 0

print(solution('baabaa'))