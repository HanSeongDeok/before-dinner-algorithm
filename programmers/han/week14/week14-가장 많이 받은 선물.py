def solution(friends, gifts):
    score_dict = {i : [0] * len(friends) for i in friends}
    
    for i in gifts:
        giver = i.split(" ")[0] 
        reciver = i.split(" ")[1]
        
        score_board = score_dict[giver]
        score_board[friends.index(reciver)] += 1
    
    gift_values = [0] * len(friends)
    answer_dict = {}
    for index, list in enumerate(score_dict.values()):
        gift_values[index] += sum(list)
        for i in range(len(list)):
            if list[i] > 0:
                if friends[index] in answer_dict:
                    answer_dict[friends[index]] += int(list[i] > score_dict[friends[i]][index])
                else:
                    answer_dict[friends[index]] = int(list[i] > score_dict[friends[i]][index])
                gift_values[i] -= list[i] 
                 
    for index, list in enumerate(score_dict.values()):
        for i in range(len(list)):
            if index != i and list[i] == 0\
                and score_dict[friends[i]][index] == 0\
                and friends[index] in answer_dict:
                answer_dict[friends[index]] += int(gift_values[index] > gift_values[i])

            if list[i] != 0 and score_dict[friends[i]][index] == list[i]:
                if gift_values[index] > gift_values[i]:
                    answer_dict[friends[index]] += 1
    return max(answer_dict.values())

print(solution(["joy", "brad", "alessandro", "conan", "david"],
              ["alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"]))