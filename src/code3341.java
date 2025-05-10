import java.util.*;
public class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] d = {0,1,0,-1,0};
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] cost = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[0][0] = 0;
        minHeap.add(new int[]{0,0,0});
        while(true){
            int[] nodes = minHeap.poll();
            int time = nodes[0];
            int x = (int) nodes[1];
            int y = (int) nodes[2];
            if(x==n-1&&y==m-1){
                return time;
            }
            if(time > cost[x][y]){
                continue;
            }
            for (int j = 0;j<4;j++){
                int x1 = x + d[j];
                int y1 = y + d[j+1];
                if (x1>=0 && x1<n && y1>=0 && y1<m){
                    int newCost = Math.max(time,moveTime[x1][y1]) + 1;
                    if(newCost<cost[x1][y1]){
                        cost[x1][y1] = newCost;
                        minHeap.add(new int[]{newCost,x1,y1});
                    }
                }
            }
        }
    }
}
