def solution(sizes):
    x = 0
    y = 0
    for size in sizes:
        if size[0] < size[1]:
            size[0], size[1] = size[1], size[0]
        if size[0] > x:
            x = size[0]
        if size[1] > y:
            y = size[1]
    return x * y
