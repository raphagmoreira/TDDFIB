package br.aula.testes.models;

public class FolhaPagamento {
	private Double salarioBruto;
	private Double descontoINSS;
	private Double descontoIR;
	private Double salarioLiquido;
	private Double horasTrabalhadas;
	private Double salarioHora;
	private Integer numeroDependentes;
	private Integer multiplicadorDependentes = 50;
	private String para;
	
	public FolhaPagamento(String para, Double horasTrabalhadas, Double salarioHora, Integer numeroDependentes) {
		this.para = para == null ? "" : para;
		this.horasTrabalhadas = horasTrabalhadas == null || horasTrabalhadas < 0.0 ? 0.0 : horasTrabalhadas;
		this.salarioHora = salarioHora == null || salarioHora < 0.0 ? 0.0 : salarioHora;
		this.numeroDependentes = numeroDependentes == null || numeroDependentes < 0 ? 0 : numeroDependentes;
	}
	
	public Double getSalarioBruto() {
		salarioBruto = getHorasTrabalhadas() * getSalarioHora() + (multiplicadorDependentes * getNumeroDependentes());
		return salarioBruto;
	}
	
	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	
	public Double getDescontoINSS() {
		Double salarioBruto = getSalarioBruto();
		
		if (salarioBruto <= 1000.0) {
			descontoINSS = (salarioBruto * 8.5) / 100;
		} else {
			descontoINSS = (salarioBruto * 9) / 100;
		}
		
		return descontoINSS;
	}
	
	public void setDescontoINSS(Double descontoINSS) {
		this.descontoINSS = descontoINSS;
	}
	
	public Double getDescontoIR() {
		Double salarioBruto = getSalarioBruto();
		
		if (salarioBruto <= 500.0) {
			descontoIR = 0.0;
		} else if (salarioBruto > 500.0 && salarioBruto <= 1000.0) {
			descontoIR = (salarioBruto * 5) / 100;
		} else {
			descontoIR = (salarioBruto * 7) / 100;
		}
		
		return descontoIR;
	}
	
	public void setDescontoIR(Double descontoIR) {
		this.descontoIR = descontoIR;
	}
	
	public Double getSalarioLiquido() {	
		salarioLiquido = getSalarioBruto() - getDescontoINSS() - getDescontoIR();
		
		return salarioLiquido;
	}
	
	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public Double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Double getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(Double salarioHora) {
		this.salarioHora = salarioHora;
	}

	public Integer getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(Integer numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}
}