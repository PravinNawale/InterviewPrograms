package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PrintOddEvenUsingSemaphore {

	public static void main(String args[]) {
		SharedPrinter sp = new SharedPrinter();
	    // Starting two threads
	    ExecutorService executor = Executors.newFixedThreadPool(2);
	    executor.execute(new EvenNumProducer(sp, 10));
	    executor.execute(new OddNumProducer(sp, 10));
	    executor.shutdown();
	}
}

class SharedPrinter {
	Semaphore semEven = new Semaphore(0);
	Semaphore semOdd = new Semaphore(1);

	public void printEvenNum(int num) {
		try {
			semEven.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num);
		semOdd.release();
	}

	public void printOddNum(int num) {
		try {
			semOdd.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num);
		semEven.release();
	}
}

class EvenNumProducer implements Runnable{
    SharedPrinter sp;
    int index;
    EvenNumProducer(SharedPrinter sp, int index){
        this.sp = sp;
        this.index = index;
    }
    @Override
    public void run() {
        for(int i = 2; i <= index; i = i+2){
            sp.printEvenNum(i);
        }   
    }  
}

class OddNumProducer implements Runnable{
    SharedPrinter sp;
    int index;
    OddNumProducer(SharedPrinter sp, int index){
        this.sp = sp;
        this.index = index;
    }
    @Override
    public void run() {
        for(int i = 1; i <= index; i = i+2){
            sp.printOddNum(i);
        }
    }
} 
