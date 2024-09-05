package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(simpleExRateProvider());
    }
    @Bean
    public ExChangeRateProvider exChangeRateProvider() {
        return new WebApiExRateProvider();
    }

    @Bean
    public SimpleExRateProvider simpleExRateProvider() {
        return new SimpleExRateProvider();
    }
}
