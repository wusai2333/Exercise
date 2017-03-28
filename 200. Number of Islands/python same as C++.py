<<<<<<< HEAD
class Solution(object):
    def numIslands(self, grid):
        def contaminate(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[0]) and grid[i][j] == '1':
                grid[i][j] = '0'
                map(contaminate, (i-1, i+1, i, i), (j, j, j-1, j+1))
                return 1
            return 0
        return sum(contaminate(i,j) for i in range(len(grid)) for j in range(len(grid[0])))
=======
class Solution(object):
    def numIslands(self, grid):
        def contaminate(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[0]) and grid[i][j] == '1':
                grid[i][j] = '0'
                map(contaminate, (i-1, i+1, i, i), (j, j, j-1, j+1))
                return 1
            return 0
        return sum(contaminate(i,j) for i in range(len(grid)) for j in range(len(grid[0])))
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
