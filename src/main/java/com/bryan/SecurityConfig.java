package com.bryan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired private DataSource dataSource;//no la creas, spring la busca
    //la busca en application.propieties>spring.datasource

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();//encriptador passowrd
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {//autorizacion
        httpSecurity
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//cada vez que el user quiera algo necesita user y contra
                .and().csrf().disable()//crsf>ataque cuando te quitan la cookie que usas cuando no es statless
                .authorizeRequests()//que puede hacer un user
                //to lo que coincida con esto, lo permite
                .mvcMatchers("/files/").permitAll()
                .mvcMatchers("/files/{id}").permitAll()
                .mvcMatchers("/users/").permitAll()
                .mvcMatchers("/users/{id}").permitAll()
                .mvcMatchers("/animes/").permitAll()
                .mvcMatchers("/genres/").permitAll()
                .mvcMatchers("/authors/").permitAll()
                .mvcMatchers("/animes/{id}").permitAll()
                .mvcMatchers("/genres/{id}").permitAll()
                .mvcMatchers("/authors/{id}").permitAll()
                .anyRequest()//cualquier cosa que no sea lo de arriba
                .authenticated()//es solo para users autenticados
                .and()//y
                .httpBasic();//metodo de autenticaci??n que usas
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()//autentica
                .dataSource(dataSource)//cual es mi base de datos
                .usersByUsernameQuery("select username, password, enabled from usser where username = ?")
                .authoritiesByUsernameQuery("select username, role from usser where username = ?")
                //dime el user y el rol del usuario. UN string con ese rol
                .passwordEncoder(getPasswordEncoder());//crea el usuario y te dice como va a encriptar el pass
    }
}