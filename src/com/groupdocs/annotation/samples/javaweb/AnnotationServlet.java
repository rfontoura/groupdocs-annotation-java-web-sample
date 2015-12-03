package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.common.ICallback;
import com.groupdocs.annotation.common.Pair;
import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.config.ext.ServiceConfiguration;
import com.groupdocs.annotation.data.common.StorageType;
import com.groupdocs.annotation.data.common.StoreLogic;
import com.groupdocs.annotation.data.connector.IConnector;
import com.groupdocs.annotation.data.connector.data.JsonDataConnector;
import com.groupdocs.annotation.data.connector.data.XmlDataConnector;
import com.groupdocs.annotation.data.connector.db.MssqlDatabaseConnector;
import com.groupdocs.annotation.data.connector.db.MysqlDatabaseConnector;
import com.groupdocs.annotation.data.connector.db.PostgresqlDatabaseConnector;
import com.groupdocs.annotation.data.connector.db.SqliteDatabaseConnector;
import com.groupdocs.annotation.data.tables.interfaces.IDocument;
import com.groupdocs.annotation.data.tables.interfaces.IUser;
import com.groupdocs.annotation.enums.AccessRights;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.samples.data.connector.CustomDatabaseConnector;
import com.groupdocs.annotation.samples.data.connector.ICustomConnector;
import com.groupdocs.annotation.samples.javaweb.config.ApplicationConfig;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

/**
 * @author imy
 */
public abstract class AnnotationServlet extends HttpServlet {
    protected static final String MESSAGE_HANDLER_THROWS = "Handler throws exception: {0}";
    protected static final String DEFAULT_ENCODING = "UTF-8";
    protected static AnnotationHandler annotationHandler = null;
    protected static ApplicationConfig applicationConfig;
    protected static ServiceConfiguration serviceConfiguration;

    public static AnnotationHandler getAnnotationHandler() {
        return annotationHandler;
    }

