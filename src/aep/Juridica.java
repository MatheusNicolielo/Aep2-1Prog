package aep;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Juridica extends Pessoa {
	private String cnpj;
	private double capitalSocial;
	private Set<CotaSociedade> cotasSociedade = new HashSet<>();
	
	public Juridica(String nome, String cnpj, double capitalSocial) {
		super(nome);
		if(Cnpj.isCNPJ(cnpj)) {
			this.cnpj = cnpj;
		}else {
			throw new RuntimeException("Cnpj inv�lido");
		}	
		this.capitalSocial = capitalSocial;
	}
	
	public Juridica(UUID id,String nome, String cnpj, double capitalSocial) {
		super(id ,nome);
		if(Cnpj.isCNPJ(cnpj)) {
			this.cnpj = cnpj;
		}else {
			throw new RuntimeException("Cnpj inv�lido");
		}	
		this.capitalSocial = capitalSocial;
	}
	
	public void adicionarSocio(Pessoa socio, double percentualDeParticipacao) {
		CotaSociedade nova = new CotaSociedade();
		nova.socio = socio;
		
		double percentualAtual = somarPercentualParticipacao();
		if(percentualDeParticipacao + percentualAtual > 100) {
			throw new RuntimeException("A participa��o total n�o pode exceder 100%");
		}else {
			nova.percentualDeParticipacao = percentualDeParticipacao;
			cotasSociedade.add(nova);
		}
	}
	
	public double somarPercentualParticipacao() {
		double soma = 0.00d;
		
		for(CotaSociedade auxiliar : cotasSociedade) {
			soma+=auxiliar.percentualDeParticipacao;
		}
		return soma;
	}
	
	public void removerSocio(Pessoa socio) {
		Set<CotaSociedade> auxiliar = new HashSet<>();
		for(CotaSociedade percorreConj : cotasSociedade) {
			if(!percorreConj.socio.equals(socio)) {
				auxiliar.add(percorreConj);
			}
		}
		this.cotasSociedade = auxiliar;
	}
	
	public void listarSocios() {
		for(CotaSociedade auxiliar : cotasSociedade) {
			System.out.println("Nome: " + auxiliar.socio.getNome());
			System.out.println("Percentual de Participa��o: " + auxiliar.percentualDeParticipacao);
			System.out.println("###########################");
		}
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public double getCapitalSocial() {
		return capitalSocial;
	}
	
	private class CotaSociedade{
		Pessoa socio;
		double percentualDeParticipacao;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((socio == null) ? 0 : socio.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CotaSociedade other = (CotaSociedade) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (socio == null) {
				if (other.socio != null)
					return false;
			} else if (!socio.equals(other.socio))
				return false;
			return true;
		}
		private Juridica getOuterType() {
			return Juridica.this;
		}
		
	}
}
