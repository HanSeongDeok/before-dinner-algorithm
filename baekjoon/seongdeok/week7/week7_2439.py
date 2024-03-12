number = int(input())

for i in range(number):
    check = False
    for j in range(number):
        if(i == (number - j - 1)):
            check = True   
        if(check): print('*', end="")
        else: print(" ", end="")
    print()