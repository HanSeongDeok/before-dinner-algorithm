import sys
input = sys.stdin.read
data = input().splitlines()

N_set = set(map(int, data[1].split()))
N_list = list(map(int, data[1].split()))
N_dict = dict((key,0) for key in N_set)
for n in N_list:
    N_dict[n] += 1

M = list(map(int, data[3].split()))

print(' '.join(list(map(str, [N_dict[m] if m in N_set else 0 for m in M]))))
    
        