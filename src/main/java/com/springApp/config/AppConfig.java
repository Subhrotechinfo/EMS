package com.springApp.config;

import java.beans.PropertyVetoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.springApp.entity.Employee;
import com.springApp.entity.EmployeeList;
import com.springApp.viewResolver.JsonViewResolver;
import com.springApp.viewResolver.XmlViewResolver;

//no xml
@Configuration
//MVC
@EnableWebMvc
//transaction manager
@EnableTransactionManagement
//base package
@ComponentScan("com.springApp")
//load properties file
@PropertySource({"classpath:persistence-mysql.properties"} )

//Aspect enable
@EnableAspectJAutoProxy	

public class AppConfig implements WebMvcConfigurer{

	
	//read the properties from the properties file
	@Autowired
	private Environment env;
	
	//log some data in the console
	private Logger logger =  Logger.getLogger(getClass().getName());	
	
	// view-resolver for Application
	
	@Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(2);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	@Bean
    public ViewResolver resourceBundleViewResolver() {
        
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setBasename("views");
        viewResolver.setOrder(1);
        return viewResolver;
    }
	
	//comment the resource bundleviewresolver 
	/*@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(MediaType.TEXT_HTML)
               // .parameterName("type")
                //.favorParameter(true)
                .ignoreAcceptHeader(true);
    }			
		
	@Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        
        List< ViewResolver > resolvers = new ArrayList< ViewResolver > ();
        
        resolvers.add(xmlViewResolver());
        resolvers.add(jsonViewResolver());
        //resolvers.add(jspViewResolver());
        
        resolver.setViewResolvers(resolvers);
        return resolver;
    }*/
	
	/*@Bean
	public ViewResolver xmlViewResolver() {
		// TODO Auto-generated method stub
		Jaxb2Marshaller marshaller  = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Employee.class,EmployeeList.class);
	return new XmlViewResolver(marshaller);
	}

	@Bean
	public ViewResolver jsonViewResolver() {
	return new JsonViewResolver();
	}
*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//create data source
	@Bean
	public DataSource securityDatasource() {
		
		//create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
			//set the jdbc driver class
			try {
				securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			
			//logging the connection props
			logger.info("--> Jdbc Url :  "+env.getProperty("jdbc.driver"));
			logger.info("--> Jdbc User :  "+env.getProperty("jdbc.user"));
			
			//setting database connection props
			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			securityDataSource.setUser(env.getProperty("jdbc.user"));
			securityDataSource.setPassword(env.getProperty("jdbc.password"));
			
			//setting connection pool props
			securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
			securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
			securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
			securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
			return securityDataSource;
	}
	
	//need a helper method for reading the environment property and convert to int 
		private int getIntProperty(String propName) {
			String propVal = env.getProperty(propName);
			
			//convert string to int 
			int intPropVal = Integer.parseInt(propVal);
			return intPropVal;
			
		}
	
	
		//hibernate properties
		private Properties getHibernateProperties() {

			// set hibernate properties
			Properties props = new Properties();

			props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
			props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
			
			//save/update method implemented in DAO
			//props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
			return props;				
		}

		@Bean
		public LocalSessionFactoryBean sessionFactory(){
			
			// create session factorys
			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
			
			// setting the properties
			sessionFactory.setDataSource(securityDatasource());
			//sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
			sessionFactory.setAnnotatedClasses(Employee.class);
			//array
			//sessionFactory.setAnnotatedClasses(Test.class);
			sessionFactory.setHibernateProperties(getHibernateProperties());
			
			return sessionFactory;
		}
		//setting up transaction manager to perform transaction 
		@Bean
		@Autowired
		public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
			
			// setup transaction manager based on session factory
			HibernateTransactionManager txManager = new HibernateTransactionManager();
			txManager.setSessionFactory(sessionFactory);

			return txManager;
		}
		
		//Email Settings
		
		@Bean
		public JavaMailSender getJavaMailSender() {
			
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			
			mailSender.setHost("smtp.gmail.com");
		    mailSender.setPort(587);

			
			mailSender.setUsername("doopchill@gmail.com");
			mailSender.setPassword("Test1990@");
			
			Properties props = mailSender.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.debug", "true");
			
			return mailSender;
		}

		 			
		 
}
