package SampleTestPrograms;

public class SingletonClass {
    public static void main(String args[]) {

    }
}

class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        if (INSTANCE != null) {
            //throw new Exception("Instansiaction is not possible");
        }
    }
}