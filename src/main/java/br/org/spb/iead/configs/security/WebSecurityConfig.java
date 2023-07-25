package br.org.spb.iead.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    final UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/novoevento").permitAll()
                .antMatchers(HttpMethod.POST, "/novoevento").permitAll()
                .antMatchers(HttpMethod.GET, "/setores").permitAll()
                .antMatchers(HttpMethod.GET, "/eventos").hasAnyRole("ADMIN","USER","QUALIDADE")
                .antMatchers(HttpMethod.GET, "/gerenciar").hasAnyRole("ADMIN","USER","QUALIDADE")
                .antMatchers(HttpMethod.POST, "/usuariosForm").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/usuariosForm").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/usuarios").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
