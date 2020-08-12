/**
 * 
 */
package com.kensoft.test.jettywebsocket;

import com.kensoft.test.jettywebsocket.model.User;

/**
 * @author ken_kum
 *
 */
public interface UserSession {
    void receiveText(String text) throws Exception;
    void setCurrentUser(User user);
    void disconnect(int status, String reason);
}
