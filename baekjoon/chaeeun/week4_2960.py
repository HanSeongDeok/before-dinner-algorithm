def find_kth(N, K):
    is_prime = [True] * (N + 1)
    count = 0
    result = 0

    for i in range(2, N + 1):
        if not is_prime[i]:
            continue
        for j in range(i, N + 1, i):
            if not is_prime[j]:
                continue

            count += 1
            is_prime[j] = False
            if count == K:
                result = j
                return result

N, K = map(int, input().split())

print(find_kth(N, K))
