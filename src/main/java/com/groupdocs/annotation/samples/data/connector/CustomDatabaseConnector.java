package com.groupdocs.annotation.samples.data.connector;

import com.groupdocs.annotation.data.connector.db.AbstractDatabaseConnector;
import com.groupdocs.annotation.exception.AnnotationException;

/**
 * Custom connector for MySQL database.
 * GroupDocs.Annotation have embedded MySQL connector.
 * So this connector just example.
 * @author Aleksey Permyakov (09.09.2014)
 */
public class CustomDatabaseConnector extends AbstractDatabaseConnector {
    private static final String CONNECTION_STRING = "jdbc:mysql://%s:%d/%s?user=%s&password=%s";
    private static final String DEFAULT_DATABASE_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * Create database connector
     * @param dbServer   database server
     * @param dbPort     database port
     * @param dbName     database name
     * @param dbUsername database user name
     * @param dbPassword database user password
     * @throws AnnotationException the annotation exception
     */
    public CustomDatabaseConnector(String dbServer, int dbPort, String dbName, String dbUsername, String dbPassword) throws AnnotationException {
        this(DEFAULT_DATABASE_DRIVER, dbServer, dbPort, dbName, dbUsername, dbPassword);
    }

    /**
     * Create database connector
     * @param dbDriver   database driver class name
     * @param dbServer   database server
     * @param dbPort     database port
     * @param dbName     database name
     * @param dbUsername database user name
     * @param dbPassword database user password
     * @throws AnnotationException the annotation exception
     */
    public CustomDatabaseConnector(String dbDriver, String dbServer, int dbPort, String dbName, String dbUsername, String dbPassword) throws AnnotationException {
        super(dbDriver, String.format(CONNECTION_STRING, dbServer, dbPort, dbName, dbUsername, dbPassword));
    }
}
