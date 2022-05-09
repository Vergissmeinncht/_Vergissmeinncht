public class ReverseInteger {
    public int reverse(int x) {
        int n = x;
        if(n<0) {
            x=-x;
        }
        double y = 0;
        while(x>0) {
            y = y*10 + x%10;
            x /= 10;
        }
        if(y>2147483647 || y<-2147483648) {
            return 0;
        }
        if(n<0) {
            y = -y;
        }
        return (int)y;
    }
}
