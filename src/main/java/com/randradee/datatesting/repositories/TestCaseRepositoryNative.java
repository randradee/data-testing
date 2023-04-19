package com.randradee.datatesting.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TestCaseRepositoryNative {
    @PersistenceContext
    EntityManager entityManager;

    public void addColumn(String tableName, String columnName,
                                        String columnType) {

        String query = "ALTER TABLE `" + tableName + "` ADD COLUMN `" + columnName + "` " +
                columnType;

        entityManager.createNativeQuery(query).executeUpdate();
    }

    public void removeColumn(String tableName, String columnName){

        String query = "ALTER TABLE `" + tableName + "` DROP COLUMN `" + columnName + "`";

        entityManager.createNativeQuery(query).executeUpdate();
    }
}
