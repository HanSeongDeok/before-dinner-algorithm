def solution(bandage, health, attacks):
    t, x, y = bandage
    curr_health = health
    success_time = 0
    attack_index = 0
    
    for time in range(1, attacks[-1][0] + 1):
        # 공격 시점
        if attack_index < len(attacks) and time == attacks[attack_index][0]:
            curr_health -= attacks[attack_index][1]
            if curr_health <= 0:
                return -1
            success_time = 0
            attack_index += 1
        else:
            # 체력 회복
            if success_time < t:
                curr_health += x
                success_time += 1
            curr_health = min(curr_health, health)

            if success_time == t:
                curr_health += y
                curr_health = min(curr_health, health)
                success_time = 0
    
    return curr_health
