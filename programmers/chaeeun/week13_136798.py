def count_divisors(n):
    divisors = set()
    for i in range(1, int(n**(1 / 2) + 1)):
        if n % i == 0:
            divisors.add(i)
            divisors.add(n // i)
    return len(divisors)
    
def solution(number, limit, power):
    answer = 0
    weapon = []
    for i in range(1, number + 1):
        count = count_divisors(i)
        if count > limit:
            weapon.append(power)
        else:
            weapon.append(count)
    
    answer = sum(weapon)
    return answer
