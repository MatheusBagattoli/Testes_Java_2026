import Testes_01_09.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void calcularValorEmEstoqueDeveMultiplicarPrecoPelaQuantidade() {
        // Arrange
        Produto produto = new Produto("Monitor", 500, 5);
        // Act
        double obtido = produto.calcularValorEmEstoque();
        // Assert
        assertEquals(2500.0, obtido, 0.001);
    }

    @Test
    void temEstoqueDeveRetornarTrueQuandoQuantidadeForPositiva() {
        // Arrange
        Produto produto = new Produto("Teclado", 250, 5);
        // Act
        boolean obtido = produto.temEstoque();
        // Assert
        assertTrue(obtido);
    }

    @Test
    void temEstoqueDeveRetornarFalseQuandoQuantidadeForZero() {
        // Arrange
        Produto produto = new Produto("Mouse", 900.0, 0);

        // Act
        boolean obtido = produto.temEstoque();

        // Assert
        assertFalse(obtido);
    }

    @Test
    void precoZeroDeveLancarExcecao() {
        // Act + Assert
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> new Produto("Placa de vídeo", 0.0, 5));
        assertEquals("O preço deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void precoNegativoDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> new Produto("Placa de vídeo", -2.000, 10));

        assertEquals("O preço deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void estoqueNegativoDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> new Produto("Placa de vídeo", 2.000, -5));
        assertEquals("O estoque não pode ser negativo.", excecao.getMessage());
    }
}
