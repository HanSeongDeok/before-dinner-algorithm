num = 1
count = [0] * 10
for _ in range(3):
  num *= int(input())

while num > 0:
  count[int(num % 10)] += 1
  num //= 10

for i in range(10):
  print(count[i])