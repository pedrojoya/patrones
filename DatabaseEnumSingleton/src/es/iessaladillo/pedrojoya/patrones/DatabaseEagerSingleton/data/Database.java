package es.iessaladillo.pedrojoya.patrones.DatabaseEagerSingleton.data;

import es.iessaladillo.pedrojoya.patrones.DatabaseEagerSingleton.data.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Database {

    INSTANCE;

    private final List<Student> students;

    Database() {
        students = Arrays.asList(
                new Student("Baldomero", 17),
                new Student("Germán Ginés", 18),
                new Student("Genaro", 19));
    }

    public List<Student> queryAllStudents() {
        return new ArrayList<>(students);
    }

}
