/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes;

import com.mobinotes.model.User;
import java.io.File;
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

public class LocalUser extends User {
    
    
    private static LocalUser instance = new LocalUser();
  
    private LocalUser() {
        System.out.println("Local User Singleton(): Initializing Instance");
        initialize();
    }
    
    //Lazy instantiation using double locking mechanism.
    public static LocalUser getInstance() {
        
        return instance;
    }

    private void initialize() {
        System.out.println("Initialize Local User");
        FXMLProperties prop = new FXMLProperties();
        prop.load();
        String username = prop.getProperty("username");
        if (username != null) {
            setUsername(username);
        }
    }
    
}
