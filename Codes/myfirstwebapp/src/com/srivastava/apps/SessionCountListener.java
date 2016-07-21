package com.srivastava.apps;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCountListener
 *
 */
public class SessionCountListener implements HttpSessionListener {
	private static int sessionCounter ;
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	sessionCounter++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	sessionCounter--;
    }
    
    public static int getSessionCount(){
    	return sessionCounter;
    }
	
}
