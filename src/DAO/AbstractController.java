package DAO;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractController<E> {
    public abstract List<E> getAll();
    public abstract void update(E entity);
    public abstract E getEntityById(long id);
    public abstract void delete(long id);
    public abstract void create(E entity);
}
