def solution(friends, gifts):
    sent_gifts = {} # 준 선물
    received_gifts = {} # 받은선물
    predicted_gifts = {} # 선물지수
    gift_records = {} # 선물기록
    for sender in friends:
        individual_gift_record = {}
        for receiver in friends:
            if sender == receiver:
                continue
            individual_gift_record[receiver] = 0
        gift_records[sender] = individual_gift_record
        predicted_gifts[sender] = 0
        sent_gifts[sender] = 0
        received_gifts[sender] = 0

    # 선물 주고받기
    for gift in gifts:
        sender, receiver = gift.split()
        gift_records[sender][receiver] += 1
        sent_gifts[sender] += 1
        received_gifts[receiver] += 1

    # 친구들 간의 비교
    for i in range(len(friends) - 1):
        for j in range(i + 1, len(friends)):
            friend_a = friends[i]
            friend_b = friends[j]

            a_to_b = gift_records[friend_a][friend_b]
            b_to_a = gift_records[friend_b][friend_a]

            if a_to_b > b_to_a:
                predicted_gifts[friend_a] += 1
            elif b_to_a > a_to_b:
                predicted_gifts[friend_b] += 1
            else:
                friend_a_index = sent_gifts[friend_a] - received_gifts[friend_a]
                friend_b_index = sent_gifts[friend_b] - received_gifts[friend_b]

                if friend_a_index > friend_b_index:
                    predicted_gifts[friend_a] += 1
                elif friend_b_index > friend_a_index:
                    predicted_gifts[friend_b] += 1

    return max(predicted_gifts.values())
