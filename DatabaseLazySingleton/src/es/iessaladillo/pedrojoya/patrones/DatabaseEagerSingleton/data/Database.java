package es.iessaladillo.pedrojoya.patrones.DatabaseEagerSingleton.data;

import es.iessaladillo.pedrojoya.patrones.DatabaseEagerSingleton.data.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    private static Database instance;
    private final List<Student> students;

    public static Database getInstance() {
        if (instance == null) {
            // Hacemos la comprobación thread-safe.
            // Lo hacemos aquí para que sólo sea necesario sincronizar
            // si realmente se debe crear el objeto y no si ya existe.
            synchronized(Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }

        }
        return instance;
    }

    private Database() {
        students = Arrays.asList(
                new Student("Baldomero", 17),
                new Student("Germán Ginés", 18),
                new Student("Genaro", 19));
    }

    public List<Student> queryAllStudents() {
        return new ArrayList<>(students);
    }

}
