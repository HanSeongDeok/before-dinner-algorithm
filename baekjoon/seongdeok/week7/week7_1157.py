str = input()

map = {}
for s in str:
    #casefold()
    s = s.upper()
    map[s] = map[s] + 1\
            if s in map\
            else 1
# print(map)

max_value = max(map.values())
#print(max_value)

max_keys=[
    k 
    for k, v in map.items() 
    if v == max_value
]
#print(max_keys)

print("?")\
    if len(max_keys) > 1\
    else print(max_keys.pop()) 





