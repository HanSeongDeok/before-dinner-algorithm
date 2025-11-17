str = input()

map = {}
for s in str:
    s = s.upper()
    map[s] = map[s] + 1\
            if s in map\
            else 1

max_value = max(map.values())

max_keys=[k for k, v in map.items() if v == max_value]

print("?")\
    if len(max_keys) > 1\
    else print(max_keys.pop()) 





