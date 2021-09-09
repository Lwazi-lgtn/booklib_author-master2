package com.caniksea.adp3.practical.booklib.authormodule.repository;

/**
 * Instructions
 *   > Do NOT modify this file.
 *   > Your repository should be implemented using any Java data structure of your choosing.
 *
 * @param <T>
 * @param <ID>
 */
public interface IRepository<T, ID> {
     T create(T t);
     T update(T t);
     T read(ID id);
     void delete(ID id);
}
