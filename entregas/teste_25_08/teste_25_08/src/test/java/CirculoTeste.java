import org. example.Circulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {

    @Test
    void deveCriarOCirculoComRaioOValido() {
        // Arrange
        double raio = 5.0;

        // Act
        Circulo circulo = new Circulo(raio);

        // Assert
        assertNotNull(circulo);
        assertEquals(raio, circulo.getRaio());
    }

    @Test
    void deveACalcularAreaCorretamente() {
        // Arrange
        Circulo circulo = new Circulo(5.0);
        double areaEsperada = Math.PI * 25;

        // Act
        double area = circulo.calcularArea();

        // Assert
        assertEquals(areaEsperada, area, 0.0001);
    }

    @Test
    void naoDevePermitirQueRaioIgualAZero() {
        // Act e Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Circulo(0)
        );

        assertEquals("O raio deve ser maior que zero", exception.getMessage());
    }

    @Test
    void naoDevePermitirQueRaioNegativo() {
        // Act e Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Circulo(-10));

        assertEquals("O raio deve ser maior que zero", exception.getMessage());
    }
}
