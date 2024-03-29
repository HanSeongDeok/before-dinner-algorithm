def solution(price, money, count):
    answer = -1
    
    total = 0
    fee = price
    for _ in range(count):
        total += fee
        fee += price

    return total - money if total > money else 0
