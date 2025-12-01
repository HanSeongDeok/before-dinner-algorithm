index = int(input())
room_number = list(input().split() for _ in range(index))
for H, W, N in room_number:
    floar = N if int(H) > int(N) else str(int(N) % int(H))
    details = int(N) // int(H) + 1
    details = str(details) if details > 9 else "0" + str(details)
    print(floar + details)
    

index = int(input())
room_number = [list(map(int, input().split())) for _ in range(index)]

for H, W, N in room_number:
    floor = N % H if N % H != 0 else H
    details = (N // H) + (1 if N % H != 0 else 0)
    details = str(details) if details >= 10 else "0" + str(details)
    print(str(floor) + details)