from collections import deque
def solution(numbers, target):
    answer = 0
    def numbers_dfs(index, sum):
        nonlocal answer
        if (index == len(numbers)):
            if sum == target:
                answer += 1
            return
        
        numbers_dfs(index + 1, sum + numbers[index])
        numbers_dfs(index + 1, sum - numbers[index])
        
    numbers_dfs(0, 0)
    return answer

print(solution([1, 1, 1, 1, 1], 3))
    
def bfs(graph, start):
    visited = set()
    queue = deque([start])
    
    while queue:
        node = queue.popleft()
        if node not in visited:
            print(node, end=" ")
            visited.add(node)
            queue.extend(graph[node])

# 그래프 인접 리스트
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': [],
    'F': []
}

bfs(graph, 'A')  # 출력: A B C D E F

def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()
    
    print(start, end=" ")  # 방문 처리
    visited.add(start)
    
    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)

# 그래프 인접 리스트
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': [],
    'F': []
}

dfs(graph, 'A')  # 출력: A B D E C F

def solution(numbers, target):
    answer = 0
    def calulate_dfs(index, value):
        nonlocal answer
        if len(numbers) == index:
            if target == value:
                answer += 1
            return
        
        calulate_dfs(index + 1, value + numbers[index])
        calulate_dfs(index + 1, value - numbers[index])
    calulate_dfs(0, 0)
    return answer

print(solution([1, 1, 1, 1, 1], 3))