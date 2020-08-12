/**
 * 
 */
package com.kensoft.test.jettywebsocket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

import com.kensoft.test.jettywebsocket.model.User;

/**
 * @author ken_kum
 *
 */
public class MessagingAdapter extends WebSocketAdapter implements UserSession {
    private Session session;
    private User currentUser;
    
    @Override
    public void onWebSocketConnect(Session session) {
        super.onWebSocketConnect(session); 
        
        this.session = session;
    }
    @Override
    public void onWebSocketClose(int statusCode, String reason) {
    	MessagingImpl.getInstance().setOffline(currentUser.username);
        
        this.session = null;
        
        System.err.println("Close connection "+statusCode+", "+reason);
        
        super.onWebSocketClose(statusCode, reason); 
    }
    @Override
    public void onWebSocketText(String message) {
        super.onWebSocketText(message); 
        
        MessagingImpl.getInstance().receiveText(this, message);
    }
    @Override
    public void receiveText(String text) throws Exception {
        if (session != null && session.isOpen()) {
            session.getRemote().sendString(text);
        }
    }
    @Override
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    @Override
    public void disconnect(int status, String reason) {
        
        session.close(status, reason);
        disconnect(status, reason);
    }

}
