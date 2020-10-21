package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Manipulation {



    public static void main(String[] args) {
         Manipulation mp = new Manipulation();
         int array [] = {12,34,2,54,65,12,22,4,6,2};
        ArrayList arrayList = new ArrayList();

         mp.calc(array);

    }

    private void calc(int array[]) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
