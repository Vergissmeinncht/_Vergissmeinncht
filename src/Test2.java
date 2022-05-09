import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test2 {
    public static Random random = new Random(); //随机数用于生成相关数据
    public static int pronums = random.nextInt(4)+4; //随机生成进程数在4到8之间
    public static int sornums = 3;//资源数还是默认为3
    public static int[][] Allocation = new int[pronums][sornums];
    public static int[][] Need = new int[pronums][sornums];
    public static int[] Available = new int[sornums];
    public static int[] MaxallNeed = new int[sornums];
    public static int[] Request = new int[sornums];
    public static void initialize() {
        System.out.println("初始化数据");
        System.out.println("分配矩阵Allocation为:");
        for(int i = 0;i<pronums;i++) {
            for (int j = 0;j<3;j++) {
                Allocation[i][j] = random.nextInt(9);
            }
            System.out.print(Arrays.toString(Allocation[i]));
            System.out.println();
        }
        System.out.println("分配矩阵Need为:");
        for(int i = 0;i<pronums;i++) {
            for (int j = 0;j<3;j++) {
                Need[i][j] = random.nextInt(9);
                if(Need[i][j]>MaxallNeed[j]) {
                    MaxallNeed[j] = Need[i][j];
                }
            }
            System.out.print(Arrays.toString(Need[i]));
            System.out.println();
        }
        System.out.println("可分配矩阵Available为:");
        for (int i = 0;i<3;i++) {
            Available[i] = random.nextInt(9);
        }
        System.out.println(Arrays.toString(Available));
        System.out.println("所有进程中各个资源需求最高为:");
        System.out.println(Arrays.toString(MaxallNeed));
    }
    public static void bankmethod(int i) {
        int j;
        if(compare(Available,Request)&&compare(Need[i-1],Request)){
            for(j = 0;j<3;j++){ //进行资源分配
                Allocation[i-1][j] = Allocation[i-1][j] + Request[j];
                Need[i-1][j] =Need[i-1][j] - Request[j];
                Available[j] = Available[j] - Request[j];
            }
            System.out.println("资源申请后的分配矩阵Allocation为:");
            for(int k = 0;k<pronums;k++) {
                System.out.print(Arrays.toString(Allocation[k]));
                System.out.println();
            }
            System.out.println("资源申请后的分配矩阵Need为:");
            for(int k = 0;k<pronums;k++) {
                System.out.print(Arrays.toString(Need[k]));
                System.out.println();
            }
            System.out.println("资源申请后的可分配矩阵Available为:");
            System.out.println(Arrays.toString(Available));
            if(safe()) {
                System.out.println("该分配安全允许申请资源");
            }else {
                System.out.println("因为没有安全序列所以不允许申请资源");
                for(j = 0;j<sornums;j++){  //返回原有资源
                    Allocation[i-1][j] = Allocation[i-1][j] - Request[j];
                    Need[i-1][j] =Need[i-1][j] + Request[j];
                    Available[j] = Available[j] + Request[j];
                }
                System.out.println("分配矩阵Allocation为:");
                for(int k = 0;k<pronums;k++) {
                    System.out.print(Arrays.toString(Allocation[k]));
                    System.out.println();
                }
                System.out.println("分配矩阵Need为:");
                for(int k = 0;k<pronums;k++) {
                    System.out.print(Arrays.toString(Need[k]));
                    System.out.println();
                }
                System.out.println("可分配矩阵Available为:");
                System.out.println(Arrays.toString(Available));
            }
        }else {
            System.out.println("请求资源超出可分配范围或超出该程序需要的资源");
        }
    }

    public static boolean safe() {
        int[] Work;
        boolean[] Finish = new boolean[pronums];
        Work = Arrays.copyOf(Available,Available.length);
        for(int i = 0;i<pronums;i++) {
            if(compare(Available,MaxallNeed)){
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

    public static boolean compare(int[] m,int[] n) { //比较两数据大小
        for(int i = 0;i<3;i++){
            if(m[i] < n[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initialize();
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("请输入要请求的进程编号");
        n = sc.nextInt();
        System.out.println("请输入请求的资源量");
        for(int i = 0; i<sornums;i++) {
            Request[i] = sc.nextInt();
        }
        bankmethod(n);
    }
}
