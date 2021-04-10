package dcs.rentalApp;

import org.springframework.beans.factory.BeanFactory;

public class ObjectFactory {

//	/static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static BeanFactory factory;
	
	public static Object getObject(String name) {
		//the inheritance tree
		//parent BeanFactory (Interface) -> ApplicationContext (Interface)
		//this is downcasting factory (BeanFactory) to applicationContext(ApplicationContext)
		factory = ApplicationContextProvider.getApplicationContext();
		
		return factory.getBean(name);
	}
}
