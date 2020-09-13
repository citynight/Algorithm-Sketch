package 数组.L79_单词搜索;

/**
 * @author logan
 * @date 2020/9/13 6:44 下午
 */
public class Solution {

    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    int m = 0;
    int n = 0;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word,int x,int y,int index) {
        // 最后一个字符判断
        if (word.length() - 1 == index) {
            return word.charAt(index) == board[x][y];
        }

        char c = board[x][y];
        if (c != word.charAt(index)) {
            return false;
        }
        // 特殊字符标记
        board[x][y] = '#';
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (board[nx][ny] == '#') {
                    continue;
                }
                if (dfs(board, word, nx, ny, index + 1)) {
                    return true;
                }
            }
        }
        // 恢复
        board[x][y] = c;
        return false;
    }
}
