package com.wayster.apiclientes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class Internacionalizacao {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("messages");
        reloadableResourceBundleMessageSource.setDefaultEncoding("ISO-8859-1");
        reloadableResourceBundleMessageSource.setDefaultLocale(Locale.getDefault());
        return reloadableResourceBundleMessageSource;
    }

    public LocalValidatorFactoryBean localValidatorFactoryBean(){
       LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
       factoryBean.setValidationMessageSource(messageSource());
       return factoryBean;
    }

}
