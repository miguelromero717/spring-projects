package com.juego.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.juego" }, lazyInit = true)
public class AppConfig {

}
