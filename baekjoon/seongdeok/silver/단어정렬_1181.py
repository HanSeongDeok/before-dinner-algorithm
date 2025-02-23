index = int(input())
word_list = sorted(set([input() for _ in range(index)]), key=lambda w : (len(w), w))
[print(word) for word in word_list]


