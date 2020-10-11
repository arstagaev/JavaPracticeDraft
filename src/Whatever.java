import java.util.*;
import java.util.logging.Handler;

public class Whatever {

    public static void main(String[] args) {
        Object object = new Object();
        int hCode;
        hCode = object.hashCode();
        System.out.println(hCode);

        String n = "0";
        Class c = n.getClass();
        System.out.println(c);

        ArrayList<Integer> num = new ArrayList<>();
        num.add(11);
        num.add(22);
        num.add(33);
        int a = 5;
        for (int i=0; i<10; a=5 ){
            num.add(a);
            i++;
        }
        int[] array = {10, 2, 10, 3, 1, 2, 5};

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println(num + " ***");

        HashMap<Integer, Integer> numMap = new HashMap<>();
        numMap.put(12,20);
        numMap.put(13,20);
        numMap.put(14,20);

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(1);

        System.out.println(numMap+" | " + hashSet);

        TreeMap<String, String> PreOrder = new TreeMap<>();
        PreOrder.put("1432","23423");
        PreOrder.put("2432","23423");
        PreOrder.put("3432","23423");
        System.out.println(PreOrder.get("1432"));;
    }



}
