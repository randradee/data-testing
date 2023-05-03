package com.randradee.datatesting.repositories;

import com.randradee.datatesting.entities.TestCase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Repository
public class TestCaseRepositoryImpl implements TestCaseRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addColumnToTable(String tableName, String columnName,
                                 String columnType) {

        String query = "ALTER TABLE `" + tableName + "` ADD COLUMN `" + columnName + "` " +
                columnType;

        entityManager.createNativeQuery(query).executeUpdate();
    }

    @Transactional
    public void removeColumnFromTable(String tableName, String columnName){

        String query = "ALTER TABLE `" + tableName + "` DROP COLUMN `" + columnName + "`";

        entityManager.createNativeQuery(query).executeUpdate();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends TestCase> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TestCase> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<TestCase> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TestCase getOne(UUID uuid) {
        return null;
    }

    @Override
    public TestCase getById(UUID uuid) {
        return null;
    }

    @Override
    public TestCase getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends TestCase> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TestCase> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TestCase> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TestCase> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TestCase> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TestCase> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TestCase, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends TestCase> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TestCase> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TestCase> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public List<TestCase> findAll() {
        return null;
    }

    @Override
    public List<TestCase> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(TestCase entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends TestCase> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TestCase> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TestCase> findAll(Pageable pageable) {
        return null;
    }
}
