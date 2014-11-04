package com.groupdocs.annotation.samples.connector;

import com.groupdocs.annotation.data.connector.data.AbstractDataConnector;
import com.groupdocs.annotation.data.dao.interfaces.*;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.connector.dao.*;

/**
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlDataConnector extends AbstractDataConnector {
    @Override
    public IAnnotationDao getAnnotationDao() throws AnnotationException {
        return new CustomXmlAnnotationDaoImpl();
    }

    @Override
    public ICollaboratorDao getCollaboratorDao() throws AnnotationException {
        return new CustomXmlCollaboratorDaoImpl();
    }

    @Override
    public IDocumentDao getDocumentDao() throws AnnotationException {
        return new CustomXmlDocumentDaoImpl();
    }

    @Override
    public IReplyDao getReplyDao() throws AnnotationException {
        return new CustomXmlReplyDaoImpl();
    }

    @Override
    public ISessionDao getSessionDao() throws AnnotationException {
        return new CustomXmlSessionDaoImpl();
    }

    @Override
    public ISystemInfoDao getSystemInfoDao() throws AnnotationException {
        return new CustomXmlSystemInfoDaoImpl();
    }

    @Override
    public IUserDao getUserDao() throws AnnotationException {
        return new CustomXmlUserDaoImpl();
    }
}
