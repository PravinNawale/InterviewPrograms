package company.curity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CurityDummyProgram extends Thread{
    /*private int x = 2;
    public CurityDummyProgram() {
        x = 5;
        start();
    }

    public void makeItSo() throws Exception {
        join();
        x = x-1;
        System.out.println(x);
    }

    public void run() {
        x*=2;
    }*/
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new Runnable() {
            @Override
            public void run() {

            }
        });

        /*new CurityDummyProgram().makeItSo();*/
       /* Float pie = 3.14f;
        if(pie>3){
            System.out.println("1");
        } else {
            System.out.println("2");
        } finally {
            System.out.println("3");
        }*/

        /*System.out.println(new Runnable() {
            @Override
            public void run() {

            }
        });*/

        /*try {
            throw new Error();
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("d");*/

        /*new Thread() {
            public void run() {
                show();
            }
        }.start();*/

        /*Integer x = 400;
        Integer y = x;
        x++;
        StringBuilder stringBuilder  = new StringBuilder("123");
        StringBuilder stringBuilder1 = stringBuilder;
        stringBuilder.append("5");
        System.out.println((x ==y) + " " + (stringBuilder == stringBuilder1));*/

      /*  for(int i=0;i<=10;i++) {
            if(i>6){
                break;
            }
        }
        System.out.println(i);*/


       /* try {

        } catch (Exception e){

        } catch (ArithmeticException e){

        }*/

        /*new Bcd().process();*/

        /*try {

        } catch (Exception e) {

        } catch (NullPointerException e){

        }*/

       /* Long lg = 2000L;
        Long distanc = 1999L;
        if(true ^ false){

        }*/

       /* Object obj = new Object();
        try {
            synchronized (Thread.currentThread()) {
                obj.wait();
                obj.notify();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }*/
/*        int s = 3;
        s += 2+ ++s;*/
    }

    /*class Currency {
        private String country = "Italy";

        public String getC() {
            return  country;
        }
    }

    class Euro extends Currency {
        public String getC() {
            return  super.country;
        }
    }

    class Dinar extends Currency {
        public String getC(int x) {
            return getC();
        }

        public static void main(String[] args) {
            System.out.print(new Euro().getC() + "" + new Dinar().getC());
        }
    }


    void go() {
        Object o = new Object();
        synchronized (o) {

        }
    }*/
}

/*static class Abc {

    void process() throws  Exception{
        throw new Exception();
    }
}

class Bcd extends Abc{

    void process(){
        System.out.println("BCD");
    }
}*/

/*
public abstract class Shape {
    private int x;
    private int y;
    public abstract void dra
}*/
