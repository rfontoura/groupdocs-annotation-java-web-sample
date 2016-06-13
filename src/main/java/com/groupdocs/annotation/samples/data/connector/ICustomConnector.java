package com.groupdocs.annotation.samples.data.connector;

import com.groupdocs.annotation.data.connector.IConnector;
import com.groupdocs.annotation.data.environment.IEnvironmentCreator;

/**
 * Custom connector interface
 * @author Aleksey Permyakov (08.12.2014).
 */
public interface ICustomConnector extends IConnector {
    /**
     * Sets environment creator.
     * @param environmentCreator the environment creator
     */
    public void setEnvironmentCreator(IEnvironmentCreator environmentCreator);
}
