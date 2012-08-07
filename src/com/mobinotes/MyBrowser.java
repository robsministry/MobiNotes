/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes;

import java.net.URL;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
 
/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class MyBrowser extends Region{
        HBox toolbar;
 
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
         
        public MyBrowser(){
             
            final URL urlGoogleMaps = getClass().getResource("maps.html");
            webEngine.load(urlGoogleMaps.toExternalForm());
            
             
            getChildren().add(webView);
         
        }
}