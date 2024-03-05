word = input().upper()

dict = {}
for char in word:
  if char not in dict:
    dict[char] = 1
  else:
    dict[char] += 1

max_count = max(dict.values())
count = [k for k, v in dict.items() if v == max_count]

if len(count) > 1:
  print("?")
else:
  print(count[0])