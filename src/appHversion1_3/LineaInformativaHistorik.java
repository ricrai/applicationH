package appHversion1_3;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//TODAS LAS RESTRICCIONES Y APPUNTES DE TODAS LAS RESPECTIVAS CLASES, DEBEN IR HASTA ABAJO DEL DOCUMENTO COMO UN SOLO COMENTARIO MULTILINEA


public class LineaInformativaHistorik extends JPanel{ 

	private static final long serialVersionUID = 1L;
	private String txtAmostrar;
	private JTextArea campoTx;
	private JButton axionBtn;
	private String dirImg[] = {
			"src/appHversion1_3/",
			"src/appHversion1_3/IC_abrirArchivo.png" 
			};
	//declarar una fuente standar
	//declarar bordes std con texto posiblemente
	
	public LineaInformativaHistorik() {
		this.darArspectoVis(); //asigna 
		this.darTamanhos(); //asigna dimensiones
		
	}//fin del constructor
	
	
	public void darArspectoVis() { //darle aspecto y detalles visuales 
//INICIAR VARIABLES DESECHABLES
		String s = "";
		
//inicializar atributos de objeto
		this.txtAmostrar = " texto por defecacion ";
		this.campoTx = new JTextArea( this.txtAmostrar, 15, 1 );
		this.axionBtn = new JButton( new ImageIcon( this.dirImg[1] ) ); //agregar el icono a este boton, eir pensando en su listener

//CONFIGIRACIONES PRECONDICIONALES		
		this.setVisible( true );
		this.setLayout( new BoxLayout( this,0 ) );
		
//AGREGACIONES DE ESTE OBJETO PRINCIPAL ( CLASE LINEA_INFORMATIVA )
		this.add( campoTx );
		this.add( axionBtn );	

//CONFIGURACIONES Y AGREGACIONES DE OTROS OBJETOS NOPRINCIPALES¿		
		this.campoTx.setEditable( true );
		this.campoTx.setWrapStyleWord( true );
		this.campoTx.setToolTipText( "aver donde vergas me sale este puto texto donde menos se lo espera 1" );
		
		this.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createMatteBorder(5, 5, 1, 1, Color.RED),BorderFactory.createBevelBorder(2) ) );
		
		System.out.printf( "La configuracion esta de la siguiente manera \n%s \n%s \n%s \n\n", campoTx.isMinimumSizeSet(), campoTx.isMaximumSizeSet(), campoTx.isPreferredSizeSet() );
		System.out.println( "termina: darAspectoVis(), LineaInformativaHistorik" );
	}//fin del metodo
	
	
	public void darTamanhos() {
		
		
		System.out.println( "termina: darTamanhos(), LineaInformativaHistorik" );
	} //fin del metodo
	
	
	
	
	
	public JTextArea getCampotxt() {
		return this.campoTx;
	}
	public JButton getBotonAxn() {
		return this.axionBtn;
	}
	
	
	
	
} //fin de toda la clase











//ESTA CLASE CONTENDRA UN AREA DE TEXTO DE SOLO LECTURA, QUE AL PASAR EL MOUSE SOBRE ELLA, DÉ INFORMACION + DETALLADA Y, CONTENGA ESE MISMO PANEL UN BOTON, EL CUAL ACCIONA UNA VENTANA EMERGENTE, q CONTIENE SOLO TEXTO CON UN INFORME COMPLETO DEL EVENTO QUE ACABA DE SUCEDER	
//ESTA CLASE SERÁ INSTANCIADA EN EL PANEL ORIENTE, EN UNA SERIE DE EVENTOS + o - grande QUE PUEDE VARIAR EN NUMERO, POR LO TANTO SE USARÁN LOS ARRAYLISTS
//ESTA CLASE DEBE CONTENER TODOS LOS METODO NECESARIOS PARA HACER MAS CÓMODO EL MANEJO DESDE FUERA DE SUS BLOQUES DE CODIGO. PUDIENDO CAMBIAR COLORES, TAMAÑOS, ETC.
/*COMENTARIOS Y RESTRICCIONES 
 * 
 * *****************************************************************
 * * * * * RGxx = restriccion general = "todas las clases deben seguir esta restriccion"
 * * * * * Rxx = restriccion = "algun apunte que se debe atender antes de considerar terminado el codigo de esta clase: " 
 * *****************************************************************
 * 
 * RG01: Todas las impresiones en pantalla son anuncios de cómo se va a ejecutando el codigo, son mensajes para orientacion del programador 
 * RG02: Los mensajes para orientar al usuario apareceran en un objetoGrafico, debidamente señalizados (jlabel, jpanel, etc. )
 * RG03: No consfigurar los atributos, o los miembros de los atributos desde las clases superiores
 * 
 * */