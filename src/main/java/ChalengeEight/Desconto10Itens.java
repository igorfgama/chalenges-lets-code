package ChalengeEight;

import java.math.BigDecimal;

public class Desconto10Itens implements Desconto {

    @Override
    public BigDecimal desconto(BigDecimal valor) {
        System.out.println(valor.add(new BigDecimal("0.03")));
        return Desconto.super.desconto(valor).add(new BigDecimal("0.03"));
    }
}
