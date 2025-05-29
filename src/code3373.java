import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class code3373 {
    public Map<Integer, ArrayList<Integer>> f(int[][] edges){
        int n = edges.length;
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }
        return map;
    }

    public void dfs(Map<Integer,ArrayList<Integer>> map,int x,int o,int[] tree){
        if(tree[x] != -1){
            return;
        }
        tree[x] = o;
        ArrayList<Integer> nodes = map.get(x);
        o = (o+1)%2;
        for(int y:nodes){
            dfs(map,y,o,tree);
        }
    }

    public int count(int[] nums){
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                ans+=1;
            }
        }
        return ans;
    }


    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length+1;
        int m = edges2.length+1;
        int[] tree1 = new int[n];
        int[] tree2 = new int[m];
        Arrays.fill(tree1,-1);
        Arrays.fill(tree2,-1);
        int[] ans = new int[n];
        Map<Integer,ArrayList<Integer>> map1 = f(edges1);
        Map<Integer,ArrayList<Integer>> map2 = f(edges2);
        dfs(map1,0,0,tree1);
        dfs(map2,0,0,tree2);
        int cout1 = count(tree1);
        int cout2 = count(tree2);
        cout2 = Math.max(cout2,m-cout2);
        for(int i = 0;i<n;i++){
            if(tree1[i]==0){
                ans[i] = cout1+cout2;
            }else {
                ans[i] = n-cout1+cout2;
            }
        }
        return ans;
    }
}
