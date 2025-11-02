from collections import defaultdict
import math
# @Day 1
def solution(fees, records):
    answer = []
    park_total = defaultdict(int)
    park_in = {}
    basic_time, basic_fee, unit_time, unit_fee = fees
    
    for r in records:
        time, number, command = r.split(' ')
        h, m = time.split(':')
        convert_m = int(h) * 60 + int(m)
        if command == "IN":
            park_in[number] = convert_m
        else:
            park_total[number] += convert_m - park_in[number]
            del park_in[number]
    
    for num, t in park_in.items():
        convert_m = 23 * 60 + 59
        park_total[num] += convert_m - t

    park_total = sorted(park_total.items(), key=lambda x: int(x[0]))
    for pt in park_total:
        if pt[1] <= basic_time:
            answer.append(basic_fee)
        else:
            answer.append(basic_fee + math.ceil((pt[1] - basic_time) / unit_time) * unit_fee)
    return answer

print(solution(
    [180, 5000, 10, 600], 
    ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))