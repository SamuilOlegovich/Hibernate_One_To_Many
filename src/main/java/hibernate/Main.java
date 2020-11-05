package hibernate;


import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import hibernate.dao.EngineDAO;
import hibernate.model.Engine;
import hibernate.model.Car;
import hibernate.dao.DAO;
import java.util.HashSet;
import java.util.Set;




public class Main {
    private static Integer idNewEngine;

    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Engine, Integer> dao = new EngineDAO(factory);
            /**
             * Раскоментируя интересующий метод помните что обращение к данным происходит по id.
             * Убедитесь что данные для методов create update и delete существуют.  */
            read(dao);
            update(dao);
            delete(dao);
            create(dao);
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }



    private static void read(DAO<Engine, Integer> engineDao) {
        final Engine result = engineDao.read(1);
        System.out.println("Read: " + result);
    }



    private static void update(DAO<Engine, Integer> engineDao) {
        final Engine result = engineDao.read(1);
        result.setCarMark("lada");
        engineDao.update(result);
        System.out.println("Updated: " + engineDao.read(1));
    }



    private static void create(DAO<Engine, Integer> carDao) {
        Engine engine = new Engine();
        engine.setCarMark("test-mark");
        engine.setPower(1000);
        engine.setName("test-name");

        Car car1 = new Car();
        car1.setMark("test-mark");
        car1.setCost(10);

        Car car2 = new Car();
        car2.setMark("test-mark");
        car2.setCost(20);

        Set<Car> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);
        engine.setCars(cars);

        carDao.create(engine);

        idNewEngine = engine.getId();
    }



    private static void delete(DAO<Engine, Integer> engineDao) {
        Engine engine = engineDao.read(idNewEngine);
        engineDao.delete(engine);
        System.out.println(engineDao.read(idNewEngine));
    }
}