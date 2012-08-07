/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.controller;

import com.mobinotes.Config;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Robert
 */
public class LessonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleLessonOneAction(ActionEvent event) {
        System.out.println("You clicked Lesson one button");
    }
        
    @FXML
    private void handleLessonTwoAction(ActionEvent event) {
        System.out.println("You clicked Lesson two button");
    } 
}
