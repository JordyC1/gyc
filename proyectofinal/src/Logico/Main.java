package Logico;

public class Main {

	public static void main(String[] args) {
		EventoCiencia feria = new EventoCiencia();
		
		Persona participante1 = new Participante("098","Javier","809-987",""+feria.getCodparticipante());
		feria.agregarpersonas(participante1);
		Persona participante2 = new Participante("095","Julio","849-922",""+feria.getCodparticipante());
		feria.agregarpersonas(participante2);
		Persona participante3 = new Participante("095","perez","829-922",""+feria.getCodparticipante());
		feria.agregarpersonas(participante3);
		
		
		Persona jurado1 = new Participante("095","Julio","849-922",""+feria.getCodparticipante());
		feria.agregarpersonas(jurado1);
		Persona jurado2 = new Participante("095","perez","829-922",""+feria.getCodparticipante());
		feria.agregarpersonas(jurado2);
		
		
		
		
	}

}
