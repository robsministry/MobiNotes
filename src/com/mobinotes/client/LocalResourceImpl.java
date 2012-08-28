/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
public class LocalResourceImpl extends LocalResource{

    public LocalResourceImpl(String path) {
        super(path);
    }
    
    @Override
    String getCurrentCounter() {
        String counter = null;
        Properties prop = getSequenceProperties();
        if (prop.containsKey(path)) {
            counter = prop.getProperty(path);
        }

        return counter;
    }
    
    @Override
    void saveNextCounter(String nextCounter) {
        try {
            Properties prop = getSequenceProperties();
            prop.setProperty(path, nextCounter);
            prop.store(new FileOutputStream(config.getSequenceProperties()), "comment");
        } catch (IOException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    Properties getSequenceProperties() {
        Properties prop = new Properties();
        try {

            prop.load(new FileInputStream(config.getSequenceProperties()));


        } catch (FileNotFoundException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prop;
    }
     
}
