import Testes_01_09.ContaDigital;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaDigitalTest {

        @Test
        void contaRecemCriadaDeveTerSaldoZero() {
            ContaDigital conta = new ContaDigital("Matheus");

            assertEquals(0.0, conta.getSaldo(), 0.001);
        }

        @Test
        void depositarDeveAumentarSaldo() {
            // Arrange
            ContaDigital conta = new ContaDigital("Matheus");
            // Act
            conta.depositar(150.0);
            // Assert
            assertEquals(150.0, conta.getSaldo(), 0.001);
        }

        @Test
        void sacarDeveReduzirSaldo() {
            // Arrange
            ContaDigital conta = new ContaDigital("Matheus");
            conta.depositar(100.0);
            // Act
            conta.sacar(40.0);
            // Assert
            assertEquals(60.0, conta.getSaldo(), 0.001);
        }

        @Test
        void depositoZeroDeveLancarExcecaoESaldoNaoDeveMudar() {
            ContaDigital conta = new ContaDigital("Matheus");

            IllegalArgumentException excecao = assertThrows(
                    IllegalArgumentException.class, () -> conta.depositar(0.0));

            assertAll(() -> assertEquals("O deposito deve ser maior que zero", excecao.getMessage()),
                    () -> assertEquals(0.0, conta.getSaldo(), 0.001));
        }

        @Test
        void depositoNegativoDeveLancarExcecao() {
            ContaDigital conta = new ContaDigital("Matheus");

            IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                    () -> conta.depositar(-10.0));

            assertEquals("O deposito deve ser maior que zero", excecao.getMessage());
        }

        @Test
        void saqueZeroDeveLancarExcecao() {
            ContaDigital conta = new ContaDigital("Matheus");
            conta.depositar(100.0);

            IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> conta.sacar(0.0));

            assertEquals("O saque deve ser maior que zero", excecao.getMessage());
        }

        @Test
        void saqueNegativoDeveLancarExcecao() {
            ContaDigital conta = new ContaDigital("Matheus");
            conta.depositar(100.0);

            IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> conta.sacar(-10.0));

            assertEquals("O saque deve ser maior que zero", excecao.getMessage());
        }

        @Test
        void saqueMaiorQueSaldoDeveLancarExcecaoESaldoNaoDeveMudar() {
            ContaDigital conta = new ContaDigital("Matheus");
            conta.depositar(50.0);

            IllegalStateException excecao = assertThrows(IllegalStateException.class,
                    () -> conta.sacar(100.0));

            assertAll(() -> assertEquals("Saldo insuficiente", excecao.getMessage()), () -> assertEquals(50.0, conta.getSaldo(), 0.001));
        }
    }
