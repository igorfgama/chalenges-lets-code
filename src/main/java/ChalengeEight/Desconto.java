package ChalengeEight;

import java.math.BigDecimal;

public interface Desconto {

    default BigDecimal desconto(BigDecimal valor) {
        System.out.println(valor);
        return valor.multiply(new BigDecimal("1"));
    }
}
