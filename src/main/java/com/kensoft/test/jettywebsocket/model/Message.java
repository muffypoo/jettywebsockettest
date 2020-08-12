/**
 * 
 */
package com.kensoft.test.jettywebsocket.model;

/**
 * @author ken_kum
 *
 */
public class Message {
    public String from;
    public String to;
    public String body;
    public long sent;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public long getSent() {
		return sent;
	}
	public void setSent(long sent) {
		this.sent = sent;
	}
}
