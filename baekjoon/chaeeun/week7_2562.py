nums = []
for _ in range(9):
  nums.append(int(input()))

max = max(nums)
idx = nums.index(max) + 1

print(max)
print(idx)