/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
public class FXMLProperties extends Properties {
    
    public void load() {
        try {
            load(getClass().getResourceAsStream(Config.PROPERTIES_FILE) );
        } catch (IOException ex) {
            Logger.getLogger(FXMLProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
