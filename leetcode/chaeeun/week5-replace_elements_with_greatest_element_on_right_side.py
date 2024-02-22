class Solution(object):
    def replaceElements(self, arr):
        length = len(arr)
        max_right = -1
        result = [-1] * length
        for i in range(length - 1, -1, -1):
            result[i] = max_right
            max_right = max(arr[i], max_right)
        return result

"""
class Solution(object):
    def replaceElements(self, arr):
        length = len(arr)
        result = []
        for i in range(length):
            max = -1
            for j in range(i + 1, length):
                if max < arr[j]:
                    max = arr[j]
            result.append(max)
        return result
"""
