/**
 * 
 */
package com.kensoft.test.jettywebsocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Source: https://itnext.io/writing-a-web-socket-server-with-embedded-jetty-46fe9ab1c435 
 * By: Amri Shodiq (https://itnext.io/@amrishodiq)
 * 
 * Minor amendments with credits to Amri for coming up with the article.
 * 
 * @author ken_kum
 *
 */
public class MessagingServer {
    private Server server;
    private int port;
    
    /**
	 * 
	 */
	public MessagingServer(int port) {
		 this.port = port;
	}
    
    public void setup() {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        server.addConnector(connector);
        
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);
        
        handler.addServlet(MessagingServlet.class, "/messaging");
    }
    
    public void start() throws Exception {
        server.start();
        server.dump(System.err);
        server.join();
    }
    
    public static void main(String args[]) throws Exception {
    	int port = 8080;
    	if(args != null && args.length > 0) {
    		String portStr = args[0];
    		port = Integer.parseInt(portStr);
    	}
        MessagingServer theServer = new MessagingServer(port);
        theServer.setup();
        theServer.start();
    }
}
