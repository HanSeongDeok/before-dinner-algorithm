# @Day 1
def solution(files):
    part_files = {}
    for f in files:
        part = [""] * 2
        h_check = n_check = False
        for c in f:
            if not n_check and not c.isdigit():
                h_check = True
                part[0] += c.lower()
            elif h_check and c.isdigit():
                n_check = True
                part[1] += c
            else:
                break
        part_files[f] = part
    
    part_files = sorted(part_files.items(), key=lambda x : (x[1][0], int(x[1][1])))
    return list(f for f, _ in part_files)

files1 = ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
files2 = ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]

print(solution(files1))
print(solution(files2))