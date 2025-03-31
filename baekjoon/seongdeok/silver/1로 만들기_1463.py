import sys
input = sys.stdin.read
data = int(input().splitlines()[0])
counts = []
dp_counts = [0] * (data + 1)

for i in range(2, data + 1):
    dp_counts[i] = dp_counts[i - 1] + 1
    if (i % 2 == 0):
        dp_counts[i] = min(dp_counts[i], dp_counts[i // 2] + 1)
    if (i % 3 == 0):
        dp_counts[i] = min(dp_counts[i], dp_counts[i // 3] + 1)

print(dp_counts[data])

def count_dfs(value, count):
    global counts
    if value == 1:
        counts.append(count)
        return
    if value % 3 == 0:
        count_dfs(int(value / 3), count+1)
    if value % 2 == 0:
        count_dfs(int(value / 2), count+1)    
    count_dfs(value - 1, count+1)

count_dfs(data, 0)
print(min(counts))