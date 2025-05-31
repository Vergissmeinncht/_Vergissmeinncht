import java.util.ArrayList;
import java.util.List;

public class code909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n*n+1];
        vis[1] = true;
        List<Integer> q = new ArrayList<>();
        q.add(1);
        for(int step = 0;!q.isEmpty();step++){
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for (int x: tmp){
                if(x==n*n){
                    return step;
                }
                for (int y = x+1;y<=Math.min(x+6,n*n);y++){
                    int r = (y-1)/n;
                    int c = (y-1)%n;
                    if(r%2>0){
                        c = n-1-c;
                    }
                    int nxt = board[n-1-r][c];
                    if(nxt<0){
                        nxt = y;
                    }
                    if(!vis[nxt]){
                        vis[nxt] = true;
                        q.add(nxt);
                    }
                }
            }
        }
        return -1;
    }
}
