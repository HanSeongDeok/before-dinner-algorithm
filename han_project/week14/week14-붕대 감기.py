# 아 이런.. 공격 받으면 Heal Stack 초기화를 간과함 이런..
def solution(bandage, health, attacks):
    attack_dict = {i[0]: i[1] for i in attacks}
    max_health = health
    max_time = attacks[len(attacks)-1][0]   
    heal_stack = 0
    for i in range(1, max_time+1):
        if i in attack_dict:
            health -= attack_dict[i]
            heal_stack = 0  # 이거 빼먹음..
            if health <= 0:
                health = -1
                break
            continue
        
        heal_stack += 1
        health += bandage[1]
        
        if heal_stack == bandage[0]:
            health += bandage[2]
            heal_stack = 0
    
        if health > max_health:
            health = max_health
    
    return health