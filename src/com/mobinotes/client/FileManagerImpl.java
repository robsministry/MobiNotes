/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
public class FileManagerImpl implements FileManager{

    public FileManagerImpl() {
    }

    @Override
    public boolean save(String json, String file_url) {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fos = new FileOutputStream(file_url);
            osw = new OutputStreamWriter(fos, "UTF8");
            PrintWriter pw = new PrintWriter(osw);
            pw.print(json);
            pw.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } //        FileOutputStream fos = null;
        //        ObjectOutputStream oos = null;
        //        try {
        //            fos = new FileOutputStream(file_url);
        //            oos = new ObjectOutputStream(fos);
        //            oos.writeUTF(json);
        //            oos.flush();
        //        } catch (FileNotFoundException ex) {
        //            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        //        } catch (IOException ex) {
        //            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        //        } finally {
        //            try {
        //                fos.close();
        //                oos.close();
        //            } catch (IOException ex) {
        //                Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        //            }
        //        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
                osw.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(file_url);
//            oos = new ObjectOutputStream(fos);
//            oos.writeUTF(json);
//            oos.flush();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                fos.close();
//                oos.close();
//            } catch (IOException ex) {
//                Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    @Override
    public String load(String file_url) {
        StringBuilder sb = new StringBuilder();
        try {

            /*  Sets up a file reader to read the file passed on the command
             line one character at a time */
            FileReader input = new FileReader(file_url);

            /* Filter FileReader through a Buffered read to read a line at a
             time */
            BufferedReader bufRead = new BufferedReader(input);

            String line;    // String that holds current file line

            // Read first line
            line = bufRead.readLine();

            // Read through file one line at time. Print line # and line
            while (line != null) {
                System.out.println(line);
                sb.append(line);
                line = bufRead.readLine();

            }

            bufRead.close();

        } catch (ArrayIndexOutOfBoundsException e) {
            /* If no file was passed on the command line, this expception is
             generated. A message indicating how to the class should be
             called is displayed */
            System.out.println("Usage: java ReadFile filename\n");

        } catch (IOException e) {
            // If another exception is generated, print a stack trace
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public boolean delete(String file_url) {

        // A File object to represent the filename
        File file = new File(file_url);

        // Make sure the file or directory exists and isn't write protected
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    "Delete: no such file or directory: " + file_url);
        }

        if (!file.canWrite()) {
            throw new IllegalArgumentException("Delete: write protected: "
                    + file_url);
        }

        // If it is a directory, make sure it is empty
//    if (file.isDirectory()) {
//      String[] files = file.list();
//      if (files.length > 0) {
//            throw new IllegalArgumentException(
//                "Delete: directory not empty: " + file_url);
//        }
//    }

        // Attempt to delete it
        boolean success = file.delete();
       
        

        if (!success) {
            throw new IllegalArgumentException("Delete: deletion failed");
        }
        return success;
    }

    @Override
    public String[] loadAll(String file_dir) {
        File dir = new File(file_dir);
        
        if(dir.isDirectory()) {
            return dir.list();
        } else {
            System.out.println("Not such directory");
            return null;          
        }     
    }
    
    @Override
    public String[] loadRange(String file_dir, final String from, final String to) {
        File dir = new File(file_dir);
        FilenameFilter filter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                
                int n = Integer.valueOf(name);
                int f = Integer.valueOf(from);
                int t = Integer.valueOf(to);

                boolean result = (n <= t) && (n >= f);
                        
                return result;
            }
        };
        
        if(dir.isDirectory()) {
            String[] l = dir.list(filter);
            System.out.println(l.length);
            return dir.list(filter);
        } else {
            System.out.println("Not such directory");
            return null;       
        }      
    }

    @Override
    public boolean edit(String newJson, String file_url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String count(String file_dir) {
        File dir = new File(file_dir);
        
        if(dir.isDirectory()) {
            int size = dir.list().length;
            return Integer.toString(size);
        } else {
            System.out.println("Not such directory");
            return null;          
        } 
    }

}
