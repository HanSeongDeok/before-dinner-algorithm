def solution(data, ext, val_ext, sort_by):
    columns = ["code", "date", "maximum", "remain"]
    ext_index = columns.index(ext)
    sort_index = columns.index(sort_by)
    
    filter_list = [
        arr for arr in data
        if arr[ext_index] < val_ext
    ]
    
    return sorted(filter_list, key=lambda x: x[sort_index])

print(solution([[1, 20300104, 100, 80], [2, 20300804, 847, 37], [3, 20300401, 10, 8]], "date", 20300501, "remain"))