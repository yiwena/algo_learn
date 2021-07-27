package t5_recursion;

import java.util.HashMap;
import java.util.Map;

public class Demo1 {
    //台阶问题
    public static void main(String[] args) {
        System.out.println(f(3));
    }

    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return f(n - 1) + f(n - 2);
    }

    //缓存数据
    private static Map<Integer, Integer> map = new HashMap<>();
    public static int f1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = f1(n - 1) + f1(n - 2);
        map.put(n, result);
        return result;
    }

    //非递归实现
    public static int f2(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }
}
