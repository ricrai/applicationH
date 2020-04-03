package appHversion1_3;
//TODAS LAS RESTRICCIONES Y APPUNTES DE TODAS LAS RESPECTIVAS CLASES, DEBEN IR HASTA ABAJO DEL DOCUMENTO COMO UN SOLO COMENTARIO MULTILINEA


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelUnikoydif extends JPanel {
	
	private CardLayout sistDeCartas01, sistDeCartas02;
	private JPanel pOriente, pCentro, pPoniente, pNorte, pSur; //los paneles se encuentran insertados en los sus respectivos lugares dentro del panelUniko con BorderLayout. EXCEPTO los paneles CENTRO y ORIENTE los cuales estan insertados en un objeto de tipo JSlplitPane a su vez incrustado en la ubicacion CENTRO del panel con BorderLAyout( panelUniko )
	private JSplitPane splitCentral;
	private BarrasNorte unaBarra;
	
	private JPanel panelKonteNidos[]; //cada panel corresponde a un boton
	private Color kolors[]; //cada uno de estos colores corresponde a un panelKontenido
	private JButton botonesIzk[]; //panelesCentrales, kolores, botonesIzq, nombresdBotones, VAN RELACIONADOS DIRECTAMENTE SEGUN SU INDICE, PUES TODOS SON ARRAYS DE 6 ELEMENTOS
	private String nomb_botonesIzkPROVISIONAL[] = { "Configuraciones", "Inicio", "Inventarios", "Laboral", "Registros", "Reportes"  } ;
	
	private JPanel panelHistorial[]; //array de un solo elemento, puede crecer
	private String nombs_PanelHistorial[] = { "convocador01" }; //array con un solo elemento, puede crecer con panelHistorial
	private ArrayList <LineaInformativaHistorik> listaHist;
	public static int conteo = 0;
	
	
	
	
	public PanelUnikoydif() {
		
		this.prepararParaInicTodo();
		this.configurarStaClaseforInic(); //se manda a llamar un METODO PRIVADO	private panel
			
		this.ajustesPNorte();
		this.ajustesPPoniente();
		this.ajustesPCentro();
		this.ajustesPOriente();
			//--- ---- -- Cod: 342
		//insertarAquiCualquierCodigoDePrueba();
			//--- ---- --
		
		System.out.println( "termina: PanelUnikoydiff(), PanelUnikoydiff" );
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
/////////////////////////TERMINAN CONSTRUCTORES/////////////////////////-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	
	private void ajustesPPoniente() {
		//ya estan inicializados e incluso agregados, los botones de este panel, solo les falta ponen Icono
		String dirImg[] = { 
				"src/appHversion1_3/Icono01Configs.png", 
				"src/appHversion1_3/Icono02Inicio.png",
				"src/appHversion1_3/Icono03Invent.png",
				"src/appHversion1_3/Icono04Laboral.png",
				"src/appHversion1_3/Icono05Registr.png",
				"src/appHversion1_3/Icono06Reportes.png" 
				};		
		for( int i=0;i<6;i++ ) this.botonesIzk[i].setIcon( new ImageIcon( dirImg[i] ) );
		for( int i=0;i<6;i++ ) this.botonesIzk[i].setHorizontalTextPosition( SwingConstants.CENTER );
		for( int i=0;i<6;i++ ) this.botonesIzk[i].setVerticalTextPosition( SwingConstants.BOTTOM );
		
		System.out.println( "termina: ajustesPPoniente(), PanelUnikoydiff" );
	}//fin del metodo
	
	private void ajustesPOriente() { //modificando todo lokes es el panel Historiko, sus eventos etc, lo menos codigo posible xfa
		this.panelHistorial[0].setLayout( new BoxLayout( panelHistorial[0],1 ) );
		this.crearAgregarLinea( "SE HA INICIADO SESION, POR EL USUARIO" );
		this.crearAgregarLinea( "hola" );
		
		
		System.out.println( "termina: ajustesPOriente(), PanelUnikoydiff" );
	}//fin del metodo privado
	
	private void ajustesPNorte() { //ajustando todo lokes la barra de menu, acciones de usuario etc. lo -- codigo posible xfa
//1) DECLARAMOS VARIABLES DESECHABLES
		this.pNorte.add( unaBarra ); //se agrega en el sistemaGridLayout de 1x1
		unaBarra.getBotonAxion().addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				crearAgregarLinea( "Nueva Linea num: " + conteo + ",\nnueva historia, nuevo todo" );
			}
			
		} );//fin de clase interna anonima LISTENER
		
