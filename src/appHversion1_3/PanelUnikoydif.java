package appHversion1_3;
//TODAS LAS RESTRICCIONES Y APPUNTES DE TODAS LAS RESPECTIVAS CLASES, DEBEN IR HASTA ABAJO DEL DOCUMENTO COMO UN SOLO COMENTARIO MULTILINEA


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelUnikoydif extends JPanel {
	
	private CardLayout sistDeCartas01, sistDeCartas02;
	private JPanel pOriente, pCentro, pPoniente, pNorte, pSur; //los paneles se encuentran insertados en los sus respectivos lugares dentro del panelUniko con BorderLayout. EXCEPTO los paneles CENTRO y ORIENTE los cuales estan insertados en un objeto de tipo JSlplitPane a su vez incrustado en la ubicacion CENTRO del panel con BorderLAyout( panelUniko )
	private JSplitPane splitCentral;
	
	private JPanel panelKonteNidos[]; //cada panel corresponde a un boton
	private Color kolors[]; //cada uno de estos colores corresponde a un panelKontenido
	private JButton botonesIzk[]; 
	private String nomb_botonesIzkPROVISIONAL[] = { "Configuraciones", "Inicio", "Inventarios", "Laboral", "Registros", "Reportes"  } ;
	
	private JPanel panelHistorial[]; //array de un solo elemento, puede crecer
	private String convocadoresPanelHistorial[] = { "convocador01" }; //array con un solo elemento, puede crecer con panelHistorial
	
	
	public PanelUnikoydif() {
		
		this.prepararParaInicTodo();
		this.configurarStaClaseforInic(); //se manda a llamar un METODO PRIVADO	private panel
		
			//--- ---- -- Cod: 342
		//insertarAquiCualquierCodigoDePrueba();
			//--- ---- --
		
		
	}//fin metodo constructor
	public PanelUnikoydif(LayoutManager layout) {
		super(layout);
	}//fin metodo constructor
	public PanelUnikoydif(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}//fin metodo constructor
	public PanelUnikoydif(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}//fin metodo constructor



	
	private void configurarStaClaseforInic() {
		this.setLayout( new BorderLayout( 10,10 ));
		this.setBackground( Color.DARK_GRAY );
		this.add( splitCentral , BorderLayout.CENTER ); //en el panel de centro no se inserta un panel, se inserta un splitPanel donde cabe lo del CENTRO + del del ORIENTE 
		this.add( pPoniente, BorderLayout.WEST );
		this.add( pNorte, BorderLayout.NORTH );	
	}//FIN DEL METODO PRIVADO
	
	
	//METODO MODELo!!!!!!!!!!!!!!!!!!
	public void prepararParaInicTodo() { //ESTE METODO PREPARA, O MANDA A PREPARAR A CADA UNO DE LOS ATRIBUTOS DE LA CLASE, PARA QUE TENGAN UNA CONFIGURACION MINIMA XDEFECTO PARA AGREGARSE POSTERIORMENTE EN LA CLASE QUE LA CONTIENE.
		//POR LO TANTO NO CONVOCAR AKI A NINGUNA METODO DE LA CLASE CONTENERA (PanelUnikoYDiff)

		
		//DECLARACION DE ALGUNAS VARIABLES DESECHABLES 
		String s[] = { "akiva la barra de menu", "kola", "panzaCola", "desaloha" };
		
		Dimension dimMin = new Dimension( 200, 300 );
		
		//INICIALIZACIONES-CONSTRUCCIONES:
		this.kolors = new Color[6];
		this.kolors[0] = new Color( 214,214,214 ); //negrogris
		this.kolors[1] = new Color( 255,251,137 ); //Amarillo 
		this.kolors[2] = new Color( 156,231,255 ); //azul 
		this.kolors[3] = new Color( 255,186,186 ); //rojito
		this.kolors[4] = new Color( 166,255,135 ); //verde
		this.kolors[5] = new Color( 255,255,255 ); //blanquito
		this.panelKonteNidos = new JPanel[6]; for( int i=0;i<6;i++ ) panelKonteNidos[i] =  new JPanel();  //un panel destos para cada boton del Poniente
		this.panelHistorial = new JPanel[1]; for( int i=0;i<1;i++ ) panelHistorial[i] = new JPanel();
		this.botonesIzk = new JButton[6]; for( int i=0;i<6;i++ ) botonesIzk[i] = new JButton( nomb_botonesIzkPROVISIONAL[i] ); //un boton que deberá estar personalizado y tener un logotipo
		for( int i=0;i<6;i++ ) botonesIzk[i].setBackground( kolors[i] );
		this.splitCentral = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
		this.pOriente = new JPanel( new CardLayout( 20,20 ) ); 
		this.pCentro = new JPanel( new CardLayout( 20,20 ) ); 
		this.sistDeCartas01 = (CardLayout)pCentro.getLayout();
		this.sistDeCartas02 = (CardLayout)pOriente.getLayout();
		this.pPoniente = new JPanel( new GridLayout( 6,1 ) ); //Contiene el menu de 6botones que pertenece a cada Kontenido
		this.pNorte = new JPanel( new FlowLayout( 10 ) ); //
		
		//AGRAGACIONES DE LOS OBJETOS ANTES INICIADOS:
		for( int i=0;i<6;i++ ) pPoniente.add( botonesIzk[i] );
		for( int i=0;i<6;i++ ) panelKonteNidos[i].add( new JLabel( "ETIQUETA PARA EL PANEL: " + i ) );
		for( int i=0;i<6;i++ ) pCentro.add( panelKonteNidos[i], nomb_botonesIzkPROVISIONAL[i] );
		for( int i=0;i<1;i++ ) pOriente.add( panelHistorial[i], convocadoresPanelHistorial[i] );
		this.pNorte.add( new JComboBox( s ) ); 
		
		//CONFIGURACIONES DE LOS OBJETOS AKI USADOS		
		this.sistDeCartas01.show( pCentro , nomb_botonesIzkPROVISIONAL[3] );
		this.sistDeCartas02.show( pOriente , convocadoresPanelHistorial[0] );
		this.panelHistorial[0].setBackground( Color.MAGENTA );
		this.panelHistorial[0].add( new JLabel( "etiquetadelpanelHISTORIAL" ) );
		this.panelHistorial[0].add( new JLabel( "En este espacio, se mostrarán a modo de PILA, todos los movimientos que pueda llegar a conocer el usuario, poner fecha en esos movimientos, tambien poner una barra de desplazamiento vertical" ) );
		this.pOriente.setMinimumSize( dimMin );
		this.pCentro.setMinimumSize( dimMin );
		for( int i=0;i<6;i++ ) panelKonteNidos[i].setBackground( kolors[i] ); ;
		this.splitCentral.setLeftComponent( pCentro );
		this.splitCentral.setRightComponent( pOriente ); //recordad que cualquier intento de meter mas de un lemento en los JSplitPane, arrojará un error o una excepcion
		this.splitCentral.setOneTouchExpandable( true );
		this.splitCentral.setEnabled( true );
	
		
		
	} //fin del metodo preparar para iniciar todo

	
	public void establecerListenersFull( ActionListener aL ) {
		for( int i=0;i<6;i++ ) botonesIzk[i].addActionListener( aL ); //botones que al accionar cambian el contenido del centro
	}//fin del metodo
	

	
	
	
	
	public void setPanelOriente( JPanel p ) {
		this.pOriente = p;
	}
	public void setPanelCentro( JPanel p ) {
		this.pCentro = p;
	}
	public void setPanelPoniente( JPanel p ) {
		this.pPoniente = p;
	}
	public void setPanelNorte( JPanel p ) {
		this.pNorte = p;
	}
	public void setPanelSur( JPanel p ) {
		this.pSur = p;
	}
	public void setSplitPn( JSplitPane j ) {
		this.splitCentral = j;
	}
	public JSplitPane getSplitPn() {
		return this.splitCentral;
	}
	public JPanel getPanelOriente() {
		return this.pOriente;
	}
	public JPanel getPanelCentro() {
		return this.pCentro;
	}
	public JPanel getPanelPoniente() {
		return this.pOriente;
	}
	public JPanel getPanelNorte() {
		return this.pOriente;
	}
	public JPanel getPanelSur() {
		return this.pSur;
	}
	public CardLayout getCartas01() {
		return this.sistDeCartas01;
	}
	public CardLayout getCartas02() {
		return this.sistDeCartas02;
	}
	public JButton[] getBotonesIzq() {
		return this.botonesIzk;
	}
	public String[] getnomb_botonesIzqPROVISIONAL() {
		return this.nomb_botonesIzkPROVISIONAL;
	}


}//fin de toda la clase



























