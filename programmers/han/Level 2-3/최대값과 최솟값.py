def solution(s):
    return f"{min(int(i) for i in s.split())} "\
           f"{max(int(i) for i in s.split())}"

print (solution("-1 -2 -3 -4"))