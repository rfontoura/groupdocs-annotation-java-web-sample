package com.groupdocs.annotation.samples.connector;

import com.groupdocs.annotation.connector.StorageType;
import com.groupdocs.annotation.connector.db.AbstractDatabaseConnector;
import com.groupdocs.annotation.connector.db.IDatabaseConnector;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.config.ApplicationConfig;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Custom connector for MySQL database.
 * GroupDocs.Annotation have embedded MySQL connector.
 * So this connector just example.
 *
 * @author Aleksey Permyakov (15.10.2014)
 */
public class CustomDatabaseConnector extends AbstractDatabaseConnector {
    private static final String CONNECTION_STRING = "jdbc:mysql://%s:%d/%s?user=%s&password=%s";
    private static final String DEFAULT_DATABASE_DRIVER = com.mysql.jdbc.Driver.class.getName();

    /**
     * Create database connector
     *
     * @param dbServer   database server
     * @param dbPort     database port
     * @param dbName     database name
     * @param dbUsername database user name
     * @param dbPassword database user password
     */
    public CustomDatabaseConnector(String dbServer, int dbPort, String dbName, String dbUsername, String dbPassword) throws AnnotationException {
        this(DEFAULT_DATABASE_DRIVER, dbServer, dbPort, dbName, dbUsername, dbPassword);
    }

    /**
     * Create database connector
     *
     * @param dbDriver   database driver class name
     * @param dbServer   database server
     * @param dbPort     database port
     * @param dbName     database name
     * @param dbUsername database user name
     * @param dbPassword database user password
     */
    public CustomDatabaseConnector(String dbDriver, String dbServer, int dbPort, String dbName, String dbUsername, String dbPassword) throws AnnotationException {
        super(dbDriver, String.format(CONNECTION_STRING, dbServer, dbPort, dbName, dbUsername, dbPassword));
    }
}