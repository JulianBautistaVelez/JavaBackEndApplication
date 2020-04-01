package com.bautista.backend.security;

import com.bautista.backend.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class WebSecurity {

//    @Configuration
//    public static class LoginConfiguration  extends WebSecurityConfigurerAdapter{
//        Environment environment;
//        BCryptPasswordEncoder bCryptPasswordEncoder;
//        UsuarioService usuarioService;
//
//        @Autowired
//        public LoginConfiguration(Environment environment,
//                           BCryptPasswordEncoder bCryptPasswordEncoder,
//                           UsuarioService usuarioService){
//            super();
//            this.environment = environment;
//            this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//            this.usuarioService = usuarioService;
//        }
//
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//
//            http.csrf().disable();
//            http.authorizeRequests()
//                    .antMatchers(HttpMethod.POST,environment.getProperty("login.endpoint")).permitAll()
//                    .antMatchers(environment.getProperty("h2.console.path")).permitAll()
//                    .and()
//                    .addFilter(getAuthenticationFilter())
//                    .antMatcher("/telas/**");
//
//            http.headers().frameOptions().disable();
//            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        }
//
//
//        private AuthenticationFilter getAuthenticationFilter() throws Exception{
//            AuthenticationFilter authenticationFilter = new AuthenticationFilter(usuarioService, environment, authenticationManager());
//            return authenticationFilter;
//        }
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(usuarioService).passwordEncoder(bCryptPasswordEncoder);
//        }
//    }
//
//    @Order(1)
//    @Configuration
//    public static class EndPointsConfiguration extends WebSecurityConfigurerAdapter{
//        Environment environment;
//        BCryptPasswordEncoder bCryptPasswordEncoder;
//        UsuarioService usuarioService;
//
//        @Autowired
//        public EndPointsConfiguration(Environment environment,
//                           BCryptPasswordEncoder bCryptPasswordEncoder,
//                           UsuarioService usuarioService){
//            super();
//            this.environment = environment;
//            this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//            this.usuarioService = usuarioService;
//        }
//
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//
//            http.csrf().disable();
//            http.authorizeRequests()
//                    .anyRequest().authenticated()
//                    .and()
//                    .addFilter(new TokenFilter(authenticationManager(), environment));
//
//            http.headers().frameOptions().disable();
//            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        }
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(usuarioService).passwordEncoder(bCryptPasswordEncoder);
//        }
//    }

    //TODO ARREGLAR, NO FUNCIONA
    @Configuration
    public static class TestConfiguration  extends WebSecurityConfigurerAdapter{
        Environment environment;
        BCryptPasswordEncoder bCryptPasswordEncoder;
        UsuarioService usuarioService;

        @Autowired
        public TestConfiguration(Environment environment,
                                  BCryptPasswordEncoder bCryptPasswordEncoder,
                                  UsuarioService usuarioService){
            super();
            this.environment = environment;
            this.bCryptPasswordEncoder = bCryptPasswordEncoder;
            this.usuarioService = usuarioService;
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.csrf().disable();
            http.authorizeRequests()
                    .antMatchers(HttpMethod.POST,environment.getProperty("login.endpoint")).permitAll()
                    .antMatchers(environment.getProperty("h2.console.path")).permitAll()
                    .and()
                    .addFilter(getAuthenticationFilter())
                    .antMatcher("/telas/**")
                    .authorizeRequests()
                    .and()
                    .addFilter(new TokenFilter(authenticationManager(), environment));

            http.headers().frameOptions().disable();
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }


        private AuthenticationFilter getAuthenticationFilter() throws Exception{
            AuthenticationFilter authenticationFilter = new AuthenticationFilter(usuarioService, environment, authenticationManager());
            return authenticationFilter;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(usuarioService).passwordEncoder(bCryptPasswordEncoder);
        }
    }

}

