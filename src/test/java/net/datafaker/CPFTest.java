package net.datafaker;

import net.datafaker.shared.CPFUtils;
import org.junit.Before;
import org.junit.Test;

import static net.datafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/*
 * CPF is the Brazilian individual taxpayer registry identification and commonly used in some applications that
 * requires a register
 * @see https://en.wikipedia.org/wiki/Cadastro_de_Pessoas_F%C3%ADsicas
 */
public class CPFTest extends AbstractFakerTest {

    private String validCPF;
    private String invalidCPF;

    @Before
    public void setup() {
        validCPF = faker.cpf().valid();
        invalidCPF = faker.cpf().invalid();
    }

    /*
     * A valid CPF is either a real number or a generated valid number.
     * @see com.github.javafaker.shared.CPFUtils#calculateVerificationDigit(String)
     */
    @Test
    public void isValidCPF() {
        assertTrue(isCPFValid(validCPF));
    }

    /*
     * A invalid CPF is that dos not meet the requirements of the algorithm
     * @see com.github.javafaker.shared.CPFUtils.calculateVerificationDigit#String
     */
    @Test
    public void isInvalidCPF() {
        assertFalse(isCPFValid(invalidCPF));
    }

    /*
     * CPF has a main format. This test validate if the number is on the correct format
     * Eg: 111.111.111-11
     */
    @Test
    public void formattedCPF() {
        assertThat(validCPF, matchesRegularExpression("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)"));
    }

    /**
     * Return true if the CPF is valid
     * A valid CPF is unique and have a algorithm to validate it
     * <p>
     * CPF generator could generate a valid or invalid because, somentimes, we need to test a
     * registration with invalid number
     *
     * @see CPFUtils#calculateVerificationDigit(String)
     */
    private static boolean isCPFValid(String cpf) {
        String unformatCPF = CPFUtils.unformatCPF(cpf);

        if (unformatCPF.length() != 11) {
            return false;
        }
        String numDig = unformatCPF.substring(0, 9);
        String verification = unformatCPF.substring(9, 11);
        return CPFUtils.calculateVerificationDigit(numDig).equals(verification);
    }
}
