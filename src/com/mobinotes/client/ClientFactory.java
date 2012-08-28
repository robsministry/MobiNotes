/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.client;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Robert
 */
public class ClientFactory {

    private static Map registeredClients = new HashMap();
    
    private static ClientFactory instance = new ClientFactory();

    void registerClient(String clientID, MobiNotesClient client) {
        ClientFactory.registeredClients.put(clientID, client);
        System.out.println(clientID + " set");
    }

    MobiNotesClient createClient(String clientID) {
        System.out.println("Create client");
        System.out.println("contains key? " + ClientFactory.registeredClients.containsKey("local"));
        System.out.println("registeredClients has local? " + ClientFactory.registeredClients.get("local") != null);

        return ((MobiNotesClient) ClientFactory.registeredClients.get(clientID)).createClient();
    }
    
    static ClientFactory instance() {
        return instance;
    }
}
