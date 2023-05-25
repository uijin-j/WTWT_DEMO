package com.withtoowithtwo.demo.repository.post;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withtoowithtwo.demo.domain.Category;
import com.withtoowithtwo.demo.domain.Enum.OrderOption;
import com.withtoowithtwo.demo.domain.Post;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.withtoowithtwo.demo.domain.QCategory.*;
import static com.withtoowithtwo.demo.domain.QPost.*;
import static com.withtoowithtwo.demo.domain.QTripGroup.*;

@Repository
public class JpaPostRepository implements PostRepository {
    private EntityManager em;
    private final JPAQueryFactory query;

    public JpaPostRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public List<Post> findAllWithFilter(PostSearch postSearch) { // Query Dsl 사용
        return query.select(post)
                .from(post)
                .join(post.category, category)
                .join(post.group, tripGroup)
                .where(categoryEq(postSearch.getCategory())) // 동적 쿼리 구현!
                .orderBy(order(postSearch.getOption()))
                .limit(1000)
                .fetch();
    }

    private OrderSpecifier<?> order(OrderOption option) {
        switch (option) {
            case RECENT: return post.postDate.asc();
            case POPULAR: return post.hits.desc();
            case SOON: return tripGroup.firstDay.asc();
        }

        return post.postDate.asc();
    }

    private BooleanExpression categoryEq(Category category) {
        if (category == null) return null;
        return post.category.eq(category);
    }


    @Override
    public void flush() {}

    @Override
    public <S extends Post> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Post> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Post> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Post getOne(Long aLong) {
        return null;
    }

    @Override
    public Post getById(Long aLong) {
        return null;
    }

    @Override
    public Post getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Post> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Post> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Post> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Post> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Post> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Post> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Post, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Post> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Post> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Post> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public List<Post> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Post entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Post> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Post> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return null;
    }
}
