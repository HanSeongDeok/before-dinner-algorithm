from functools import reduce

def solution(s):
    dict= {
        0: 'zero',
        1: 'one' ,
	    2: 'two' ,
        3: 'three' ,
	    4: 'four' ,
	    5: 'five' ,
	    6: 'six' ,
	    7: 'seven' ,
	    8: 'eight' ,
	    9: 'nine' 
    }
    for i in range(10):
        if dict[i] in s:
            s = s.replace(dict[i], str(i))
    return int(s)

def solution2(s):
    dict= {
        0: 'zero',
        1: 'one' ,
	    2: 'two' ,
        3: 'three' ,
	    4: 'four' ,
	    5: 'five' ,
	    6: 'six' ,
	    7: 'seven' ,
	    8: 'eight' ,
	    9: 'nine' 
    }
    return reduce(lambda changer, key: changer.replace(dict[key], str(key)), dict, s)

print(solution2("2three45sixseven"))