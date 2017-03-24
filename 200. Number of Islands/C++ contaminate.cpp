class solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == '1') {
                    count ++;
                    contaminate(grid, i, j);
                }
            }
        }
    }
    void contaminate(vector<vector<char>>& grid, int i, int j) {
        if (i < 0|| j < 0|| i>=grid.size()||j>=grid[0].size()) return;
        if (grid[i][j] == '0'||grid[i][j] == '2') return;
        grid[i][j] = '2';
        vector<pair<int, int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (auto dir: dirs) {
            contaminate(grid, i+dir.first, j+dir.second);
        }
        /*contaminate(grid, i+1, j);
        contaminate(grid, i-1, j);
        contaminate(grid, i, j+1);
        contaminate(grid, i, j-1);*?
        /*if(i > 0 && grid[i-1][j] == '1') {
            grid[i-1][j] = '0';
            contaminate(grid, i-1, j);
        }
        if (j > 0 && grid[i][j-1] == '1') {
            grid[i][j-1] = '0';
            contaminate(grid, i, j-1);
        }
        if (i < grid.size() -1 && grid[i+1][j] == '1') {
            grid[i+1][j] = '0';
            contaminate(grid, i+1, j);
        }
        if (j < grid[0].size()-1 && grid[i][j+1] == '1') {
            grid[i][j+1] = '0';
            contaminate(grid, i, j+1);
        }*/
    }
};
