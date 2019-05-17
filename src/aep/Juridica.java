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
		this.cnpj = cnpj;
		if(capitalSocial < 100 && capitalSocial > 0)
			this.capitalSocial = capitalSocial;	
	}
	
	public Juridica(UUID id,String nome,String cnpj, double capitalSocial) {
		super(id,nome);
		this.cnpj = cnpj;
		if(capitalSocial < 100 && capitalSocial > 0)
			this.capitalSocial = capitalSocial;
	}
	
	public void listarSocios(){
		for(CotaSociedade auxiliar : cotasSociedade) {
			System.out.println("Nome: " + auxiliar.socio.getNome());
			System.out.println("Percentual: " + auxiliar.percentualDeParticipacao);
		}
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public double getCapitalSocial() {
		return capitalSocial;
	}
	
	public void adcionarSocio(Pessoa socio, double percentualDeParticipacao) {
		CotaSociedade cotas = new CotaSociedade();
		cotas.socio = socio;
		if(percentualDeParticipacao < 100 && percentualDeParticipacao > 0)
			cotas.percentualDeParticipacao = percentualDeParticipacao;
		cotasSociedade.add(cotas);
	}
	
	public void removerSocio(Pessoa socio) {
		for(CotaSociedade auxiliar: cotasSociedade) {
			if(auxiliar.socio == socio) {
				cotasSociedade.remove(socio);
			}
		}
	}
    private class CotaSociedade{
    	private Pessoa socio;
		double percentualDeParticipacao;
	}
}
