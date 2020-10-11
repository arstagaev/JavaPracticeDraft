



public class JetBrainsTest {
    public static void main(String[] args) {
        int a = 0;

        long[] longNumbers = {1L,2L,3L};
        String b = "abcdf";
        calc();


        System.out.println(""+b.charAt(1)+ " subs = "+ b.substring(0,2));

    }

    static void calc(){
        int a = 300;
        int b = a++;
        int c = --b;
        System.out.println(b+" "+c+" heyy");
    }


}
