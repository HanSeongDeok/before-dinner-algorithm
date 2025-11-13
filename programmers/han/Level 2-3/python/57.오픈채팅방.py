# @Day 1
def solution(record):
    answer = []
    command_uid_list = []
    uid_name = {}
    for r in record:
        c, uid = r.split(' ')[0], r.split(' ')[1]
        command_uid_list.append({c : uid}) 
        if c != "Leave":
            name = r.split(' ')[2]
            uid_name[uid] = name
    
    for cu in command_uid_list:
        command = uid = ''
        for k, v in cu.items():
            command, uid = k, v
        if command == "Enter":
            answer.append(f"{uid_name[uid]}님이 들어왔습니다.")
        elif command == "Leave":
            answer.append(f"{uid_name[uid]}님이 나갔습니다.")

    return answer

print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))