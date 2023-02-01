package com.escuela.battini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
@EnableJpaAuditing
public class EscuelaBattiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaBattiniApplication.class, args);
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("escuelabattiniapp@gmail.com");
		mailSender.setPassword("czbyncaberaznaig");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}
/*Una de las alternativas para solucionar este problema es utilizar la verificación en dos pasos y generar la contraseña de la aplicación:

Cuenta de Google -> Seguridad -> Verificación en dos pasos -> Ingrese la contraseña cuando se le solicite ->
Encienda (puede usar SMS para obtener el código de Gmail para activar la Verificación en dos pasos)
Cuenta de Google -> Seguridad -> Contraseña de la aplicación -> Ingrese la contraseña según se le solicite ->
Seleccione la aplicación y el dispositivo... -> por ejemplo, Otro (nombre personalizado) ->
Ingrese el nombre de la aplicación, por ejemplo, MyApp ->
Generar Copiar una contraseña de 16 caracteres
Use una contraseña de 16 caracteres con el nombre de usuario de Gmail en su aplicación

mailSender.setUsername("sodaclaro@gmail.com");
mailSender.setPassword("nltkvcytborwdstr");
	*/


}
