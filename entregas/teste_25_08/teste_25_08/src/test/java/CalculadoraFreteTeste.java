import org.example.CalculadoraFrete;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class CalculadoraFreteTeste {

    @ParameterizedTest(name = "caso {index}: peso {0}kg, expressa={1}, esperado=R$ {2}")
    @CsvSource({
            "1, false, 10.00",
            "10, false, 28.00",
            "10, true, 42.00",
            "20, true, 72.00",
            "0.01, false, 8.02"
    })
    void deveCalcularFrete(double pesoKg, boolean entregaExpressa, double esperado) {

        double resultado = CalculadoraFrete.calcular(pesoKg, entregaExpressa);

        assertEquals(esperado, resultado, 0.01);
    }

    @ParameterizedTest(name = "peso inválido: {0}kg")
    @ValueSource(doubles = {0, -1, -10})
    void deveRejeitarPesoInvalido(double pesoKg) {

        assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFrete.calcular(pesoKg, false)
        );
    }

    @ParameterizedTest(name = "mensagem para peso inválido: {0}")
    @ValueSource(doubles = {0, -1})
    void deveInformarMensagemDaExcecao(double pesoKg) {

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFrete.calcular(pesoKg, false)
        );

        assertEquals("O peso deve ser maior que zero.", excecao.getMessage());
    }
}
