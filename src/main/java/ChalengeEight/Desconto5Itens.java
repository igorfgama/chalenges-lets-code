package ChalengeEight;

import java.math.BigDecimal;

public class Desconto5Itens implements Desconto {

    @Override
    public BigDecimal desconto(BigDecimal valor) {
        System.out.println(valor.add(new BigDecimal("0.05")));
        return Desconto.super.desconto(valor).add(new BigDecimal("0.05"));
    }
}
