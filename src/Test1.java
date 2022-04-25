import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Chart_test extends JFrame {//动画实现类
    private List<Integer> values;// 保存接受的数据容器
    private static final int MAX_COUNT_OF_VALUES = 161;// 最多保存数据的个数
    public int[] list = Test1.list;
    // private
    public MyCanvas trendChartCanvas = new MyCanvas();

    // 框架起点坐标
    private final int FREAME_X = 50;
    private final int FREAME_Y = 50;
    private final int FREAME_WIDTH = 1000;// 横
    private final int FREAME_HEIGHT = 250;// 纵

    // 原点坐标
    private final int Origin_X = FREAME_X + 30;
    private final int Origin_Y = FREAME_Y + FREAME_HEIGHT - 30;

    // X,Y轴终点坐标
    private final int XAxis_X = FREAME_X + FREAME_WIDTH - 30;
    private final int XAxis_Y = Origin_Y;
    private final int YAxis_X = Origin_X;
    private final int YAxis_Y = FREAME_Y + 30;

    // X轴上的时间分度值（1分度=40像素）
    private final int TIME_INTERVAL = 1;
    // Y轴上值
    private final int PRESS_INTERVAL = 20;

    public Chart_test() {
        super("前端界面显示：");
        values = Collections.synchronizedList(new ArrayList<Integer>());// 防止引起线程异常
        // 创建一个随机数线程
        new Thread(() -> {
            try {
                int i = 0;
                while (list[i]!=0) {
                    i++;
                    addValue(list[i]);
                    repaint();
                    Thread.sleep(100);
                }
            } catch (InterruptedException b) {
                b.printStackTrace();
            }
        }).start();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 200, 1300, 600);
        this.add(trendChartCanvas, BorderLayout.CENTER);
        this.setVisible(true);
    }
    public void addValue(int value) {
        // 循环的使用一个接受数据的空间
        if (values.size() > MAX_COUNT_OF_VALUES) {
            values.remove(0);
        }
        values.add(value);
    }

    // 画布重绘图
    class MyCanvas extends JPanel {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;
            g.setColor(Color.BLACK);
            super.paintComponent(g);
            // 画时间片
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int w = Origin_X;// 起始点
            int length = values.size();
            for (int i = 0; i < length - 1; ++i) {
                g2D.drawLine(w, 270-values.get(i)*20,w+5, 270-values.get(i)*20);
                w+=5;
            }
            // 画坐标轴

            g2D.setStroke(new BasicStroke(Float.parseFloat("2.0F")));// 轴线粗度
            // X轴以及方向箭头
            g.drawLine(Origin_X, Origin_Y, XAxis_X, XAxis_Y);// x轴线的轴线
            g.drawLine(XAxis_X, XAxis_Y, XAxis_X - 5, XAxis_Y - 5);// 上边箭头
            g.drawLine(XAxis_X, XAxis_Y, XAxis_X + 5, XAxis_Y + 5);// 下边箭头

            // Y轴以及方向箭头
            g.drawLine(Origin_X, Origin_Y, YAxis_X, YAxis_Y);
            g.drawLine(YAxis_X, YAxis_Y, YAxis_X - 5, YAxis_Y + 5);
            g.drawLine(YAxis_X, YAxis_Y, YAxis_X + 5, YAxis_Y + 5);

            // 画X轴上的时间刻度（从坐标轴原点起，每隔TIME_INTERVAL(时间分度)像素画一时间点，到X轴终点止）
            g.setColor(Color.BLUE);
            g2D.setStroke(new BasicStroke(Float.parseFloat("1.0f")));

            // X轴刻度依次变化情况
            for (int i = Origin_X, j = 0; i < XAxis_X; i +=50, j += 10) {
                g.drawString(" " + j, i - 10, Origin_Y + 20);
            }
            g.drawString("时间", XAxis_X + 5, XAxis_Y + 5);

            // 画Y轴上画刻度（从坐标原点起，每隔10像素画一刻度值，到Y轴终点止）
            for (int i = Origin_Y, j = 0; i > YAxis_Y; i -= PRESS_INTERVAL, j += TIME_INTERVAL) {
                g.drawString(j + " ", Origin_X - 30, i +5);
            }
            g.drawString("进程id", YAxis_X - 5, YAxis_Y - 5);// 血压刻度小箭头值
        }
    }
}

public class Test1 {
    public static pcb pcb[];
    public static int[] list = new int[161];
    public static Random random = new Random();
    public static void main(String[] args) {
        System.out.println("创建线程数量：");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        pcb=new pcb[n];
        for(int i=0;i<n;i++)
        {
            pcb[i]=new pcb(i+1,"ready");
        }
        System.out.println("是否采用优先权？Yes/No");
        String s=sc.next();
        if(s.equals("Yes"))
        {
            youxianquanfa();
        }
        else
        {
            lunzhuanfa();
        }
    }
    private static void lunzhuanfa() {
        int index = 0;
        Queue<pcb>q1=new ArrayDeque<>();
        for(int i=0;i<pcb.length;i++)
        {
            int lunhzunshu= random.nextInt(1) + 20;//不能为0
            int needtime= random.nextInt(1) + 20;
            pcb[i].lunhzuanshu=lunhzunshu;
            pcb[i].needalltime=needtime;
            q1.add(pcb[i]);
        }
        while(!q1.isEmpty())
        {
            pcb team=q1.poll();
            int time=0;//占用cpu时间片树
            while(time<team.lunhzuanshu)
            {
                if(team.needalltime<=0)
                {break;}
                time++;
                team.needalltime-=1;
                team.status="running";
                list[index] = team.id;
                index++;
                printluzhuan();
                System.out.println();
            }
            if(team.needalltime<=0) {team.status="finish";}
            else
            {
                team.status="ready";
                q1.add(team);
            }
        }
        new Chart_test();
        printluzhuan();
    }
    private static void printluzhuan() {
        for(int i=0;i<pcb.length;i++)
        {
            System.out.println("threadid:"+pcb[i].id+"  "+pcb[i].status+"  needtime:"+pcb[i].needalltime+"  lunzhuan:"+pcb[i].lunhzuanshu);
        }

    }
    private static void youxianquanfa() {//优先权
        int index = 0;
        Queue<pcb>q1=new PriorityQueue<pcb>(com);
        for(int i=0;i<pcb.length;i++)
        {
            int priority= random.nextInt(1) + 20;
            int needtime= random.nextInt(1) + 20;
            pcb[i].priority=priority;
            pcb[i].needalltime=needtime;
            q1.add(pcb[i]);
        }
        while(!q1.isEmpty())
        {
            pcb team=q1.poll();
            team.needalltime-=1;
            team.priority-=3;
            list[index] = team.id;
            index++;
            team.status="running";
            printstatus();
            System.out.println();
            if(team.needalltime>0)
            {
                team.status="ready";
                q1.add(team);
            }
            else
                team.status="finish";
        }
        new Chart_test();
        printstatus();
    }
    private static void printstatus() {
        for(int i=0;i<pcb.length;i++)
        {
            System.out.println("threadid:"+pcb[i].id+"  "+pcb[i].status+"  needtime:"+pcb[i].needalltime+"  priority:"+pcb[i].priority);
        }
    }
    static Comparator<pcb> com= (o1, o2) -> o2.priority-o1.priority;

    static class pcb
    {
        int id;//进程id
        String status;//进程状态
        int priority;//优先级
        int needalltime;//需要总时间
        int lunhzuanshu;//轮转时间数
        public pcb(int id, String status) {
            this.id=id;
            this.status=status;
        }
    }
}
