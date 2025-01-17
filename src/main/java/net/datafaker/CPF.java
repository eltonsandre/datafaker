package net.datafaker;

import net.datafaker.shared.CPFUtils;

/**
 * A CPF number is the Tax ID generated once you have been registered into the Brazilian Revenue.
 * CPF stands for "Cadastro de Pessoas Físicas" (Natural Persons Register).
 * <p>
 * The CPF has 11 digits and it may be issued by the Brazilian revenue service
 * in Brazil or Brazilian consulates and embassies abroad.
 * <p>
 * Partial code copy from https://github.com/jrjuniorsp/GeradorValidadorCPFCNPJ/blob/master/src/com/jrmobile/service/GeradorCPF.java
 */
public class CPF {

    private final Faker faker;

    protected CPF(Faker faker) {
        this.faker = faker;
    }

    /**
     * Return valid and formatted
     *
     * @return a valid CPF
     * @see CPFUtils#unformatCPF(String) to unformat
     */
    public String valid() {
        return generateCPF(true);
    }

    /**
     * Return invalid and formatted
     *
     * @return an invalid CPF
     * @see CPFUtils#unformatCPF(String) to unformat
     */
    public String invalid() {
        return generateCPF(false);
    }

    public String generateCPF(boolean valid) {
        StringBuilder partial = new StringBuilder();
        String cpf;
        int number;

        for (int i = 0; i < 9; i++) {
            number = faker.random().nextInt(10);
            partial.append(number);
        }

        if (valid) {
            cpf = partial + CPFUtils.calculateVerificationDigit(partial.toString());
        } else {
            long elevenDigits = (faker.random().nextInt(1000000000) + (faker.random().nextInt(90) + 10) * 1000000000L);
            cpf = String.valueOf(elevenDigits);
        }

        return formatCPF(cpf);
    }

    private String formatCPF(String cpf) {
        String block1 = cpf.substring(0, 3);
        String block2 = cpf.substring(3, 6);
        String block3 = cpf.substring(6, 9);
        String block4 = cpf.substring(9, 11);

        return String.format("%s.%s.%s-%s", block1, block2, block3, block4);
    }

}
