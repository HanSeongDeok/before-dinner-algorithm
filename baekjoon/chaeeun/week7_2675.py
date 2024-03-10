n = int(input())

for _ in range(n):
  count, str = input().split()
  for i in range(len(str)):
    print(str[i] * int(count), end = '')
  print()