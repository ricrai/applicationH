package appHversion1_3;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LineaInformativaHistorik extends JPanel{ 

	private static final long serialVersionUID = 1L;
	private String txtAmostrar;
	private JTextArea campoTx;
	private JButton axionBtn;

	//declarar una fuente standar
	//declarar bordes std con texto posiblemente
	
	private String d_a_Raiz = "src/appHversion1_3/"; //siglas de DIRECCION ABSOLUTA DEL DIRECTORIO RAIZ
	private String d_r_c_Bases = "src/appHversion1_3/bases/"; //siglas de DIRECCION RELATIVA DE BASES
	private String d_r_c_AudioVisual = "src/appHversion1_3/audioVisual/"; //siglas de DIRECCION RELATIVA DE ARCHIVOS UTILIZABLES
	
	
	
	public LineaInformativaHistorik() {
		this.darArspectoVis(); //asigna 
		
	}//fin del constructor
	
	
	public void darArspectoVis() { //darle aspecto y detalles visuales 
//INICIAR VARIABLES DESECHABLES
		String s = "";
		
//inicializar atributos de objeto
		this.txtAmostrar = " texto por defecacion ";
		this.campoTx = new JTextArea( this.txtAmostrar );
		this.axionBtn = new JButton( new ImageIcon( this.d_r_c_AudioVisual + "IC_abrirArchivo.png" ) ); //agregar el icono a este boton, eir pensando en su listener

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
		
		System.out.println( "termina: darAspectoVis(), LineaInformativaHistorik" );
	}//fin del metodo
	

	
	
	
	
	public JTextArea getCampotxt() {
		return this.campoTx;
	}
	public JButton getBotonAxn() {
		return this.axionBtn;
	}
	
	
	
	
} //fin de toda la clase

