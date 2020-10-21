package InterfaceAndAbstract;


public abstract class LoginAuthm{
    public String encryptPassword(String pass){
        // Implement the same default behavior here
        // that is shared by all subclasses.
        return pass;
    }

    abstract void absmethod();

    // Each subclass needs to provide their own implementation of this only:
    public void nonAbstractmethod(){
        System.out.println("HELLLOOO");
    }

}
