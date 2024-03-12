import math

ABC = []
for i in range(3):
    ABC.append(int(input()))
        
multiple = math.prod(ABC)
result = [0] * 10

for i in str(multiple):
    result[int(i)] += 1
    
[print(i) for i in result] 