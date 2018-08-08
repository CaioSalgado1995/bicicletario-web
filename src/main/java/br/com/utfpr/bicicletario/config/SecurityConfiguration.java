package br.com.utfpr.bicicletario.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		http.addFilterBefore(filter, CsrfFilter.class)
			.authorizeRequests()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
}
