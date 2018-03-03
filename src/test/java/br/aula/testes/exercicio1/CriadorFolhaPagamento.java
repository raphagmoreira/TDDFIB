package br.aula.testes.exercicio1;

import java.util.ArrayList;
import java.util.List;

import br.aula.testes.models.FolhaPagamento;

public class CriadorFolhaPagamento {
	private String para;
	private Double horasTrabalhadas;
	private Double salarioHora;
	private Integer numeroDependentes = 0;
	private List<String> dependentes = new ArrayList<String>();
	
	public CriadorFolhaPagamento para(String nome) {
		this.para = nome;
		return this;
    }
	
	public CriadorFolhaPagamento horasTrabalhadas(Double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
		return this;
	}
	
	public CriadorFolhaPagamento salarioHora(Double salarioHora) {
		this.salarioHora = salarioHora;
		return this;
	}
	
	public CriadorFolhaPagamento dependente(String nome) {
		this.dependentes.add(nome);
		this.numeroDependentes++;
		
		return this;
	}
	
	public FolhaPagamento constroi() {
		return new FolhaPagamento(this.para, this.horasTrabalhadas, this.salarioHora, this.numeroDependentes);
	}
}