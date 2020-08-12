/**
 * 
 */
package com.kensoft.test.jettywebsocket.model;

/**
 * @author ken_kum
 *
 */
public class Data {
    public static final int AUTHENTICATION_LOGIN = 1;
    
    public static final int MESSAGING_SEND = 101;
    
    public int operation;
    public User user;
    public Message message;
    public String session;
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
}