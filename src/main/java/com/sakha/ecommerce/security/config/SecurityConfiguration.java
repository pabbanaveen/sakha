package com.sakha.ecommerce.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sakha.ecommerce.filter.JwtFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtFilter jwtFilter;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       //set my configuration to auth object
        //type of auth
        
//        auth.inMemoryAuthentication()
//        .withUser("zandu")
//        .password("balm")
//        .roles("USER");
//        
//        auth.jdbcAuthentication().dataSource(dataSource)
//        .usersByUsernameQuery("select email_id, password"
//                + "from user where email_id = ?");
        
        auth.userDetailsService(userDetailsService);
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();   
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
//        http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
//        http.authorizeRequests().antMatchers("/").permitAll().and().formLogin();
        http.cors().disable();
        http.csrf().disable().authorizeRequests().antMatchers("/authentication", "/registeration")
        .permitAll().antMatchers(HttpMethod.OPTIONS, "/**")
        .permitAll().anyRequest().authenticated()
        .and().exceptionHandling().and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
 
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
       // TODO Auto-generated method stub
       return super.authenticationManager();
     }
    
    
    
    /*
     * chagned on 08-08-2021
     * 
     *     @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
//        http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
//        http.authorizeRequests().antMatchers("/").permitAll().and().formLogin();
        http.cors().disable();
        http.csrf().disable().authorizeRequests().antMatchers("/authentication", "/registeration")
        .permitAll().antMatchers(HttpMethod.OPTIONS, "/**")
        .permitAll().anyRequest().authenticated()
        .and().exceptionHandling().and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
 
    }
     * 
     * */
}
