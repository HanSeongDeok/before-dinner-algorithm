# [유형] 그래프 탐색 - BFS(너비 우선 탐색)를 사용한 최단 변환 과정 찾기
# [시간복잡도] 단어 개수를 n, 단어 길이를 m이라 할 때
# 각 단어마다 인접 단어(한 글자만 다른 경우)를 찾는 데 O(nm)
# 모든 단어를 방문하며 BFS를 진행하므로 전체 시간복잡도는 O(n^2 * m)

#@Day 1
from collections import deque
def solution(begin, target, words):
    if target not in words:
        return 0

    def can_change(word1, word2):
        diff = sum(a != b for a, b in zip(word1, word2))
        return diff == 1

    visited = set()
    queue = deque([(begin, 0)])
    while queue:
        current, cnt = queue.popleft()
        if current == target:
            return cnt
        for w in words:
            if w not in visited and can_change(current, w):
                visited.add(w)
                queue.append((w, cnt + 1))
    return 0

#@Day 2
from collections import deque
def solution(begin, target, words):
    result = 0
    dq = deque([[begin, result]])

    def convert_valid(word1, word2):
        return sum(w1 != w2 for w1, w2 in zip(word1, word2)) == 1

    memo = [begin]
    while dq:
        w1, result = dq.popleft()
        if w1 == target:
            return result
        for w2 in words:
            if w2 not in memo and convert_valid(w1, w2):
                dq.append([w2, result + 1])
                memo.append(w2)
    return 0




# 예시 테스트
print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))  # 4
print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log"]))  # 0
