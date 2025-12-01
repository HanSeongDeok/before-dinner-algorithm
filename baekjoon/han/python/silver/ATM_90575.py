import sys
input = sys.stdin.read
data = input().splitlines()

times = list(map(int, data[1].split()))
times = sorted(times)
times_sum = 0
total_sum = 0

for t in times:
    times_sum += t
    total_sum += times_sum  
      
print(total_sum)
