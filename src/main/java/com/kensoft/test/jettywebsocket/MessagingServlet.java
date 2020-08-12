/**
 * 
 */
package com.kensoft.test.jettywebsocket;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * @author ken_kum
 *
 */
public class MessagingServlet extends WebSocketServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4668195641553968812L;

	@Override
    public void configure(WebSocketServletFactory factory) {
        factory.register(MessagingAdapter.class);
    }
}
