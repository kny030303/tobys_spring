package tobyspring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExChangeRateProvider {
    BigDecimal getExrRte(String currency) throws IOException;
}
