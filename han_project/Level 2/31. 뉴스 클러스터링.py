def solution(str1, str2):
    jacard_1 = create_jacard_arr(str1, [])
    jacard_2 = create_jacard_arr(str2, [])
    intersection = 0
    A, B = len(jacard_1), len(jacard_2) 
    for i in jacard_1:
        if i in jacard_2:
           intersection += 1
           jacard_2.remove(i) 
    union = A + B - intersection   
    return int((intersection / union) * 65536)

def create_jacard_arr(str, arr):
    sp_key_chekcer = lambda str: exist_special_key(str)
    for i in range(len(str)-1):
        if(sp_key_chekcer(str[i:i+2])):
            arr.append(str[i:i+2].upper())
    return arr  

def exist_special_key(str):
    remove_chr = " ~@#$%!&*()_+-=[]{}|;:'\",.<>?/1234567890"
    for i in remove_chr:
        if i in str: 
            return False
    return True    

print(solution('FRANCE','french'))
print(solution('handshake','shake hands'))
print(solution('aa1+aa2', 'AAAA12'))
print(solution('E=M*C^2', 'e=m*c^2'))