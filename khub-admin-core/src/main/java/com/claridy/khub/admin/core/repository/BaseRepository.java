package com.claridy.khub.admin.core.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.claridy.khub.admin.core.persistent.PersistentObject;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;



@NoRepositoryBean
public interface BaseRepository<T extends PersistentObject<ID>, ID extends Serializable> extends JpaRepository<T, ID>, QueryDslPredicateExecutor<T>{

    @Override
    public List<T> findAll(Predicate predicate);

    @Override
    public List<T> findAll(Predicate predicate, Sort sort);

    @Override
    public List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);

    @Override
    public List<T> findAll(OrderSpecifier<?>... orders);

}
