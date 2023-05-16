package br.ufrn.imd.dao;

import java.util.ArrayList;
import br.ufrn.imd.modelo.Pessoa;

public class PessoaDAO extends GeradorImpostoRenda {
    private ArrayList<Pessoa> pessoas;

    public PessoaDAO() {
        this.pessoas = new ArrayList<>();
    }

    public void cadastraPessoa(Pessoa p) {
        this.pessoas.add(p);
    }

    public void removerPessoa(Pessoa p) {
        this.pessoas.remove(p);
    }

    public void listaPessoas() {
        System.out.println("**************************************************");
        for (Pessoa p : this.pessoas) {
            System.out.print("Nome...: " + p.getNome() + " ");
            System.out.println("Salário.: " + p.getSalario());
            System.out.println("Agência: " + p.getConta().getAgencia() + " Conta: " + p.getConta().getNumero()
                    + "   Saldo.: " + p.getConta().getSaldo());
            System.out.println(
                    "Seguro.: " + p.getSeguro().getNumero() + "   Beneficiário.: " + p.getSeguro().getBeneficiado());
            System.out.println("Valor Seguro: " + p.getSeguro().getValor());
            System.out.println("**************************************************");
        }
    }

    public void CalcularTributosPessoas() {
        System.out.println("**************************************************");
        for (Pessoa p : this.pessoas) {
            System.out.print("Nome...: " + p.getNome() + "  IRPF...: "
                    + this.calculaValorTotalTributo(p));
            System.out.println("**************************************************");
        }
    }

    public void imprimeImpostoTotal() {
        System.out.println("**************************************************");
        double total = 0.0, maior = 0.0, maiorBeneficiarioValor = 0.0;
        Pessoa maiorIRPF = null;
        String maiorBene = "";

        for (Pessoa p : this.pessoas) {

            if (this.calculaValorTotalTributo(p) > maior) {
                maior = this.calculaValorTotalTributo(p);
                maiorIRPF = p;
            }

            if (p.getSeguro().getValor() > maiorBeneficiarioValor) {
                maiorBeneficiarioValor = p.getSeguro().getValor();
                maiorBene = p.getSeguro().getBeneficiado();
            }

            total += this.calculaValorTotalTributo(p);
        }
        System.out.println("Total de impostos recolhidos: " + total);
        System.out.println("Pessoa com maior IRPF a pagar: " + maiorIRPF.getNome());
        System.out.println("Valor: " + maior);
        System.out.println("Maior Beneficiado(a): " + maiorBene);
        System.out.println("Valor Benefício: " + maiorBeneficiarioValor);
    }
}
