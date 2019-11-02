package com.online.estore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@EnableWebMvc
@ComponentScan
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/about.html").setViewName("about");
        registry.addViewController("/contact.html").setViewName("contact");

        registry.addViewController("/wishlist.html").setViewName("wishlist");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/shipping.html").setViewName("shipping");

        registry.addViewController("/kitchen.html").setViewName("kitchen");
        registry.addViewController("/care.html").setViewName("shipping");
        registry.addViewController("/hold.html").setViewName("hold");
        registry.addViewController("/codes.html").setViewName("codes");
        registry.addViewController("/single.html").setViewName("single");
        registry.addViewController("/offer.html").setViewName("offer");
        //registry.addViewController("/checkout.html").setViewName("checkout");
        registry.addViewController("/payment.html").setViewName("payment");

        registry.addViewController("/product.html").setViewName("product");
        registry.addViewController("/product2.html").setViewName("product2");
        registry.addViewController("/single2.html").setViewName("single2");
        registry.addViewController("/faqs.html").setViewName("faqs");
        registry.addViewController("/icons.html").setViewName("icons");
        registry.addViewController("/typography.html").setViewName("typography");



    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/fonts/**",
                "/images/**",
                "/video/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/images/",
                        "classpath:/static/css/",
                        "classpath:/static/fonts/",
                        "classpath:/static/video/",
                        "classpath:/static/js/");
    }

//    @Bean
//    public ViewResolver internalResourceViewResolver() {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/view/");
//        bean.setSuffix(".html");
//        return bean;
//    }

    @Bean
    // Only used when running in embedded servlet
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


}

