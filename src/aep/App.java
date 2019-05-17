package aep;

public class App {
	public static void main(String[] args) {
		Juridica carlos = new Juridica("Carlos","123",1);
		//System.out.println(carlos.getCnpj());
		carlos.adcionarSocio(carlos,45.00);
		carlos.adcionarSocio(carlos,70.00);
		carlos.listarSocios();
	}
}
