package ChalengeEight;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Crie um programa para aplicar uma cadeia de descontos no total da compra.
 *
 * Os descontos são:
 *
 *     Se comprar 15 itens ou mais, aplicar 10% de desconto.
 *     Se comprar 10 itens e menos de 15 aplicar 8% de desconto.
 *     Se comprar 5 itens e menos de 10 aplicar 5% de desconto.
 *     Se comprar menos que 5 itens não aplicar desconto.
 *
 * Ao aplicar o desconto encerre a cadeia de verificações.
 * Deixe o código aberto para que outros tipos de descontos sejam aplicados futuramente.
 */
public class ChalengeEight {
    public void retornarProduto(){
        BigDecimal valorDesconto = BigDecimal.ZERO;
        BigDecimal valorProduto = new BigDecimal("100");

        valorProduto = valorProduto
                .divide(new Desconto15Itens().desconto(new Desconto10Itens().desconto(new Desconto5Itens().desconto(valorDesconto))),
                        2,
                        RoundingMode.HALF_DOWN);

        System.out.println(valorProduto);
    }
}
