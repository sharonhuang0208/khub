package com.claridy.khub.admin.core.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.claridy.khub.admin.core.persistent.PersistentObject;

@NoRepositoryBean
public interface BaseRepository<T extends PersistentObject<ID>, ID extends Serializable> extends Repository<T, ID>, QueryDslPredicateExecutor<T>{

    public abstract <S extends T> S save(S paramS);

    public abstract <S extends T> Iterable<S> save(Iterable<S> paramIterable);

    public abstract Optional<T> findOne(ID paramID);

    public abstract boolean exists(ID paramID);

    public abstract Iterable<T> findAll();

    public abstract Iterable<T> findAll(Iterable<ID> paramIterable);

    public abstract long count();

    public abstract void delete(ID paramID);

    public abstract void delete(T paramT);

    public abstract void delete(Iterable<? extends T> paramIterable);

    public abstract void deleteAll();
}
