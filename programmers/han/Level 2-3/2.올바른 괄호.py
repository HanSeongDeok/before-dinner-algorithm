from collections import deque

# @Day 1 
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


# @Day2
def solution3(s): 
    count = 0
    for c in s:
        if c == '(':
            count += 1
        elif c == ')':
            if count == 0:
                return False
            count -= 1  
    return count == 0

def solution4(s):
    dq = deque();
    for c in s:
        if c == '(':
            dq.append(c)
        elif c == ')':
            if not dq:
                return False
            dq.pop()
    return len(dq) == 0


# @Day 3
def solution5(s):
    count = 0
    for c in s:
      if c == '(':
        count += 1
      elif c == ')':
        if count == 0:
            return False
        count -= 1
    return count == 0

def solution6(s):
    dq = deque();
    for c in s:
        if c == '(':
            dq.append(c)
        elif c == ')':
            if not dq:
                return False
            dq.pop()
    return len(dq) == 0

# @ Day 4
def solution(s):
    dq = deque()
    for c in s:
        if c == '(':
            dq.append(c)
        elif c == ')':
            if not dq:
                return False
            dq.pop()
    return len(dq) == 0






def solution(s):
    result = 0
    for c in s:
        if c == '(':
            result += 1
        elif c == ')':
            if result == 0:
                return False
            result -= 1
    return result == 0





print(solution("()()"))
print(solution("(())()"))
print(solution(")()("))
print(solution("(()("))

