/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.jnlp.ServiceManager;
import javax.jnlp.SingleInstanceListener;
import javax.jnlp.SingleInstanceService;
import javax.jnlp.UnavailableServiceException;

/**
 *
 * @author Robert
 */
public class Main extends Application {

    public SingleInstanceService singleService;
    public SingleInstanceListener singleListener;

    static {
        try {
            Class.forName("com.mobinotes.client.MobiNotesLocalClient");
            Class.forName("com.mobinotes.client.MobiNotesRemoteClient");
            Class.forName("com.mobinotes.model.Record");
        } catch (ClassNotFoundException any) {
            any.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource(Config.VIEW_DIR + "mobinotes.fxml"),
                ResourceBundle.getBundle(Config.BUNDLES_DIR, new Locale("pl")));

        stage.setScene(new Scene(root));
        stage.show();
    }

    //<editor-fold desc="setSingleInstance(stage)">
    private void setSingleInstance(final Stage stage) {
        try {
            singleService =
                    (SingleInstanceService) ServiceManager.lookup("javax.jnlp.SingleInstanceService");
            singleListener = new SingleInstanceListener() {
                @Override
                public void newActivation(String[] params) {
                    System.out.println("TweetBrowser instance already running");
                    stage.toFront();
                }
            };
            if (singleService != null) {
                singleService.addSingleInstanceListener(singleListener);
            }
        } catch (UnavailableServiceException use) {
            singleService = null;
            System.out.println("Single instance service not loaded");
        }

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                if (singleService != null) {
                    singleService.removeSingleInstanceListener(singleListener);
                }
            }
        });
    }
}
//</editor-fold>