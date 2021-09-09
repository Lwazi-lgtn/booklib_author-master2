package com.caniksea.adp3.practical.booklib.authormodule.service;

/**
 * Instructions
 *   > Do NOT modify this file.
 *   > Your service should be implemented based on the repository.
 *
 * @param <T>
 * @param <ID>
 */
public interface IService<T, ID> {
    T create(T t);
    T update(T t);
    T read(ID id);
    void delete(ID id);
}
