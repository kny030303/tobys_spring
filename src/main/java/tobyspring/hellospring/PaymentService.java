package tobyspring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentService {
    private final ExChangeRateProvider exRateProvider;

    public PaymentService() {
        exRateProvider = new SimpleExRateProvider(); // 의존 관계를 설정하는 코드
    }

   public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
       BigDecimal exRate = exRateProvider.getExrRte(currency);
       BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
       LocalDateTime validUtil = LocalDateTime.now().plusMinutes(30);

       return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUtil);
   }
}
