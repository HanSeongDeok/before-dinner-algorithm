import math
arr = list(map(int, input().split()))
a = arr[0]
b = arr[-1]

while b > 0:
    a, b = b, a % b
print(a)   
print((arr[0] // a) * (arr[-1] // a) * a)  

#print(math.gcd(a, b))
#print(math.lcm(a, b))