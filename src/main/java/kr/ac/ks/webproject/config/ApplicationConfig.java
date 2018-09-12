package kr.ac.ks.webproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.ac.ks.webproject.dao", "kr.ac.ks.webproject.service" })
@Import({ DBConfig.class })
public class ApplicationConfig {

}

