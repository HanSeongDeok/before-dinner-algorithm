def is_right(s):
    stack = []
    for char in s:
        if char == '(':
            stack.append(char)
        else:  # char == ')'
            if not stack:
                return False
            stack.pop()
    return not stack

T = int(input())
results = []
for _ in range(T):
    results.append("YES\n" if is_right(input()) else "NO\n")

print(''.join(results))
