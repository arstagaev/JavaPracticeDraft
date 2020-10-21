public class JetBrainsTest implements Animal {

    public static void main(String[] args) {
        int a = 0;

        long[] longNumbers = {1L,2L,3L};
        JetBrainsTest jt = new JetBrainsTest();
        String b = "abcdf";
        jt.calc();


        System.out.println(""+b.charAt(1)+ " subs = "+ b.substring(0,2));

        String s = "Wake up, Neo!";
        s = s.toUpperCase();
        s = s.trim();

        System.out.println("\"" + s + "\"");

    }

    private void calc(){
        int a = 300;
        int b = a++;
        int c = --b;
        System.out.println(b+" "+c+" heyy");
    }


    @Override
    public void roar() {

    }
}
