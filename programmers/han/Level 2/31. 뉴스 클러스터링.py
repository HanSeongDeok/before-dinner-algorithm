def solution(str1, str2):
    answer = 0
    rs_key_upper = lambda str: remove_special_key_upper(str)
    jacard_1 = create_jacard_arr(rs_key_upper(str1), [])
    jacard_2 = create_jacard_arr(rs_key_upper(str2), [])
    intersection = 0
    A, B = len(jacard_1), len(jacard_2) 
    for i in jacard_1:
        if i in jacard_2:
           intersection += 1
           jacard_2.remove(i) 
    union = A + B - intersection   
    return int((intersection / union) * 65536)

def create_jacard_arr(str, arr):
    for i in range(len(str)-1):
       arr.append(str[i:i+2])
    return arr  

def remove_special_key_upper(str):
    remove_chr = " ~@#$%!&*()_+-=[]{}|;:'\",.<>?/1234567890"
    for i in remove_chr:
        str = str.replace(i,"")
    return str.upper()    
    
    

#print(solution('FRANCE','french'))
#print(solution('handshake','shake hands'))
print(solution('aa1+aa2', 'AAAA12'))
print(solution('E=M*C^2', 'e=m*c^2'))