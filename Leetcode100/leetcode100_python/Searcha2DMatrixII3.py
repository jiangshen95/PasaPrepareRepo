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

            i, j = up, down
            while i <= j:
                m = i + (j - i) // 2
                if matrix[m][left] == target:
                    return True
                elif matrix[m][left] < target:
                    i = m + 1
                else:
                    j = m - 1
            row = j

            i, j = left, right
            while i <= j:
                m = i + (j - i) // 2
                if matrix[row][m] == target:
                    return True
                elif matrix[row][m] < target:
                    i = m + 1
                else:
                    j = m - 1
            col = j

            return searchMatrix(up, row, col + 1, right)
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