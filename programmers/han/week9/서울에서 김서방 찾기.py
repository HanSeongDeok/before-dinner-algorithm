def solution(seoul) -> str:
    index = [seoul.index(i) for i in seoul if i == "Kim"]
    return "김서방은 {}에 있다".format(index[0]) #int("".join(map(str, index)))

print(solution(["Jane", "Kim"]))