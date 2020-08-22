package company.appnomics;

public class A implements Runnable {
    private void do_stuff() {
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {}
    }
    public void run() {
        do_stuff();
    }

    static public void main(String[] args) {
        Thread[] task_array = {new Thread(new A()),
                               new Thread(new A()),
                               new Thread(new A()),
                               new Thread(new A())};
        task_array[0].start();
        task_array[1].start();
        task_array[2].start();
        task_array[3].start();
        //System.out.println("Done");
        
        A s = new A();
        s.m2();
        System.out.println("Done");
        
        
    }
    
    public synchronized void m1() {
    }
    public synchronized void m2() {
        m1();
    }

}