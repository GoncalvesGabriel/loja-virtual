package br.com.lojavirtual.config.security;

import br.com.lojavirtual.service.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationService authenticationService;

  @Autowired
  private SystemBasicAuthenticationEntryPoint authenticationEntryPoint;


  /**
   * Authentication configure
   *
   * @param auth
   * @throws Exception
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user").password("$2a$10$ouRVp.OkO9O2dmeRbVz6ieYd/XM2XSoSnvmxD1NzqQhjZlmwTtjxe").roles("USER")
//        .and().withUser("admin").password("$2a$10$ouRVp.OkO9O2dmeRbVz6ieYd/XM2XSoSnvmxD1NzqQhjZlmwTtjxe").roles("ADMIN");

    auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
  }

  /**
   * Authorization configure
   *
   * @param http
   * @throws Exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/products/*").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/users/*").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/users").permitAll()
        .antMatchers(HttpMethod.GET, "/products").permitAll()
        .antMatchers(HttpMethod.GET, "/products/*").permitAll()
        .anyRequest().authenticated()
        .and().httpBasic();
  }

  /**
   * Static access configure
   *
   * @param web
   * @throws Exception
   */
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/v2/api-docs",
        "/configuration/ui",
        "/swagger-resources/**",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**");
  }

}
