package com.springApp.viewResolver;

import java.util.Locale;

//import org.springframework.oxm.Marshaller;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

public class XmlViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String arg0, Locale arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*private Marshaller marshaller;
	
	public XmlViewResolver(Jaxb2Marshaller marshaller) {
		//constructor
		this.marshaller=marshaller;
	}

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		
		MarshallingView marshallingView  = new MarshallingView();
		
		marshallingView.setMarshaller(marshaller);
		
		return marshallingView;
	}
*/

}
