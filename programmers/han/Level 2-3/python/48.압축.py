# ord => 아스키 코드 변환 함수 chr -> ascii를 문자로 변환
def solution(msg):
    answer = []
    dictionary = {}

    # 사전 초기화
    for i in range(26):
        dictionary[chr(ord('A') + i)] = i + 1

    idx = 0
    dict_size = 27  # 다음에 들어갈 사전 번호
    while idx < len(msg):
        w = msg[idx]
        # 사전에 있는 가장 긴 문자열 찾기
        next_idx = idx + 1
        while next_idx <= len(msg) and msg[idx:next_idx] in dictionary:
            w = msg[idx:next_idx]
            next_idx += 1
        answer.append(dictionary[w])
        # 사전에 추가할 문자가 있으면 추가
        if next_idx <= len(msg):
            dictionary[msg[idx:next_idx]] = dict_size
            dict_size += 1
        idx += len(w)
    return answer



# @Day 1
def solution(msg):
    answer = []
    msg_dict = {chr(ord('A')+i): i+1 for i in range(26)}
    i = 0
    while i < len(msg) :
        w = msg[i]
        n_i = i+1
        
        while n_i <= len(msg) and msg[i:n_i] in msg_dict.keys():
            w = msg[i:n_i]
            n_i += 1
        
        answer.append(msg_dict[w])

        if msg[i:n_i] not in msg_dict.keys():
            msg_dict[msg[i:n_i]] = len(msg_dict) + 1

        i = n_i - 1

    return answer


print(solution("KAKAO"))
print(solution("TOBEORNOTTOBEORTOBEORNOT"))
print(solution("ABABABABABABABAB"))
