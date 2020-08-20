package 深度优先.L529_扫雷游戏;

public class Solution {
    // 坐标相邻的8个方向 上，下，左，右，左上，左下，右上，右下
    private int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        // 获取当前坐标
        int row = click[0], col = click[1];
        // 边界条件
        int m = board.length, n = board[0].length;

        // 如果找到M（未挖出的雷）或者X（已挖出的雷）游戏结束
        if (board[row][col] == 'M' || board[row][col] == 'X') {
            board[row][col] = 'X';
            return board;
        }

        // 找周边有几个雷
        int num = 0;
        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;
            // 如果周围是未被揭开的雷，周围雷的数量递增
            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && board[newRow][newCol] == 'M') {
                num++;
            }
        }

        // 如果周围有雷
        if (num > 0) {
            board[row][col] = (char) (num + '0');
            return board;
        }

        // 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
        board[row][col] = 'B';
        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;
            // 如果周围是未被揭开的雷，周围雷的数量递增
            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && board[newRow][newCol] == 'E') {
                updateBoard(board,new int[]{newRow,newCol});
            }
        }

        return board;
    }
}