/*COMENTARIOS Y RESTRICCIONES 
 * *****************************************************************
 * * * * * RGxx = restriccion general = "todas las clases deben seguir esta restriccion"
 * * * * * Rxx = restriccion = "algun apunte que se debe atender antes de considerar terminado el codigo de esta clase: " 
 * *****************************************************************
 * 
 * RG01: Todas las impresiones en pantalla son anuncios de cómo se va a ejecutando el codigo, son mensajes para orientacion del programador 
 * RG02: Los mensajes para orientar al usuario apareceran en un objetoGrafico, debidamente señalizados (jlabel, jpanel, etc. )
 * RG03: No consfigurar los atributos, o los miembros de los atributos desde las clases superiores
 * 
 * 
 * 
 * 
 *esta clase tendra primero que nada distribucion de BORDES, ocupando solamente 4 de ellos: NORTE, ESTE,CENTRO y OESTE, dejando de lado el sur, pero aun asi se encuentra declarado
 *
 * En el CENTRO se encntraran los subcontenidos propiamente 
 * En el ESTE se encontrara una especie de consola para el usuario final que le dira los ultimos acontecimientos importantes cronologicamente
 * En el OESTE el panel de botones de contenidos
 * En el NORTE se encontrara una barra de menu, que empezara a funcionar a y a diseñarse para que se modificquen aspectos visuales en tiempo real desde ahi 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * ESTE PANEL PRETENDE COMO SU COMO US NOMBRE LO INDICA, UNICO Y DIFERENTE, DE MODO QUE AL LA HORA DE DISEÑAR ESTE PROGRAMA SE CONSIDERA QUE LA INTERFAZ ES Y SERÁ UNICA... NO OBSTANTE, MUCHAS DE LAS FORMAS QUE DESARROLLAMOS PARA ESTA APP, SON IGUALES O SIMILARES A LAS QUE SE PUEDAN REQUERIR EN LAS FUTURAS APPS.
 * CLASE NO REUTILIZABLE ( AUN )
 * METODOS NO REUTILIZABLES ( AUN ) 
 * * */




