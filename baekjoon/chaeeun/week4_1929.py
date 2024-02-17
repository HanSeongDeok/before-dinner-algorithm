import math

M, N = map(int, input().split())

is_prime_arr = [True] * (N + 1)
is_prime_arr[1] = False;

for i in range(2, int(math.sqrt(N)) + 1) :
  if not is_prime_arr[i]:
    continue
  for j in range(i * i, N + 1, i):
    is_prime_arr[j] = False


for i in range(M, N + 1):
  if is_prime_arr[i] :
    print(i)
