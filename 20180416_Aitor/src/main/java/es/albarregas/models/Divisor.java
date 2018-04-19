package es.albarregas.models;

import es.albarregas.exceptions.DivisionPorCeroException;

public class Divisor {

    public int dividir(int operando1, int operando2) {
        int resultado = 0;
        try {
            resultado = division(operando1, operando2);
        } catch (DivisionPorCeroException e) {
            resultado = Integer.MAX_VALUE;
        }
        return resultado;
    }

    private int division(int dividendo, int divisor)
            throws DivisionPorCeroException {
        int resultado = 0;
        if (divisor != 0) {
            resultado = dividendo / divisor;
        } else {
            throw new DivisionPorCeroException("Se ha intentado dividir por cero");
        }
        return resultado;
    }

}
