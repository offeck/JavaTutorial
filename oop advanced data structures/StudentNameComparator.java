import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getFullName().compareTo(s2.getFullName());
    }
}
