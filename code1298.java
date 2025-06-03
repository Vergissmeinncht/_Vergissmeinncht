import java.util.LinkedList;
import java.util.Queue;

public class code1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] vis = new boolean[n];
        boolean[] ownBoxs = new boolean[n];
        boolean[] ownKeys = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        for(int x:initialBoxes){
            ownBoxs[x] = true;
            if(!vis[x]&&(ownKeys[x]||status[x]==1)){
                queue.offer(x);
                ans+=candies[x];
                vis[x] = true;
            }
        }
        while(!queue.isEmpty()){
            int y = queue.poll();
            for (int x:keys[y]){
                ownKeys[x] = true;
                if(!vis[x]&&ownBoxs[x]){
                    queue.offer(x);
                    ans+=candies[x];
                    vis[x] = true;
                }
            }
            for(int x:containedBoxes[y]){
                ownBoxs[x] = true;
                if(!vis[x]&&(ownKeys[x]||status[x]==1)){
                    queue.offer(x);
                    ans+=candies[x];
                    vis[x] = true;
                }
            }

        }
        return ans;
    }
}
