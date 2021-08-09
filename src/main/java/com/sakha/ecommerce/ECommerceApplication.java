package com.sakha.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class }, scanBasePackages = {"com.sakha.ecommerce"})
//@EnableAutoConfiguration
//@EnableScheduling
//
//@ComponentScan({"com.sakha.ecommerce"})
//@EntityScan("com.sakha.ecommerce")
//@EnableJpaAuditing
//
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactory", 
//        basePackages = { "com.sakha.ecommerce" })
//
//@EnableTransactionManagement
///(scanBasePackages={
//"com.example.something", "com.example.application"})
//
//@EnableJpaRepositories
//@EntityScan
//@ComponentScan
public class ECommerceApplication {
//
//    @Primary
//    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("dataSource") DataSource dataSource) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.sctrcd.multidsdemo.foo.domain")
//                .persistenceUnit("foo")
//                .build();
//    }
//
//    @Primary
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
    
//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        return sessionFactory;
//    } 
    
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ECommerceApplication.class, args);
//		run.getBean("entityManagerFactory", EntityManagerFactory.class);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
           
            @Override
            public void addCorsMappings(CorsRegistry registery) {
                registery.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(3600);
            }
        };
    }

}
