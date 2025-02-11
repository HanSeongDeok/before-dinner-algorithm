H, M = map(int, input().split())
timer_h = H - 1 if (M - 45) < 0 else H
timer_m = 60 - (M - 45) * -1 if (M - 45) < 0 else (M - 45)
if timer_h == -1:
    timer_h = 23
print(f"{timer_h} {timer_m}")