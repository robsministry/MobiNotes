/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes;

/**
 *
 * @author Robert
 */
public class Config {
    static final String VIEW_DIR = "/com/mobinotes/view/";
    static final String CONTROLLER_DIR = "/com/mobinotes/controller";
    static final String PROPERTIES_FILE = "/mobinotes.properties";
    
    public static final String ACCOUNT_PANE_FILE = VIEW_DIR + "account.fxml";
    public static final String LESSON_PANE_FILE = VIEW_DIR + "lesson.fxml";
    public static final String CREATE_PANE_FILE = VIEW_DIR + "create.fxml";
    
    public static final String BUNDLES_DIR = "com/mobinotes/bundles/mobinotes";
    
    private static int counter = 0; 
    
    public static int getCounter() {
        return ++counter;
    }
    
    public static void resetCounter() {
        counter = 0;
    }
}
