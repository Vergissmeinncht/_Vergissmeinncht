import java.util.*;
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[] d = new int[]{0,1,0,-1,0};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dis = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[0][0] = 0;
        pq.add(new int[]{0,0,0});
        while(true){
            int[] nodes = pq.poll();
            int t = nodes[0];
            int x = nodes[1];
            int y = nodes[2];
            if(x==n-1&&y==m-1){
                return t;
            }
            if(t>dis[x][y]){
                continue;
            }
            int time = (x+y)%2+1;
            for(int i = 0; i < 4; i++){
                int x1 = x+d[i];
                int y1 = y+d[i+1];
                if(x1>=0&&x1<n&&y1>=0&&y1<m){
                    int c = Math.max(t,moveTime[x1][y1])+time;
                    if(c<dis[x1][y1]){
                        dis[x1][y1] = c;
                        pq.add(new int[]{c,x1,y1});
                    }
                }
            }
        }
    }
}