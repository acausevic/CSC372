import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    private int rollno;
    private String name;
    private String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

class RollNoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}

public class ArrayList {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "John", "123 Main St"));
        students.add(new Student(102, "Alice", "456 Elm St"));
        students.add(new Student(103, "Bob", "789 Oak St"));

        selectionSort(students, new NameComparator());
        System.out.println("Sorted by Name:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();

        selectionSort(students, new RollNoComparator());
        System.out.println("Sorted by Roll No:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static <T> void selectionSort(List<T> list, Comparator<? super T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}
