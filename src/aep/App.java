package aep;

public class App {
	public static void main(String[] args) {
		//J� esta validando CPF, CNPJ
		Pessoa wilson = new Fisica("Wilson da Silva Matos","63701937044","987.654.321-0");
		Pessoa claudio = new Fisica("Claudio Ferdinandi","12079154087","123.456.789-0"); 
		Pessoa matheus = new Fisica("Matheus Nicolielo","45161322063","123.456.789-0");
		Juridica uniCesumar = new Juridica("UniCesumar Centro Universit�rio Cesumar Ltda.", "16250582000102", 500_000d);

		uniCesumar.adicionarSocio(wilson, 60.00d);
		uniCesumar.adicionarSocio(claudio, 30.00d);
		uniCesumar.adicionarSocio(matheus, 10.00d);
		
		//System.out.println("Funcionou.");
		
		uniCesumar.removerSocio(matheus);
		uniCesumar.listarSocios();
	}
}
