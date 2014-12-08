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

    @Override
    public IAnnotationDao getAnnotationDao() throws AnnotationException {
        return new CustomXmlAnnotationDaoImpl(environmentCreator, getDaoFactory());
    }

    @Override
    public ICollaboratorDao getCollaboratorDao() throws AnnotationException {
        return new CustomXmlCollaboratorDaoImpl(environmentCreator);
    }

    @Override
    public IDocumentDao getDocumentDao() throws AnnotationException {
        return new CustomXmlDocumentDaoImpl(environmentCreator);
    }

    @Override
    public IReplyDao getReplyDao() throws AnnotationException {
        return new CustomXmlReplyDaoImpl(environmentCreator);
    }

    @Override
    public ISessionDao getSessionDao() throws AnnotationException {
        return new CustomXmlSessionDaoImpl(environmentCreator);
    }

    @Override
    public ISystemInfoDao getSystemInfoDao() throws AnnotationException {
        return new CustomXmlSystemInfoDaoImpl(environmentCreator);
    }

    @Override
    public IUserDao getUserDao() throws AnnotationException {
        return new CustomXmlUserDaoImpl(environmentCreator);
    }

    @Override
    public void setEnvironmentCreator(IEnvironmentCreator environmentCreator) {
        this.environmentCreator = environmentCreator;
    }
}
