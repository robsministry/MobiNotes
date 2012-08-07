/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.controller;

import com.mobinotes.LocalUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Robert
 */
public class AccountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label usser;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        usser.textProperty().bind(LocalUser.getInstance().usernameProperty());
        // TODO
    }    
}
