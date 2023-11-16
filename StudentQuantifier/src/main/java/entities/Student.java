package entities;

import java.util.Objects;

public class Student {

    private int studentCode;

    public Student(int studentCode) {
        this.studentCode = studentCode;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentCode == student.studentCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode);
    }
}
