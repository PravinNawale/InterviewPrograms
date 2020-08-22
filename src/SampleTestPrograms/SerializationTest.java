package SampleTestPrograms;

import java.io.*;
import java.util.LinkedList;

public class SerializationTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Pravin");
        list.add("Somnath");
        Student student = new Student(101, "Pravin Nawale", list);

        try {
            FileOutputStream fos = new FileOutputStream("output.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis;
        try {
            fis = new FileInputStream("output.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student s = (Student)ois.readObject();
            ois.close();
            System.out.println("Student Object Read=" + s);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Serializable {
    private int roll;
    private String name;
    private LinkedList<String> list;

    public Student(int roll, String name, LinkedList<String> list) {
        this.roll = roll;
        this.name = name;
        this.list = list;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<String> getList() {
        return list;
    }

    public void setList(LinkedList<String> list) {
        this.list = list;
    }

    @Override
    public String toString(){
        return "Student{name="+name+",roll="+roll+",list="+list+"}";
    }
}
