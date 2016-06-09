package com.groupdocs.annotation.samples.data.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.constructor.*;
import com.groupdocs.annotation.data.dao.interfaces.IDao;
import com.groupdocs.annotation.data.environment.Environment;
import com.groupdocs.annotation.data.environment.IEnvironmentCreator;
import com.groupdocs.annotation.data.tables.interfaces.ITable;
import com.groupdocs.annotation.exception.AnnotationException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Aleksey Permyakov (13.10.2014)
 */
public abstract class CustomAbstractDaoImpl<T extends ITable> implements IDao<T> {
    private final IEnvironmentCreator environmentCreator;

    public CustomAbstractDaoImpl(IEnvironmentCreator environmentCreator) {
        this.environmentCreator = environmentCreator;
    }

    /**
     * Convert object to XML
     * @param obj object to convert
     * @return xml string
     */
    public static String toXml(Object obj) {
        return initializeXStreamWithModels(new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.StaxDriver())).toXML(obj);
    }

    /**
     * Initialize {@link com.thoughtworks.xstream.XStream} with models objects
     * @param xStream xstream object
     * @return initialized {@link com.thoughtworks.xstream.XStream} object
     */
    public static com.thoughtworks.xstream.XStream initializeXStreamWithModels(com.thoughtworks.xstream.XStream xStream) {
        // Initialize xstream
        xStream.processAnnotations(AnnotationConstructor.getClazz());
        xStream.processAnnotations(CollaboratorConstructor.getClazz());
        xStream.processAnnotations(DocumentConstructor.getClazz());
        xStream.processAnnotations(ReplyConstructor.getClazz());
        xStream.processAnnotations(SessionConstructor.getClazz());
        xStream.processAnnotations(SystemInfoConstructor.getClazz());
        xStream.processAnnotations(UserConstructor.getClazz());
        return xStream;
    }

    /**
     * Restore Java object from xml
     * @param xmlString xml string
     * @param <T> type of java object
     * @return restored object
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromXml(String xmlString) {
        return (T) initializeXStreamWithModels(new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.StaxDriver())).fromXML(xmlString);
    }

    @Override
    public void createTableIfNotExists() throws AnnotationException {
    }

    @Override
    public T selectBy(final List<String> fieldNames, final Object... fieldValues) throws AnnotationException {
        return Utils.first(loadData(), new Utils.IFirst<T>() {
            @Override
            public boolean check(T entity) {
                String jsonUser = entity.toString();
                ObjectMapper mapper = new ObjectMapper();
                try {
                    JsonNode jsonNode = mapper.readTree(jsonUser);
                    List<Object> fValues = Arrays.asList(fieldValues);
                    for (int n = 0; n < fieldNames.size(); n++) {
                        String fieldName = fieldNames.get(n);
                        Object fieldValue = fValues.get(n);
                        if (fieldName != null && fieldValue != null) {
                            JsonNode element = jsonNode.get(fieldName);
                            if (element != null && !element.isNull() && fieldValue.toString().equals(element.asText())) {
                                continue;
                            }
                        }
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace(); // TODO:
                    return false;
                }
            }
        });
    }

    @Override
    public List<T> selectAllBy(final List<String> fieldNames, final Object... fieldValues) throws AnnotationException {
        return Utils.where(loadData(), new Utils.IWhere<T>() {
            @Override
            public boolean isToAdd(T entity) {
                String jsonUser = entity.toString();
                ObjectMapper mapper = new ObjectMapper();
                try {
                    JsonNode jsonNode = mapper.readTree(jsonUser);
                    List<Object> fValues = Arrays.asList(fieldValues);
                    for (int n = 0; n < fieldNames.size(); n++) {
                        String fieldName = fieldNames.get(n);
                        Object fieldValue = fValues.get(n);
                        if (fieldName != null && fieldValue.toString().equals(jsonNode.get(fieldName).asText())) {
                            continue;
                        }
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace(); // TODO:
                    return false;
                }
            }
        });
    }

    @Override
    public int insert(T entity) {
        try {
            List<T> data = loadData();
            entity.setId(Utils.makeUniqueId());
            data.add(entity);
            saveData(data);
            return 1;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't insert entity" + e.getMessage());
            return 0;
        }
    }

    @Override
    public int update(final T entity) {
        try {
            List<T> data = loadData();
            T first = Utils.first(data, new Utils.IFirst<T>() {
                @Override
                public boolean check(T value) {
                    return value.getId() == entity.getId();
                }
            });
            data.remove(first);
            data.add(entity);
            saveData(data);
            return 1;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't update entity" + e.getMessage());
            return 0;
        }
    }

    @Override
    public int delete(final T entity) {
        try {
            List<T> data = loadData();
            T first = Utils.first(data, new Utils.IFirst<T>() {
                @Override
                public boolean check(T value) {
                    return entity.getId() == value.getId();
                }
            });
            data.remove(first);
            saveData(data);
            return 1;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't delete entity" + e.getMessage());
            return 0;
        }
    }

    protected boolean saveObjectAsXml(Object object, OutputStream outputStream) {
        String json = toXml(object);
        try {
            outputStream.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    protected abstract void saveData(List<T> data);

    protected abstract List<T> loadData();

    /**
     * Get environment.
     * @return the environment
     */
    protected Environment getEnvironment() {
        return environmentCreator.createEnvironment();
    }
}
