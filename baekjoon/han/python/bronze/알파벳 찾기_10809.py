word = input()
index_str = ""
for i in range(97, 123):
    index_str += f"{word.index(chr(i)) if chr(i) in word else -1} "
print(index_str.strip())