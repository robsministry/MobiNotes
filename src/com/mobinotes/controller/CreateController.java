/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.controller;

import com.mobinotes.Config;
import com.mobinotes.client.EntityManager;
//import com.mobinotes.client.RecordClient;
import com.mobinotes.model.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author Robert
 */
public class CreateController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Note note;
    private ObservableList<Record> data;
    private ObservableList<String> items;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Create controller initialized");
        note = new Note();
        data = FXCollections.observableArrayList();
        data.addListener(new ListChangeListener() {
 
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Change");

                while (change.next()) {
                    if (change.wasAdded()) {
                        System.out.println("Change added");
                        System.out.println("size " + change.getAddedSubList().size());
                        Record record = (Record) change.getAddedSubList().get(0);
  
                        System.out.println(record.toJSON().toString());

//                        RecordClient rc = new RecordClient();

//                        rc.create(record.toJSON().toString());

                    }
                }

            }
        });
        note.nameProperty().bind(notename.textProperty());
//        list.getSelectionModel().selectedItemProperty().addListener(
//            new ChangeListener<String>() {
//            @Override
//                public void changed(ObservableValue<? extends String> ov, 
//                    String old_val, String new_val) {
//                    System.out.println("ov " + ov);
//                       System.out.println("new val " + new_val);
//                       System.out.println("old val " + old_val);
//            }
//        });
         items =FXCollections.observableArrayList (
    "Single", "Double", "Suite", "Family App");
        list.setItems(items);
        
    }
    
    @FXML
    TextField notename;
    
    @FXML
    TextArea first;
    
    @FXML
    TextArea second;
    
    @FXML                
    TextArea third;
            
    @FXML
    TextArea fourth;
                
    @FXML
    ListView list;
    
    @FXML
    Button addRecord;
    
    @FXML
    Button ok;
    
    @FXML
    Button clear;
    
    
    

//    @FXML
//    public void saveNote(ActionEvent event) {
//        System.out.println("Save note");
//        note.setName(nameField.getText());
//        System.out.println(nameField.getText());
//        File file = new File("/" + nameField.getText() + ".txt");
//        try {
//            write(file, note.toJSON().toString());
//            System.out.println(note.toJSON().toString());
//        } catch (IOException ex) {
//            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    
    @FXML
    private void handleCreateNoteAction(ActionEvent event) {
        
        System.out.println("You clicked Lesson");

    }
    
    @FXML
    private void handleAddRecordAction(ActionEvent event) {
        
        System.out.println("Add record.");
        Record record = new Record();
        if(first.getText() != null) {
            record.setCol_1(first.getText());
        }
        if(second.getText() != null) {
            record.setCol_2(second.getText());
        }
        if(third.getText() != null) {
            record.setCol_3(third.getText());
        }
        if(fourth.getText() != null) {
            record.setCol_4(fourth.getText());
        }
        record.setSetid(Integer.toString(Config.getCounter()));
        data.add(record);
        
//        EntityManager ec = new EntityManager(Record.class);
//        ec.count();
    }
    
        @FXML
    private void handleOkAction(ActionEvent event) {
        
        System.out.println("You clicked OK");
        if(notename.getText() == null) {
            System.out.println("Note null");
        }
        else {
            System.out.println("Note name " + notename.getText());
        }
        Config.resetCounter();
        
        saveNote();
    }
        
           @FXML
    private void handleClearNoteAction(ActionEvent event) {
        
        System.out.println("You clicked Clear");
//        EntityManager ec = new EntityManager(Note.class);
        
    } 
    
//    @FXML
//    public void createNote(ActionEvent event) {
//        System.out.println("Save note");
//        note.setName(nameField.getText());
//        System.out.println(nameField.getText());
//        File file = new File("/" + nameField.getText() + ".txt");
//        try {
//            write(file, note.toJSON().toString());
//            System.out.println(note.toJSON().toString());
//        } catch (IOException ex) {
//            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    @FXML
    public void sendNote(ActionEvent event) {
    }
    
    @FXML
    public void addNote(ActionEvent event) {
         
    }

    void write(File f, String text) throws IOException {
        try {
            // Create file 
            FileWriter fstream = new FileWriter("out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(text);
            out.flush();
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void saveNote() {
        JSONObject json = new JSONObject();
        
    }

    
}
