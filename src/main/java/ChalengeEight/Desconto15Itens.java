package ChalengeEight;

import java.math.BigDecimal;

public class Desconto15Itens implements Desconto {

    @Override
    public BigDecimal desconto(BigDecimal valor) {
        System.out.println(valor.add(new BigDecimal("0.02")));
        return Desconto.super.desconto(valor).add(new BigDecimal("0.02"));
    }
}
