from collections import deque

# 1 -> 스택 활용 방안
def solution (s):
    stack = deque()
    for c in s:
        if c == '(':
            stack.append(c)
        elif c == ')':
            if not stack:
                return False
            stack.pop()
    return len(stack) == 0


# 2 -> count 활용 방안
def solution2 (s):
    count = 0
    for c in s:
        if c == '(':
            count += 1
        elif c == ')':
            if count == 0:
                return False
            count -= 1
    return count == 0


print(solution2("()()"))
print(solution2("(())()"))
print(solution2(")()("))
print(solution2("(()("))