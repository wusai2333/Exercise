class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix: return False
        i, j = 0, len(matrix[0]) - 1
        while i < len(matrix) and j >= 0:
            if matrix[i][j] < target:
                i += 1
                continue
            if matrix[i][j] > target:
                j -= 1
                continue
            if matrix[i][j] == target:
                return True
        return False