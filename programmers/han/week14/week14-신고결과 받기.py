def solution(id_list, report, k):
    id_dicts = {}
    count_dicts = dict.fromkeys(id_list, 0)
    result_dicts = dict.fromkeys(id_list, 0)
    # 신고 목록 딕셔너리 생성
    for r in report:
        key, value = r.split(" ")[0], r.split(" ")[1] 
        if (key in id_dicts):
            id_dicts[key].append(value)
        else:    
            id_dicts[key] = [value]

    # 신고 당한 수 딕셔너리 생성
    for i, n in id_dicts.items():
        dupl_list = []
        for j in n:
            if j in dupl_list:
                continue
            count_dicts[j] += 1
            dupl_list.append(j)
        
    # k 값에 부합하면 해당 신고자를 가지고 있는 key 값에 count    
    for v, c in count_dicts.items():
        if c >= k:
            for i, j in id_dicts.items():
                if v in j:
                    result_dicts[i] += 1
    
    return list(result_dicts.values())

print(solution(["muzi", "frodo", "apeach", "neo"],
               ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],
               2))

print(solution(["con", "ryan"],
      ["ryan con", "ryan con", "ryan con", "ryan con"],
      3))