package hibernate.dao;

import com.sun.istack.NotNull;
import hibernate.model.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.jetbrains.annotations.NotNu ll;

public class EngineDAO implements DAO<Engine, Integer> {
    /**
     * Connection factory to database
     * Фабрика подключения к базе данных  */
    private final SessionFactory factory;


    public EngineDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }



    @Override
    public void create(Engine engine) {
        /**
         * создать сессию (открываем ворота для работы..)
         * сессия сама не потокобезопасная  */
        try (Session session = factory.openSession()) {
            /**
             * начать транзакцию (либо записали что-то либо нет)
             * если что-то произойдет в этот мометн - то все изменения откатятся    */
            session.beginTransaction();
            /**
             * создаем новый объект    */
            session.save(engine);
            /**
             * получаем транзакцию и делаем коммит  */
            session.getTransaction().commit();
        }
    }



    @Override
    public Engine read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(Engine.class, id);
        }
    }



    @Override
    public void update(Engine engine) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(engine);
            session.getTransaction().commit();
        }
    }



    @Override
    public void delete(Engine engine) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(engine);
            session.getTransaction().commit();
        }
    }
}
