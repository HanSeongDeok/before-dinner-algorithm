def is_palindrome(num_str):
  return  num_str == num_str[::-1]

def to_base(n, base):
    if n == 0:
        return "0"
    nums = []
    while n:
        tmp = n % base
        if tmp >= 10:
            nums.append(chr(tmp - 10 + ord('A')))
        else:
            nums.append(str(tmp))
        n //= base
    return ''.join(reversed(nums))

T = int(input())
results = []
for _ in range(T):
    A, n = map(int, input().split())
    converted_str = to_base(A, n)
    results.append('1\n' if is_palindrome(converted_str) else '0\n')

print(''.join(results))