//2) HACEMOS ALGUNAS CONDIGURACIONES AL OBJETO PRINCIPAL QUE ES EL PANEL NORTE Y SUS CONTENIDOS
		
		
//3) HACEMOS ALGUNAS AGREGACIONES DEL OBJETO PRINCIPAL DEL METODO
	
		System.out.println( "termina: ajustesPNorte(), PanelUnikoydiff" );
	}//fin del metodo privado
	
	
	private void ajustesPCentro() { // ajustando todo lo que es el contenido y subcontenidos y sus eventos etc. el --- codigo posible xfavor!
		
		System.out.println( "termina: ajustesPCentro(), PanelUnikoydiff" );
	}//fin del metodo private 

	
	public void crearAgregarLinea( String s ) { //
		
		this.listaHist.add( new LineaInformativaHistorik() );
		this.panelHistorial[0].add( listaHist.get( conteo ));
		listaHist.get( conteo ).getCampotxt().setText( s );
		System.out.println( "LLEVAMOS AGREGADAS: >>" + (conteo+1) + "<< LINEAS HISTORICAS EN ESTA SESION" + "\n\n" );
		
		conteo++;
		System.out.println( "termina: crearAgregarLinea(), PanelUnikoydif" );
	}//fin del metodo
	


		
	private void configurarStaClaseforInic() { //se encarga que este objeto heredero de JPanel se configure en tamaño, color, y generales etc
		this.setLayout( new BorderLayout( 10,10 ));
		this.setBackground( Color.DARK_GRAY );
		this.add( splitCentral, BorderLayout.CENTER ); //en el panel de centro no se inserta un panel, se inserta un splitPanel donde cabe lo del CENTRO + del del ORIENTE 
		this.add( pPoniente, BorderLayout.WEST );
		this.add( pNorte, BorderLayout.NORTH );	
		System.out.println( "termina: configurarStaClaseforInic(), PanelUnikoydiff" );
	}//FIN DEL METODO PRIVADO
	
	
	//METODO MODELo!!!!!!!!!!!!!!!!!!
	public void prepararParaInicTodo() { //ESTE METODO PREPARA, O MANDA A PREPARAR A CADA UNO DE LOS ATRIBUTOS DE LA CLASE, PARA QUE TENGAN UNA CONFIGURACION MINIMA XDEFECTO PARA AGREGARSE POSTERIORMENTE EN LA CLASE QUE LA CONTIENE.
		//POR LO TANTO NO CONVOCAR AKI A NINGUNA METODO DE LA CLASE CONTENERA (PanelUnikoYDiff)

//DECLARACION DE ALGUNAS VARIABLES DESECHABLES 
		Dimension dimMin = new Dimension( 200, 300 ); //tamanho minimo para cada uno de los elementos del splitpanel
		
//INICIALIZACIONES-CONSTRUCCIONES:
		this.kolors = new Color[6];
		this.panelKonteNidos = new JPanel[6]; 
		this.panelHistorial = new JPanel[1];
		this.botonesIzk = new JButton[6]; 
		this.unaBarra = new BarrasNorte();
		this.listaHist  = new ArrayList<LineaInformativaHistorik>();
		this.kolors[0] = new Color( 255,255,255 ); //blanquito
		this.kolors[1] = new Color( 255,251,137 ); //Amarillo 
		this.kolors[2] = new Color( 156,231,255 ); //azul 
		this.kolors[3] = new Color( 255,186,186 ); //rojito
		this.kolors[4] = new Color( 166,255,135 ); //verde
		this.kolors[5] = new Color( 214,214,214 ); //negrogris
		for( int i=0;i<6;i++ ) panelKonteNidos[i] =  new JPanel();  //un panel destos para cada boton del Poniente
		for( int i=0;i<1;i++ ) panelHistorial[i] = new JPanel(); //existe un solo lemento en el Array, pero pueden ser mas
		for( int i=0;i<6;i++ ) botonesIzk[i] = new JButton( nomb_botonesIzkPROVISIONAL[i] ); //un boton que deberá estar personalizado y tener un logotipo

		//for( int i=0;i<20;i++ ) listorial.add( new LineaInformativaHistorik() );
		
		this.splitCentral = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
		this.pOriente = new JPanel( new CardLayout( 20,20 ) ); 
		this.pCentro = new JPanel( new CardLayout( 20,20 ) ); 
		this.sistDeCartas01 = (CardLayout)pCentro.getLayout(); //inicializa y da valor al atributo
		this.sistDeCartas02 = (CardLayout)pOriente.getLayout(); //inicializa y da valor al atributo
		this.pPoniente = new JPanel( new GridLayout( 6,1 ) ); //Contiene el menu de 6botones que pertenece a cada Kontenido
		this.pNorte = new JPanel( new GridLayout( 1,1 ) ); //Correcto
		
//AGRAGACIONES DE LOS OBJETOS ANTES INICIADOS:
		for( int i=0;i<6;i++ ) pPoniente.add( botonesIzk[i] ); //agrega los botones de contenido
		for( int i=0;i<6;i++ ) panelKonteNidos[i].add( new JLabel( "ETIQUETA PARA EL PANEL: " + i ) ); // agregar unaetiqueta informativa
		for( int i=0;i<6;i++ ) pCentro.add( panelKonteNidos[i], nomb_botonesIzkPROVISIONAL[i] ); //agrega cartas
		for( int i=0;i<1;i++ ) pOriente.add( panelHistorial[i], nombs_PanelHistorial[i] ); // agrega paneles de diferentes tiposHistoricos
		
//CONFIGURACIONES DE LOS OBJETOS AKI USADOS
		
		
			//-- - Cod 21
		//insertar aqui el codigo de prueba
			//-- -
		
		this.sistDeCartas01.show( pCentro , nomb_botonesIzkPROVISIONAL[3] );
		this.sistDeCartas02.show( pOriente , nombs_PanelHistorial[0] );
		this.panelHistorial[0].setBackground( Color.MAGENTA );
		this.pOriente.setMinimumSize( dimMin );
		this.pCentro.setMinimumSize( dimMin );
		for( int i=0;i<6;i++ ) botonesIzk[i].setBackground( kolors[i] );
		for( int i=0;i<6;i++ ) panelKonteNidos[i].setBackground( kolors[i] ); ;
		this.splitCentral.setLeftComponent( pCentro );
		this.splitCentral.setRightComponent( pOriente ); //recordad que cualquier intento de meter mas de un lemento en los JSplitPane, arrojará un error o una excepcion
		this.splitCentral.setOneTouchExpandable( true );
		this.splitCentral.setEnabled( true );		
	
		System.out.println( "termina: prepararParaInicTodo(), PanelUnikoydiff" );
	} //fin del metodo preparar para iniciar todo

	
	public void establecerListenersFull( ActionListener aL ) {
		for( int i=0;i<6;i++ ) botonesIzk[i].addActionListener( aL ); //botones que al accionar cambian el contenido del centro
		
//		JButton btnNort = (JButton)this.getPanelNorte().getComponent( 1 );
//		btnNort.addActionListener( aL );
		System.out.println( "termina: establecerListenersFull(), PanelUnikoydiff" );
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
	public BarrasNorte getBarraNort() {
		return this.unaBarra;
	}
	public LineaInformativaHistorik[] getLineaHis() {
		LineaInformativaHistorik a[] = this.getLineaHis();
		
		return a;
	}//fin del metodo OBTENER LINEA HISTORIK
	
	
	
	
	

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




