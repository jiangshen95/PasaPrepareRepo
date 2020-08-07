class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        def searchMatrix(up, down, left, right):
            if up > down or left > right:
                return False
            mid = left + (right - left) // 2
            i, j = up, down
            while i <= j:
                m = i + (j - i) // 2
                if matrix[m][mid] == target:
                    return True
                elif matrix[m][mid] < target:
                    i = m + 1
                else:
                    j = m - 1
            return searchMatrix(up, j, mid + 1, right) or searchMatrix(j + 1, down, left, mid - 1)
        if not matrix:
            return False
        return searchMatrix(0, len(matrix) - 1, 0, len(matrix[0]) - 1)

if __name__ == "__main__":
    n = int(input())
    matrix = []
    for i in range(n):
        matrix.append([int(num) for num in input().split()])
    target = int(input())
    solution = Solution()
    print(matrix)
    print(solution.searchMatrix(matrix, target))