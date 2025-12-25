class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
      
        double[][] tower = new double[102][102];
        
     
        tower[0][0] = (double) poured;
        
     
        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
               
                double excess = (tower[r][c] - 1.0) / 2.0;
                
                if (excess > 0) {
                  
                    tower[r + 1][c] += excess;
        
                    tower[r + 1][c + 1] += excess;
                }
            }
        }
        
        return Math.min(1.0, tower[query_row][query_glass]);
    }
}