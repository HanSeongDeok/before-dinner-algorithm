num = int(input())

#arr = input().split()
#temp = []
#for i in arr:
#    temp.append(int(i))

arr = list(map(int, input().split()))
arr.sort()
print(arr[0] * arr[-1]) # len(arr)-1 

