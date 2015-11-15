import java.util.*;

public class FirstBadVersion {
    
    private static int firstBadVersion = 1702766719;

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    private static boolean isBadVersion(int n) {
        if (n >= firstBadVersion) {
            return true;
        }
        return false;
    }

    public static int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }
    
    private static int firstBadVersion(int from, int to) {
	while(from < to) {
            int mid = from + ((to - from) >> 1);
            if (isBadVersion(mid)) {
                to = mid;
            } else {
                from = mid + 1;
            }
        }
        return from;
    }
}
