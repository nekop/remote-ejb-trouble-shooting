package sample.ejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class EjbUtility {

	public Object lookup(String jar_name, String ejb_name, String class_name) {
		
		try {
			
			Properties props = new Properties();
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			Context context = new InitialContext(props);
			
			Object bean = context.lookup("ejb:/" + jar_name + "//" + ejb_name + "!" + class_name);			
			return bean;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
		
}
