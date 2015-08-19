package com.leonovich.itcrowd.web.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * This class configure srping context in web mvc project.
 * Created by alexanderleonovich on 16.08.15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.leonovich.itcrowd")
public class WebAppConfig extends WebMvcConfigurerAdapter {

    /**
     * Resolves views selected for rendering by @Controllers to tiles resources
     * in the Apache TilesConfigurer bean
     * @return TilesViewResolver.
     */
    @Bean
    public TilesViewResolver getTilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    /**
     * Configures Apache tiles definitions bean used by Apache TilesViewResolver
     * to resolve views selected for rendering by @Controllers
     * @return TilesConfigurer.
     */
    @Bean
    public TilesConfigurer getTilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setCheckRefresh(true);
        tilesConfigurer.setDefinitionsFactoryClass(TilesConfig.class);
        // Add apache tiles definitions
        TilesConfig.addDefinitions();
        return tilesConfigurer;
    }

    /**
     * ResourceBundle for validation message.
     * @return ResourceBundleMessageSource.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("messages");
        return messageSource;
    }

    /**
     * Handler method of static resources in application
     * @param registry object of ResourceHandlerRegistry class
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assests/**").addResourceLocations("/assests/");
    }
}
