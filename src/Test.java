/*public class Test {
    public static void main(String[] args) {
        n_squares(1000);
    }

    static String n_squares(int n) {
        StringBuffer s = new StringBuffer("0");
        int n_squared = n*n;
        for (int i=0; i<n_squared; i++) {
            s.append (", " + i);
        }
        return s.toString();
    }
}*/

class Task implements Runnable {
    private void do_stuff() {
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {}
    }
    public void run() {
        do_stuff();
    }

    static public void main(String[] args) {
        Thread[] task_array = {new Thread(new Task()),
                new Thread(new Task()),
                new Thread(new Task()),
                new Thread(new Task())};
        task_array[0].start();
        task_array[1].start();
        task_array[2].run();
        task_array[3].run();
        System.out.println("Done");
    }
}