//package com.example.demo.Config.Sercurity;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.ui.Model;
//
//import com.example.demo.entity.Role;
//import com.example.demo.entity.User;
//import com.example.demo.service.UserService;
//
//@Configuration
////@EnableWebSecurity
//public class ConfigSercurity extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	private UserService us;
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Bean
//	public void createAdmin() {
//		if(us.findUserByUsername("admin")==null) {
//			Role r = new Role();
//			r.setName("ADMIN");
//			Set <Role> listr = new HashSet<Role>();
//			listr.add(r);
//			User u = new User();
//			u.setUsername("admin");
//			u.setPassword(passwordEncoder().encode("1"));
//			u.setRoles(listr);
//			us.save(u);
//		}
//		else return;
//	}
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService());
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {		
//		http.authorizeRequests()
//			.antMatchers("/admin/createAdmin","/register","/login","/doRegister","/css/**","**/js/**","**/images/**","/resources/**", "/static/**").permitAll()
//	        .antMatchers("/admin","/delete/**").hasAuthority("ADMIN")
//	        .antMatchers("/","/shop/**","/cart/**").hasAnyAuthority("ADMIN","USER") // admin mới xóa được sản phẩm
//	        .anyRequest().authenticated()
//	        .and()
//	        .formLogin()
//	        .loginPage("/login")
//	        .usernameParameter("username")
//	        .passwordParameter("password")
//            .defaultSuccessUrl("/dologin",true)
//            .failureUrl("/login?error=sai thong tin dang nhap").permitAll()
//	        .and()
//	        .logout().logoutSuccessUrl("/login").permitAll()
//	        .and()
//	        .exceptionHandling().accessDeniedPage("/403");
//	}
//}
