package br.com.utfpr.bicicletario.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.utfpr.bicicletario.config.AppWebConfiguration;
import br.com.utfpr.bicicletario.config.JPAConfiguration;
import br.com.utfpr.bicicletario.config.SecurityConfiguration;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SecurityConfiguration.class, AppWebConfiguration.class, JPAConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setForceEncoding(true);
		encodingFilter.setEncoding("UTF-8");
		
		return new Filter[] {encodingFilter};
	}

}
