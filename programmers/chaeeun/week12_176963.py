def solution(name, yearning, photo):
    name_to_yearning = {}
    for i in range(len(name)):
        name_to_yearning[name[i]] = yearning[i]

    result = []
    for group in photo:
        total_yearning = 0
        for person in group:
            if person in name_to_yearning:
                total_yearning += name_to_yearning[person]
        result.append(total_yearning)

    return result
