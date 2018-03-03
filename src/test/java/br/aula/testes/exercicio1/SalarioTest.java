package br.aula.testes.exercicio1;

import org.junit.Before;
import org.junit.Test;

import br.aula.testes.models.FolhaPagamento;

public class SalarioTest {
	private FolhaPagamento folhaPagamento;
	Double horasTrabalhadas;
	Double salarioHora;
	Integer numeroDependentes;
	
	@Before
	public void init() {
		this.horasTrabalhadas = 200.0;
		this.salarioHora = 50.0;
		this.numeroDependentes = 2;
	}
	
	@Test
	public void calcularFolha() {
		folhaPagamento = new CriadorFolhaPagamento().para("Carlos")
							.horasTrabalhadas(horasTrabalhadas)
							.salarioHora(salarioHora)
							.dependente("Ana")
							.dependente("Tati")
							.constroi();
		
		System.out.println("Colaborador: " + String.valueOf(folhaPagamento.getPara()));
		System.out.println("Número Dependentes: " + String.valueOf(folhaPagamento.getNumeroDependentes()));
		System.out.println("Salário Bruto: " + String.valueOf(folhaPagamento.getSalarioBruto()));
		System.out.println("Desconto INSS: " + String.valueOf(folhaPagamento.getDescontoINSS()));
		System.out.println("Desconto IR: " + String.valueOf(folhaPagamento.getDescontoIR()));
		System.out.println("Salário Líquido: " + String.valueOf(folhaPagamento.getSalarioLiquido()));
	}
}
