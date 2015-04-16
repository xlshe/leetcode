public class SurroundedRegion {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int width = board.length;
        int length = board[0].length;
        for (int x=0; x<width; x++) {
            mark(board, x, 0);
            mark(board, x, length-1);
        }
        
        for (int y=0; y<length; y++) {
            mark(board, 0, y);
            mark(board, width-1, y);
        }
        
        for (int x=0; x<width; x++) {
            for (int y=0; y<length; y++) {
                if (board[x][y] == 'O') {
                    board[x][y] = 'X';
                }
                if (board[x][y] == '#') {
                    board[x][y] = 'O';
                }
            }
        }
    }
    
    private class Pair {
        public int x;
        public int y;
        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private void mark(char[][] board, int x, int y) {
        
        LinkedList<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        
        int width = board.length;
        int length = board[0].length;
        
        while (!queue.isEmpty()) {
            Pair n = queue.poll();
            x = n.x;
            y = n.y;
            if (x < 0 || x >= width) {
                continue;
            }
        
            if (y < 0 || y >= length) {
                continue;
            }
        
            if (board[x][y] != 'O') {
                continue;
            }
        
            board[x][y] = '#';
        
            queue.offer(new Pair(x+1, y));
            queue.offer(new Pair(x-1, y));
            queue.offer(new Pair(x, y-1));
            queue.offer(new Pair(x, y+1));
        }
    }
}
