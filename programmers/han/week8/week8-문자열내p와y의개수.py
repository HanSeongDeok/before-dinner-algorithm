def solution(s: str) -> bool:
    map_s = {"p": 0, "y": 0}
    for i in s:
        if(i.lower() == "p"): map_s["p"] += 1
        elif(i.lower() == "y"): map_s["y"] += 1

    return map_s["p"] == map_s["y"]

print(solution("Pyy"))