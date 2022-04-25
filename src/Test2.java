import java.util.Arrays;

public class Test2 {
    public static int pronums;
    public static int sornums;
    public static int[][] Allocation;
    public static int[][] Need;
    public static int[] Available;
    public static int[] Maxall;
    public static int[] Request;
    public void bankmethod(int i) {
        int j;
        if(compare(Available,Request)&&compare(Need[i],Request)){
            for(j = 0;j<sornums;j++){
                Allocation[i-1][j] = Allocation[i-1][j] + Request[j];
                Need[i-1][j] =Need[i-1][j] - Request[j];
                Available[j] = Available[j] - Request[j];
            }
            if(safe()) {
                System.out.println("允许申请资源");
            }else {
                System.out.println("不允许申请资源");
                for(j = 0;j<sornums;j++){
                    Allocation[i-1][j] = Allocation[i-1][j] - Request[j];
                    Need[i-1][j] =Need[i-1][j] + Request[j];
                    Available[j] = Available[j] + Request[j];
                }
            }
        }else {
            System.out.println("请求资源超出可分配范围");
        }
    }

    public boolean safe() {
        int[] Work;
        boolean[] Finish = new boolean[pronums];
        Work = Arrays.copyOf(Available,Available.length);
        for(int i = 0;i<pronums;i++) {
            if(compare(Available,Maxall)){
                return true;
            }
            if(!Finish[i]) {
                for(int j = 0;j<Work.length;j++) {
                    if(Need[i][j]>Work[j]) {
                        break;
                    }
                    if(j==Work.length-1){
                        for (int k = 0;k<Work.length;k++){
                            Work[k] = Work[k] + Allocation[i][k];
                        }
                        Finish[i] = true;
                        i = 0;
                    }
                }
            }
        }
        for (boolean finish : Finish) {
            if (!finish) {
                return false;
            }
        }
        return true;
    }

    public static boolean compare(int[] m,int[] n) {
        for(int i = 0;i<m.length;i++){
            if(m[i] < n[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
