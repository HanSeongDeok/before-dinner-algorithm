def solution(numbers):
    answer = []
    for num in numbers:
        if num % 2 == 0:
            answer.append(num + 1)
        else:
            # 홀수면, 가장 오른쪽 0비트 찾고 1로 바꾸고, 그 오른쪽 비트(즉 1) 하나를 0으로 바꿔야 함
            bin_num = '0' + bin(num)[2:]  # 혹시 가장 왼쪽에 0이 없을때 대비
            idx = bin_num.rfind('0')
            lst = list(bin_num)
            lst[idx] = '1'
            lst[idx+1] = '0'
            answer.append(int(''.join(lst), 2))
    return answer



# @Day 1
def solution(numbers):
    answer = []

    for n in numbers:
        if n % 2  == 0:
            answer.append(n+1)
        else:
            bin_n = "0" + bin(n)[2:]
            idx = bin_n.rfind("0")
            bin_list = list(bin_n)
            bin_list[idx], bin_list[idx+1] = "1", "0"
            answer.append(int(''.join(bin_list), 2))
    return answer


print(solution([2,7]))