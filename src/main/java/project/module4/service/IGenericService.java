package project.module4.service;

import java.util.List;

public interface IGenericService <T,E>{
    List<T> findAll(int page, int size);
    List<T> findAll();
    T findById(E id);
    int delete(E id);
}
