package weekReview1.warmups;

public class StringShift {


    public static String shiftB(String org, int toLeft, int toRight){
        int len = org.length();
        int total = (toRight - toLeft) % len;
        if (total == 0) return org;

        int middle = (total > 0) ? len-total : -total;
        return org.substring(middle).concat(org.substring(0, middle));
    }

    public static String shiftA(String org, int toLeft, int toRight){
        int len = org.length();
        int left  = toLeft  % len;
        int right = toRight % len;
        if (left == right) return org;

        String s = org.substring(left).concat(org.substring(0, left));
        return s.substring(len-right).concat(s.substring(0,len-right));
    }

    public static void main(String[] args) {
        String org = "myNameIsA";
        int left = 2211;
        int right = 2112;

        System.out.println(shiftA(org,left,right));
        System.out.println(shiftB(org,left,right));

        System.out.println(org.substring(2));
    }
}
