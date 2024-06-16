def solution(babbling):
    possible_words = ["aya", "ye", "woo", "ma"]
    answer = 0
    
    for word in babbling:
        original_word = word
        for possible_word in possible_words:
            if possible_word * 2 not in word:
                word = word.replace(possible_word, ' ')
        if word.strip() == '':
            answer += 1
    return answer
