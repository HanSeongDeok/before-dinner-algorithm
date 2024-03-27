def solution(price, money, count):
    target_money = sum([price * i for i in range(1, count + 1)])
    return target_money - money\
                if target_money > money\
                else 0