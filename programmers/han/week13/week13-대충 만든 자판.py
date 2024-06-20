def solution(keymap, targets):
    key_dict = {}
    for v in keymap:
        for i, c in enumerate(v):
            key_dict[c] = i + 1 if c not in key_dict else min(key_dict[c] , i + 1)  
    
    answer = []
    for t in targets:
        cnt = 0
        for c in t:
            if c in key_dict:
                cnt += key_dict[c]
            else:
                cnt = -1
                break
        answer.append(cnt)
    return answer

print(solution(["ABACD", "BCEFD"],["ABCD","AABB"]))