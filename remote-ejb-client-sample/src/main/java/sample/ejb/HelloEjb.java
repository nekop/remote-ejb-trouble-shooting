package sample.ejb;

import java.util.Properties;

import javax.ejb.Stateful;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.wildfly.naming.client.WildFlyInitialContextFactory;

@Stateful
public class HelloEjb {
	public void hello() {

		try {
			
			Properties props = new Properties();
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		    
	        Context context = new InitialContext(props);  
			
			HelloServerARemote beanA = (HelloServerARemote) context.lookup("ejb:/remote-ejb-serverA-sample//HelloServerA" + "!" + HelloServerARemote.class.getName() + "?stateful");
			System.out.println(beanA.helloServerA());
			
			context.close();		
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
    
}
