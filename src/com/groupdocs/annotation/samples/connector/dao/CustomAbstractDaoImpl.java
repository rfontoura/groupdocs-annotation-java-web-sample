package com.groupdocs.annotation.samples.connector.dao;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.dao.interfaces.IDao;
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
    @Override
    public void createTableIfNotExists() throws AnnotationException {
    }

    @Override
    public T selectBy(final List<String> fieldNames, final Object... fieldValues) throws AnnotationException {
        return Utils.first(loadData(), new Utils.IFirst<T>() {
            @Override
            public boolean check(T entity) {
                String jsonUser = entity.toString();
                JsonElement jsonElement = new JsonParser().parse(jsonUser);
                List<Object> fValues = Arrays.asList(fieldValues);
                for (int n = 0; n < fieldNames.size(); n++) {
                    String fieldName = fieldNames.get(n);
                    Object fieldValue = fValues.get(n);
                    if (fieldName != null && fieldValue != null && jsonElement instanceof JsonObject) {
                        JsonElement element = ((JsonObject) jsonElement).get(fieldName);
                        if (element != null && !element.isJsonNull() && fieldValue.toString().equals(element.getAsString())) {
                            continue;
                        }
                    }
                    return false;
                }
                return true;
            }
        });
    }

    @Override
    public List<T> selectAllBy(final List<String> fieldNames, final Object... fieldValues) throws AnnotationException {
        return Utils.where(loadData(), new Utils.IWhere<T>() {
            @Override
            public boolean isToAdd(T entity) {
                String jsonUser = entity.toString();
                JsonElement jsonElement = new JsonParser().parse(jsonUser);
                List<Object> fValues = Arrays.asList(fieldValues);
                for (int n = 0; n < fieldNames.size(); n++) {
                    String fieldName = fieldNames.get(n);
                    Object fieldValue = fValues.get(n);
                    if (fieldName != null && jsonElement instanceof JsonObject && fieldValue.toString().equals(((JsonObject) jsonElement).get(fieldName).getAsString())) {
                        continue;
                    }
                    return false;
                }
                return true;
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
        String json = Utils.toXml(object);
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
}