    @Override
    public void init() throws ServletException {
        InputStream resourceStreamAux = getServletContext().getResourceAsStream("WEB-INF/application.properties");
        try {
            if (annotationHandler == null) {
                Properties properties = new Properties();
                properties.load(resourceStreamAux);
                applicationConfig = new ApplicationConfig(properties);
                serviceConfiguration = new ServiceConfiguration(applicationConfig);
//                annotationHandler = new AnnotationHandler(serviceConfiguration);

                IConnector connector = null;
                String storageType = applicationConfig.getStorageType();
                String dbServer = applicationConfig.getDbServer();
                Integer dbPort = applicationConfig.getDbPort();
                String dbName = applicationConfig.getDbName();
                String dbUsername = applicationConfig.getDbUsername();
                String dbPassword = applicationConfig.getDbPassword();
                ServiceConfiguration serviceConfiguration = new ServiceConfiguration(applicationConfig);
                String tempPath = serviceConfiguration.getTempDir();
                StoreLogic storeLogic = StoreLogic.fromValue(applicationConfig.getStoreLogic());
                String storagePath = Utils.or(applicationConfig.getStoragePath(), tempPath);

                if (storageType != null && !storageType.isEmpty()) {
                    switch (StorageType.fromValue(storageType)) {
                        case DEFAULT:
                            connector = null;
                            break;
                        case SQLITE:
                            connector = new SqliteDatabaseConnector(storagePath, "customSQLITEdatabaseStorage.db");
                            break;
                        case MYSQL:
                            connector = new MysqlDatabaseConnector(dbServer, dbPort, dbName, dbUsername, dbPassword);
                            break;
                        case MSSQL:
                            connector = new MssqlDatabaseConnector(dbServer, dbPort, dbName, dbUsername, dbPassword);
                            break;
                        case JSON:
                            connector = new JsonDataConnector(storagePath, storeLogic);
                            break;
                        case XML:
                            connector = new XmlDataConnector(storagePath, storeLogic);
                            break;
                        case POSTGRE:
                            connector = new PostgresqlDatabaseConnector(dbServer, dbPort, dbName, dbUsername, dbPassword);
                            break;
                        case CUSTOM:
                            connector = new CustomDatabaseConnector(dbServer, dbPort, dbName, dbUsername, dbPassword);
                            break;
                    }
                }
//                // Initialize constructors for create custom entities instead of embedded
                /*
                // Use custom entity
                AnnotationConstructor.setConstructor(new IConstructor<IAnnotation>() {
                    @Override
                    public IAnnotation create() {
                        return new CustomAnnotation();
                    }

                    @Override
                    public IAnnotation create(IAnnotation obj) {
                        return new CustomAnnotation();
                    }

                    @Override
                    public Class getClazz() {
                        return CustomAnnotation.class;
                    }

                    @Override
                    public String getFieldName(String defaultFieldName) {
                        // Replace original guid field name (column name in table) to custom
                        Map<String, String> customFields = new HashMap<String, String>() {{
                            // Replace GUID_DEFAULT to CUSTOM_GUID_FIELD_NAME, also use CUSTOM_GUID_FIELD_NAME for annotate entity field
                            put(IAnnotation.GUID_DEFAULT, CustomAnnotation.CUSTOM_GUID_FIELD_NAME);
                        }};
                        return customFields.containsKey(defaultFieldName) ? customFields.get(defaultFieldName) : defaultFieldName;
                    }
                });
                */
//                CollaboratorConstructor.setConstructor(...); ...

                // It need for date formatting
                Locale.setDefault(Locale.CANADA);
                //
                annotationHandler = new AnnotationHandler(serviceConfiguration, connector);
                if (connector instanceof ICustomConnector){
                    ((ICustomConnector)connector).setEnvironmentCreator(annotationHandler);
                }
                // This callback will be called for each case when collaborator should be created
                annotationHandler.setCollaboratorCallback(new ICallback<Pair<Integer, Color>, Pair<IUser, IDocument>>() {
                    @Override
                    public Pair<Integer, Color> onCallback(Pair<IUser, IDocument> param) {
                /*
                IUser user = param.one;
                IDocument document = param.two;
                */
                        // User collaborator for document will be created with returned access rights and color
                        // Default CollaboratorCallback is made similarly
                        return new Pair<Integer, Color>(AccessRights.All.value(), Color.red);
                    }
                });

//        AnnotationHandler annotationHandler = new AnnotationHandler(serviceConfiguration, connector, new CustomInputDataHandler(serviceConfiguration));

                // Will be called for each case when collaborators ask access to some event from AnnotationEvent
                // The access callback result has higher priority than AccessRights from the collaborator callback (annotationHandler.setCollaboratorCallback).
//                annotationHandler.setAccessCallback(new ICallback<Boolean, AccessCallbackData>() {
//                    @Override
//                    public Boolean onCallback(AccessCallbackData param) {
//                        AnnotationEvent annotationEvent = param.getAnnotationEvent();
//                        switch (annotationEvent) {
//                            case CreateAnnotation:
//                                // Check permissions and return true of false
//                                break;
//                            case DeleteAnnotation:
//                                // Check permissions and return true of false
//                                break;
//                            // ...
//                        }
//                        return true;
//                    }
//                });
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex);
        } finally {
            Utils.closeStreams(resourceStreamAux);
        }
    }

    protected void writeOutput(MediaType contentType, HttpServletResponse response, Object object) throws IOException {
        String json = (String) object;
        if (contentType != null && !contentType.toString().isEmpty()) {
            response.setContentType(contentType.toString());
        }
        response.getOutputStream().write(json.getBytes(DEFAULT_ENCODING));
    }

    protected void writeOutput(InputStream inputStream, HttpServletResponse response) throws IOException {
        if (inputStream == null) {
            Logger.getLogger(this.getClass()).error("inputStream is null");
        }
        IOUtils.copy(inputStream, response.getOutputStream());
        Utils.closeStreams(inputStream, response.getOutputStream());
    }

    protected void addCORSHeaders(HttpServletRequest request, HttpServletResponse response) {
        String origin = request.getHeader("origin");
        if (origin == null || "".equals(origin)) {
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "X-Requested-With,Origin,Content-Type, Accept");
    }
}
