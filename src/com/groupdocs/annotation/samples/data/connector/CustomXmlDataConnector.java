package com.groupdocs.annotation.samples.data.connector;

import com.groupdocs.annotation.data.connector.data.AbstractDataConnector;
import com.groupdocs.annotation.data.dao.interfaces.*;
import com.groupdocs.annotation.data.environment.IEnvironmentCreator;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.data.dao.*;

/**
 * The type Custom xml data connector.
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlDataConnector extends AbstractDataConnector implements ICustomConnector {

    private IEnvironmentCreator environmentCreator;

    /**
     * Gets annotation dao.
     * @return the annotation dao
     * @throws AnnotationException the annotation exception
     */
    @Override
    public IAnnotationDao getAnnotationDao() throws AnnotationException {
        return new CustomXmlAnnotationDaoImpl(environmentCreator);
    }

    /**
     * Gets collaborator dao.
     * @return the collaborator dao
     * @throws AnnotationException the annotation exception
     */
    @Override
    public ICollaboratorDao getCollaboratorDao() throws AnnotationException {
        return new CustomXmlCollaboratorDaoImpl(environmentCreator);
    }

    /**
     * Gets document dao.
     * @return the document dao
     * @throws AnnotationException the annotation exception
     */
    @Override
    public IDocumentDao getDocumentDao() throws AnnotationException {
        return new CustomXmlDocumentDaoImpl(environmentCreator);
    }

    /**
     * Gets reply dao.
     * @return the reply dao
     * @throws AnnotationException the annotation exception
     */
    @Override
    public IReplyDao getReplyDao() throws AnnotationException {
        return new CustomXmlReplyDaoImpl(environmentCreator);
    }

    /**
     * Gets session dao.
     * @return the session dao
     * @throws AnnotationException the annotation exception
     */
    @Override
    public ISessionDao getSessionDao() throws AnnotationException {
        return new CustomXmlSessionDaoImpl(environmentCreator);
    }

    /**
     * Gets system info dao.
     * @return the system info dao
     * @throws AnnotationException the annotation exception
     */
    @Override
    public ISystemInfoDao getSystemInfoDao() throws AnnotationException {
        return new CustomXmlSystemInfoDaoImpl(environmentCreator);
    }

    /**
     * Gets user dao.
     * @return the user dao
     * @throws AnnotationException the annotation exception
     */
    @Override
    public IUserDao getUserDao() throws AnnotationException {
        return new CustomXmlUserDaoImpl(environmentCreator);
    }

    /**
     * Sets environment creator.
     * @param environmentCreator the environment creator
     */
    @Override
    public void setEnvironmentCreator(IEnvironmentCreator environmentCreator) {
        this.environmentCreator = environmentCreator;
    }
}
