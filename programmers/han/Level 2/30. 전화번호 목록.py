# 첫 번째 시도 FAIL -> 66점
def solution1(phone_book):
    answer = True
    phone_book = sorted(phone_book, key=lambda k: len(k), reverse=True)
    check_list = []
    for i in phone_book:
        for j in check_list:
            if i in j:
                return False
        check_list.append(i)
    return answer

# 두번째 시도 FAIL -> 75점
def solution2(phone_book):
    answer = True
    phone_book = sorted(phone_book, key=lambda k: len(k))
    check_list = [phone_book[0]]
    for i in range(1, len(phone_book)):
        check_value = check_list[0]
        cnt = i
        while(cnt < len(phone_book)):
            if check_value in phone_book[cnt]:
                return False
            cnt += 1
        check_list[0] = phone_book[i]
    return answer

# 세번째 시도 -> 답지 확인 PASS -> WOW!!!!
def solution_wrong(phone_book):
    phone_book = sorted(phone_book)
    for i in range(len(phone_book) - 1):
        if phone_book[i] in phone_book[i+1]: # -> ["123", "45123", "456"] 경우 예시가 True로 오답이 된다.
            return False
    return True
# startswith 접두어(prefix) 확인 "hello world".startswith("hello")
# endswith	 접미사(suffix) 확인 "hello world".endswith("world")

def solution(phone_book):
    phone_book = sorted(phone_book)
    for i in range(len(phone_book) - 1):
        if phone_book[i+1].startswith(phone_book[i]):
            return False
    return True

print(solution(["119", "97674223", "1195524421"]))