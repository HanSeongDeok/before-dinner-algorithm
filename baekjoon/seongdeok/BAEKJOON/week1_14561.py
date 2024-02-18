cnt = int(input())

for i in range(cnt):
    A, n = map(int, input().split())
    
    res = ""
    while A > 0:
        list = "0123456789ABCDEF"
        A, r = divmod(A, n)
        res += str(list[r])
    
    if res == res[::-1]: print(1)
    else: print(0)
    
    