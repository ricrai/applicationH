package appHversion1_3;
//TODAS LAS RESTRICCIONES Y APPUNTES DE TODAS LAS RESPECTIVAS CLASES, DEBEN IR HASTA ABAJO DEL DOCUMENTO COMO UN SOLO COMENTARIO MULTILINEA





import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameGral extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L; //autojenerado x sistema

	private PanelUnikoydif pnCentralUnikoydif;
	private JPanel pnCentralContras;
	private CardLayout barajaAcceso;
	private String textoEnTitl;
	private Dimension dimensionHrdw;
	private AnaLaAnalista analister;
	private String unDocCualquiera = "nuevoDocumentoDePrueba.txt"; //cadena que representa SOLAMENTE EL EL NOMBRE del archivo que se está probando
	
	
	public FrameGral() {
		this.inicilizarAtributosYconfigInic(); // 1) PRIMERITO DE TODOS LO METODOS, se deben tener la menor cantidad de metodos invocados aqui en el constructor para reducir las lineas de codigo, y aumentar lo entendibilidad 
		this.intentarMovidaxd();	
		this.pnCentralUnikoydif.establecerListenersFull( this );
		
		System.out.println( "fin del constructor:FrameGral" );
	}//fin del constructor

	
	private void inicilizarAtributosYconfigInic() {
		this.pnCentralUnikoydif = new PanelUnikoydif();
		this.pnCentralContras = new JPanel(); //hacer una clase especial que pretenda mejorar la seguridad del programa
		this.analister = new AnaLaAnalista(); //clase que hace todo tipo de calculos y backend
		this.barajaAcceso = new CardLayout( 20,20 ); //Auxiliar del panelDeContraseñas
		this.dimensionHrdw = new Dimension( 1000,700 ); //Dimension del hardware, o mas bien de la pantalla 
		this.textoEnTitl = "textoXdefectuoso";
		this.setTitle( this.textoEnTitl );
		this.setVisible( true );
		this.setBounds( 0, 0, 1000, 700);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.add( pnCentralUnikoydif );		
		
		System.out.println("fin del metodo inicializarAtbs:FrameGral");
	} //fin del metodo privado inicializar atributos
	
	private void intentarMovidaxd() { //metodo para probar codigo..... 
		
		boolean b = AnaLaAnalista.versiexisteArchivoEnCarpeta( this.unDocCualquiera ); 
		if ( b ) {
			for( int i=0;i<1;i++ ) System.err.println( "SI_EXISTE!!!!!!!.jpg" );
			System.out.println( "Se ha encontrado el archivo, vea el contenido de la CONSOLADEUSUARIO para vislumbralo o.o " );
			
			
			//si existe entonces se muestra EN LA CONSOLA_DE_USUARIO en la parte Oriente del panel, el historial que contenga la consulta y el archivo, preferentemente con la hora prox
			
		}else {
			//instrucciones por si no existe
			for( int i=0;i<1;i++ ) System.err.println( "NO_EXISTE.jpg.. y si existía pos ya se reseteo krnal" );
			AnaLaAnalista.intentarCrearArchivoBlanko( this.unDocCualquiera );
			
			//1- sin no existe entonces se crea el archivo
			//se le indica al usuario que el archivo esta recien creado
			//se le obliga a editar por lo menos un poquito el archivo de texto
			
		}//fin del IF-ELSE
		
	
		
	}//fin del metodo intentar movida que se usa para probar algun tipo de codice, que luego se pretenda mover a otro bloque de codigo

	
	public int identifBoton( ActionEvent e ) {
		String st[] = pnCentralUnikoydif.getnomb_botonesIzqPROVISIONAL();
		int forRetorno = -1;
		
		if( e.getActionCommand()==st[0] ) forRetorno = 0;
		if( e.getActionCommand()==st[1] ) forRetorno = 1;
		if( e.getActionCommand()==st[2] ) forRetorno = 2;
		if( e.getActionCommand()==st[3] ) forRetorno = 3;
		if( e.getActionCommand()==st[4] ) forRetorno = 4;
		if( e.getActionCommand()==st[5] ) forRetorno = 5;
		
		return forRetorno;
	}//fin del metodo
	
	
	
	
	public void actionPerformed( ActionEvent e ) {
		System.out.println( "Se ha desencadenado un evento from: " + e.toString() );
		this.pnCentralUnikoydif.getCartas01().show( pnCentralUnikoydif.getPanelCentro() , pnCentralUnikoydif.getnomb_botonesIzqPROVISIONAL()[ identifBoton( e ) ] );
	}//fin del meotodo "Axion Realizada"
	

	
	
	
	
	
	
	
} //fin de clase FRAME GENERAL






/*COMENTARIOS Y RESTRICCIONES 	
 ********************************************
 * * * * * RGxx = restriccion general = "todas las clases deben seguir esta restriccion"
 * * * * * Rxx = restriccion = "algun apunte que se debe atender antes de considerar terminado el codigo de esta clase FRAME GENERAL" 
 ********************************************
 * 
 * 
 * RG01: Todas las impresiones en pantalla son anuncios de cómo se va a ejecutando el codigo, son mensajes para orientacion del programador 
 * RG02: Los mensajes para orientar al usuario apareceran en un objetoGrafico, debidamente señalizados (jlabel, jpanel, etc. )
 * RG03: No consfigurar los atributos, o los miembros de los atributos desde las clases superiores
 * 
 * 
 * * R01: Este frame preferentemente no ocupará ningun LayoutManager especifico, en su momento se le colocará un borderlayout
 * * R02: Este frame gral, tendra X atributos: 1)panelCentralUnikoydifCARTAuno, 2)panelcentralContrseñasCARTAdos, 3)kardLayoutDeAcceso, 4)TextoEntitulo, 5)DatosdeHardware, 6)AnalizadorDeContras 
 * * 
 * *
 * *
 * *
 * *
 * *
 * *
 * *
 * *
 * *
 * 
 * */





