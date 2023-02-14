package animal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Создать новую базу данных с помощью MySQLWorkbench.
 * Создать Gradle-проект и настроить его правильно.
 * Создать файл с настройками hibernate.cfg.xml.
 * Создать класс Animal(int age, String name, boolean tail) с методами get и set, как сущность к нашей таблице.
 * Создать с помощью hibernate новую таблицу с начальным значением.
 */

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setId(3);
        animal.setName("Mimi");
        animal.setAge(1);
        animal.setTail(true);

        setFactory(animal);

    }

    public static void setFactory(Object obj) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }
}
