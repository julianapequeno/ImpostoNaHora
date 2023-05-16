package br.ufrn.imd.modelo;

public class ContaCorrente implements ITributavel {
    private String agencia;
    private String numero;
    private double saldo;

    public ContaCorrente() {
        this.saldo = 0.0;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor) {
        if (this.saldo <= 0) {
            System.out.println("Saldo insuficiente ou valor menor que 0!");
        } else {
            this.saldo -= valor;
            System.out.println("Saque de " + valor + " em [" + this.getNumero() + "] efetuado com sucesso!");
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de " + valor + " em [" + this.getNumero() + "] efetuado com sucesso!");
    }

    public boolean transferir(double valor, ContaCorrente cc) {
        if (this.saldo <= 0) {
            System.out.println("Saldo insuficiente ou valor menor que 0!");
            return false;
        } else {
            this.sacar(valor);
            cc.depositar(valor);
            System.out.println("Transferindo " + valor + " para [" + cc.getNumero() + "]");
            return true;
        }
    }

    @Override
    public double calcularTributos() {
        return this.getSaldo() * 0.62;
    }

}
