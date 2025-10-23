def solution(n, t, m, p):
    hex_dict = {
        10: "A", 11: "B", 12: "C", 13: "D", 14: "E", 15: "F",
    }
    save = []
    result = []
    def create_n_k(num, k):
        if not num: return "0";
        n_k_str = ""
        while num:
            temp = num % k
            if k > 10 and temp in hex_dict.keys():
                temp = hex_dict[temp]
            n_k_str = str(temp) + n_k_str
            num //= k
        return n_k_str
    
    for i in range(t * m):
        v = create_n_k(i, n)
        save.extend(list(v))
        if i % m + 1 == p:
            result.append(save[i])
            
    return ''.join(result)


print(solution(2, 4, 2, 1))    # Expected: "0111"
print(solution(16, 16, 2, 1))  # Expected: "02468ACE11111111"
print(solution(16, 16, 2, 2))  # Expected: "13579BDF01234567"
