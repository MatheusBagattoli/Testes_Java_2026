package Testes_08_09;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraPedidoTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("cenariosDePedido")
    void calcularDeveAtenderCenariosValidos(String descricao, Item item, int percentualCupom, double esperado) {

        // Act: execute o cálculo.
        double obtido = CalculadoraPedido.calcularValorFinal(item, percentualCupom);

        // Assert: compare esperado e obtido usando delta.
        assertEquals(esperado, obtido, 0.001);
    }

    static Stream<Arguments> cenariosDePedido() {
        return Stream.of(
                Arguments.of("Sem desconto",
                        new Item("Mouse", 100.00, 2), 0, 200.00),
                Arguments.of("Desconto de 10%",
                        new Item("Teclado", 100.00, 2), 10, 180.00),
                Arguments.of("Desconto de 30%",
                        new Item("Monitor", 500.00, 2), 30, 700.00),
                Arguments.of("Quantidade igual a 1",
                        new Item("Cabo HDMI", 50.00, 1), 20, 40.00));
    }

    @ParameterizedTest
    @NullSource
    void itemNuloDeveLancarExcecao(Item item) {
        // Act + Assert
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> CalculadoraPedido.calcularValorFinal(item, 10));

        assertEquals("O item é obrigatório", excecao.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t"})
    void nomeAusenteDeveLancarExcecao(String nome) {

        // Act + Assert
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> new Item(nome, 100.00, 1));
        assertEquals("O nome do item é obrigatório", excecao.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 31})
    void cupomInvalidoDeveLancarExcecao(int percentualCupom) {
        // Arrange: cria um Item válido
        Item item = new Item("Produto", 100.00, 2);

        // Act + Assert
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> CalculadoraPedido.calcularValorFinal(item, percentualCupom));

        assertEquals("O percentual do cupom deve estar entre 0 e 30", excecao.getMessage());
    }
}