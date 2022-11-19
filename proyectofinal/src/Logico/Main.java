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
		
		
		Persona jurado1 = new Jurado("095","Julio","849-922",""+feria.getCodjurado(),"fisica");
		feria.agregarpersonas(jurado1);
		Persona jurado2 = new Jurado("095","perez","829-922",""+feria.getCodjurado(),"matematic");
		feria.agregarpersonas(jurado2);
		
		
		Comision comi1 = new Comision(""+feria.getCodcomision(),"fisica",(Jurado)jurado1);
		feria.agregarcomisiones(comi1);
		Comision comi2 = new Comision(""+feria.getCodcomision(),"matematic",(Jurado)jurado2);
		feria.agregarcomisiones(comi2);
		
		
		feria.agregartrabajo(""+feria.getCodtrabajo(), "Acelerador particular", ""+1, comi1);
		feria.agregartrabajo(""+feria.getCodtrabajo(), "Volcan", ""+0,comi2);
		feria.agregartrabajo(""+feria.getCodtrabajo(), "Sistema nervioso", ""+1,comi1);
		

		
		System.out.println(feria.mejorparticipante());
		System.out.println(feria.mejortrabajadoarea(""+0));
		
	}

}
