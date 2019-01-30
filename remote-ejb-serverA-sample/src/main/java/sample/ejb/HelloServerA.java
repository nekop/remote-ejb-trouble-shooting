package sample.ejb;

import java.util.Properties;
import javax.ejb.Stateful;
import javax.naming.Context;
import javax.naming.InitialContext;
import sample.ejb.HelloServerBRemote;

@Stateful
public class HelloServerA implements HelloServerARemote {
	
	public String helloServerA() {
		System.out.println("executed helloServerA()");
		
		try {
			
			Properties props = new Properties();
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	    
			Context context = new InitialContext(props);  
		
			HelloServerBRemote beanB = (HelloServerBRemote) context.lookup("ejb:/remote-ejb-serverB-sample//HelloServerB" + "!" + HelloServerBRemote.class.getName() + "?stateful");
			System.out.println(beanB.helloServerB());
		
			context.close();	
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return "Hello Server A.";
	}
}
