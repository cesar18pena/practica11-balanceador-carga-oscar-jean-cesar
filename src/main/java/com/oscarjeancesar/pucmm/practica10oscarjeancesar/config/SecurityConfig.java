package com.oscarjeancesar.pucmm.practica10oscarjeancesar.config;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.UsuarioServices;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Configuación para la validación del acceso modo JDBC
//    private DataSource dataSource;
//    @Value("${query.user-jdbc}")
//    private String queryUsuario;
//    @Value("${query.rol-jdbc}")
//    private String queryRol;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Clase para encriptar contraseña
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        //Cargando los usuarios en memoria.
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("1234")
                .roles("ADMIN","USER")
                .and()
                .withUser("usuario")
                .password("1234")
                .roles("USER")
                .and()
                .withUser("vendedor")
                .password("1234")
                .roles("VENDEDOR");


        //Configuración para acceso vía JDBC
       /* auth.jdbcAuthentication()
                .usersByUsernameQuery(queryUsuario)
                .authoritiesByUsernameQuery(queryRol)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);*/

        //Configuración JPA.
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    /*
     * Permite configurar las reglas de seguridad.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Marcando las reglas para permitir unicamente los usuarios
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**").permitAll() //permitiendo llamadas a esas urls.
                .antMatchers("/dbconsole/**").permitAll()
                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                //.anyRequest().authenticated() //cualquier llamada debe ser validada
                .and()
                .formLogin()
                .loginPage("/login") //indicando la ruta que estaremos utilizando.
                .failureUrl("/login?error") //en caso de fallar puedo indicar otra pagina.
                .permitAll()
                .and()
                .logout()
                .permitAll();

        //deshabilitando las seguridad contra los frame internos.
        //Necesario para H2.
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
