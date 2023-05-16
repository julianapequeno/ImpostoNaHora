package br.ufrn.imd.modelo;

public class SeguroVida implements ITributavel {
    private int numero;
    private String beneficiado;
    private double valor;
    private final static double TAXA = 31.50;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(String beneficiado) {
        this.beneficiado = beneficiado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularTributos() {
        return this.getValor() - TAXA;
    }

}
