package es.iessaladillo.pedrojoya.patrones.DatabaseEagerSingleton;

import es.iessaladillo.pedrojoya.patrones.DatabaseEagerSingleton.data.Database;
import es.iessaladillo.pedrojoya.patrones.DatabaseEagerSingleton.data.entity.Student;

import java.util.List;

class Main {

    public static void main(String[] args) {
        List<Student> students1 = Database.INSTANCE.queryAllStudents();
        List<Student> students2 = Database.INSTANCE.queryAllStudents();
        System.out.println(students1);
        System.out.println(students2);
    }

}
