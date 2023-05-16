package br.ufrn.imd.dao;

import br.ufrn.imd.modelo.Pessoa;

public class GeradorImpostoRenda {
    private double totalTributo;

    public double getTotalTributo() {
        return totalTributo;
    }

    public void setTotalTributo(double totalTributo) {
        this.totalTributo = totalTributo;
    }

    public double calculaValorTotalTributo(Pessoa p) {
        this.totalTributo = p.getConta().calcularTributos() + p.getSeguro().calcularTributos();
        return this.totalTributo;
    }
}
