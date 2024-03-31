def solution(arr: list) -> list:
    return [arr[i] for i in range(len(arr))
              if i == 0 or arr[i-1] != arr[i]]

print(solution([4,4,4,3,3]))