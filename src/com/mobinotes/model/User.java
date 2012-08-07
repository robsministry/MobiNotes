/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Robert
 */
public abstract class User {
    
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty username = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private ObservableList<String> userSets = FXCollections.observableArrayList();

    public User() {
        
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public int getId() {
        return id.get();
    }
    
    public String getUsername() {
        return username.get();
    }
    
    public void setId(int id) {
        this.id.set(id);
    }
    
    public void setUsername(String username) {
        this.username.set(username);
    }
    
    
}
