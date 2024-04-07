def solution(n, arr1, arr2):
    answer = []
    for i in range(n):

        binary1 = format(arr1[i], 'b')
        binary2 = format(arr2[i], 'b')
        
        binary1 = '0' * (n - len(binary1)) + binary1
        binary2 = '0' * (n - len(binary2)) + binary2

        row = ""
        for j in range(n):
            if binary1[j] == '1' or binary2[j] == '1':
                row += "#"
            else:
                row += " "
        answer.append(row)
    return answer
