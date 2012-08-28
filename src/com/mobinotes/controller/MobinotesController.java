/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.controller;

import com.mobinotes.Config;
import com.mobinotes.LocalUser;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Robert
 */
public class MobinotesController implements Initializable {

    @FXML
    private LocalUser user;
    @FXML
    private AnchorPane menu;
    @FXML
    private AnchorPane content;
    

    @FXML
    private void handleAccountAction(ActionEvent event) {
        System.out.println("You clicked User");
        loadPane(Config.ACCOUNT_PANE_FILE);
    }

    @FXML
    private void handleCreateAction(ActionEvent event) {
        System.out.println("You clicked Create");
        loadPane(Config.CREATE_PANE_FILE);
    }

    @FXML
    private void handleLessonAction(ActionEvent event) {
        System.out.println("You clicked Lesson");
        loadPane(Config.LESSON_PANE_FILE);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void loadPane(String fxmlFile) {
        Parent newPane = null;
        try {
            newPane = FXMLLoader.load(getClass().getResource(fxmlFile),
                    ResourceBundle.getBundle(Config.BUNDLES_DIR, Locale.getDefault()));

        } catch (IOException ex) {
            Logger.getLogger(MobinotesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (newPane != null) {
            content.getChildren().clear();
            content.getChildren().add(newPane);
        } else {
            System.out.println("Lesson Pane is null");
        }
    }
}
