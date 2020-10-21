package InterfaceAndAbstract;

public class DBMySQL extends LoginAuthm implements LoginAuth{



    public static void main(String[] args) {
         DBMySQL db = new DBMySQL();
         db.checkDBforUser();
         db.absmethod();

    }

    @Override
    public String encryptPassword(String pass) {
        return null;
    }

    @Override
    void absmethod() {
        nonAbstractmethod();
    }


    @Override
    public void checkDBforUser() {
        System.out.println("from interface !!!");
    }

    @Override
    public void Asd() {

    }


    // Needs to implement both methods
}
