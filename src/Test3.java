import java.util.*;

//储存管理实验代码
public class Test3 {
    public static int msize = 2;
    public static Random random = new Random();
    public static List<Integer> pages = new ArrayList<>();
    public static void procducePages() {
        int actual = 0; // 执行数
        while(actual<320) {
            int order1 = random.nextInt(320);
            order1 = order1+1;
            pages.add(changeAddressToPage(order1));
            int order2 = random.nextInt(order1);
            order2 = order2+1;
            pages.add(changeAddressToPage(order2));
            int order3 = random.nextInt(order2+1,320);
            pages.add(changeAddressToPage(order3));
            actual +=3;
        }
    }

    public static int changeAddressToPage(int address) {//将地址转换成页号
        int page = -1;
        while(address>=0) {
            address = address - 10;
            page++;
        }
        return page;
    }

    public static double FIFO() { //FIFO算法使用Queue来实现
        double missPagenum = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (Integer page : pages) {
            if (!queue.contains(page)) {
                missPagenum++;
                if (queue.size() >= msize) {
                    queue.poll();
                }
                queue.add(page);
            }
        }
        return 1-(missPagenum/pages.size());
    }

    public static double LRU() { //LRU算法使用List来实现
        double missPagenum = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer page : pages) {
            if(!list.contains(page)) {
                missPagenum++;
                if(list.size()>=msize) {
                    list.remove(0);
                }
            }else {
                list.remove(page);
            }
            list.add(page);
        }
        return 1-(missPagenum/pages.size());
    }

    public static void main(String[] args) {
        System.out.println("Start memory management.\n" +
                "Producing address flow, wait for while, please.");
        procducePages();
        System.out.println("地址页号序列为：");
        System.out.println(pages);
        System.out.println("There are algorithms in the program\n" +
                "1、 Least recently used algorithm\n" +
                "2、 First in first out algorithm\n");
        boolean k = true;
        while(k) {
            System.out.println("Select an algorithm number, please.");
            Scanner scanner = new Scanner(System.in);
            int s = scanner.nextInt();
            if(s==1) {
                System.out.println("使用LRU算法得到当容量为2k到32k的命中率如下：");
                msize = 2;
                while(msize<=32) {
                    System.out.printf("%.2f",LRU()*100);
                    System.out.print("% ");
                    msize++;
                }
            }else if(s==2) {
                System.out.println("使用FIFO算法得到当容量为2k到32k的命中率如下：");
                msize = 2;
                while(msize<=32) {
                    System.out.printf("%.2f",FIFO()*100);
                    System.out.print("% ");
                    msize++;
                }
            } else {
                System.out.println("there is not the algorithm in the program");
            }
            System.out.println();
            System.out.println("do you try again with anther algorithm(Y/N)");
            String judge = scanner.next();
            if(judge.equals("N")) {
                k = false;
            }
        }
    }
}
