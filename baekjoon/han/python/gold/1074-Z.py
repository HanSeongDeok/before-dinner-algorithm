def z(n: int, r: int, c:int ) -> int:
    if n == 0: return 0
    mid = pow(2, n-1)
    
    if r < mid:
        if c < mid:
            return z(n-1, r, c)
        else: 
            return z(n-1, r, c - mid) + pow(mid, 2)
    else:
        if c < mid:
            return z(n-1, r - mid, c) + 2 * pow(mid, 2)
        else:
            return z(n-1, r - mid, c - mid) + 3 * pow(mid, 2)
    
n, r, c = map(int, input().split())
print(z(n, r, c))
