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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class PanelUnikoydif extends JPanel {
	
	private CardLayout sistDeCartas01, sistDeCartas02;
	private JPanel pOriente, pCentro, pPoniente, pNorte, pSur; //los paneles se encuentran insertados en los sus respectivos lugares dentro del panelUniko con BorderLayout. EXCEPTO los paneles CENTRO y ORIENTE los cuales estan insertados en un objeto de tipo JSlplitPane a su vez incrustado en la ubicacion CENTRO del panel con BorderLAyout( panelUniko )
	private JSplitPane splitCentral= new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
	private BarrasNorte unaBarra = new BarrasNorte();
	private JButton botonShell = new JButton();
	private JTextField fieldShell = new JTextField( 20 );
	
	private JPanel panelKonteNidos[] = new JPanel[6]; //cada panel corresponde a un boton
	private Color kolors[] = new Color[6]; //cada uno de estos colores corresponde a un panelKontenido
	private JButton botonesIzk[] = new JButton[6]; //panelesCentrales, kolores, botonesIzq, nombresdBotones, VAN RELACIONADOS DIRECTAMENTE SEGUN SU INDICE, PUES TODOS SON ARRAYS DE 6 ELEMENTOS
	private String nomb_botonesIzkPROVISIONAL[] = { "Configuraciones", "Consola", "Inventarios", "Laboral", "Registros", "Reportes"  } ;
	
	private JPanel panelHistorial[] = new JPanel[1]; //array de un solo elemento, puede crecer
	private JScrollPane scrollHistoryal[] = new JScrollPane[1];
	private String nombs_PanelHistorial[] = { "convocador01" }; //array con un solo elemento, puede crecer con panelHistorial
	private ArrayList <LineaInformativaHistorik> listaHist = new ArrayList<LineaInformativaHistorik>();
	public static int conteo = 0;
	
	
	
	private String d_a_Raiz = "src/appHversion1_3/"; //siglas de DIRECCION ABSOLUTA DEL DIRECTORIO RAIZ
	private String d_r_c_Bases = "src/appHversion1_3/bases/"; //siglas den DIRECCION RELATIVA DE BASES
	private String d_r_c_AudioVisual = "src/appHversion1_3/audioVisual/"; //siglas de DIRECCION RELATIVA DE ARCHIVOS UTILIZABLES
	
	
	
	
	public PanelUnikoydif() {
		
		this.prepararParaInicTodo();
		
		this.ajustesPNorte();
		this.ajustesPPoniente();
		this.ajustesPCentro();
		this.ajustesPOriente();
		this.ajustesPSur();
		
		this.configurarStaClaseforInic(); //ya estando construidos los paneles, por ultimo se agregan a este objeto PanelUnico
		
		
		
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

	
	
	
	
	private void ajustesPSur() {
		this.pSur.setBackground( Color.black );
		this.pSur.setForeground( Color.RED );
		this.pSur.setVisible( false );
		FlowLayout fl = (FlowLayout)this.pSur.getLayout();
		fl.setAlignment( 2 );
		
		this.pSur.add( new JLabel() );
			JLabel jl = (JLabel)pSur.getComponent( 0 );
			jl.setIcon( new ImageIcon( this.d_r_c_AudioVisual + "IconoConsola.jpg") );
			jl.setHorizontalTextPosition( SwingConstants.CENTER );
			jl.setVerticalTextPosition( SwingConstants.BOTTOM );
			jl.setToolTipText( "Este espacio SUR, esta destinado para que el usuario eskriba comandos o oreden por texto, y de esa forma operar la aplicacion desde un solo lugar" );
		this.pSur.add( Box.createHorizontalStrut(1) );
		this.pSur.add( new JTextField("@us: ",50) );
			this.fieldShell = (JTextField)pSur.getComponent( 2 );
			this.fieldShell.setForeground( Color.GREEN );
			this.fieldShell.setBackground( Color.BLACK );
			this.setBorder( BorderFactory.createLineBorder( Color.LIGHT_GRAY, 3, true) );
		this.pSur.add( Box.createHorizontalStrut( 30 ) );
		
		
		this.fieldShell.addKeyListener( new KeyListener() {

			public void keyPressed( KeyEvent keyE ) {}
			public void keyReleased( KeyEvent keyE ) {}
			public void keyTyped( KeyEvent keyE ) {}
		} );//fin de clase interna
		
		this.fieldShell.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent actE ) {
				
				crearAgregarLinea( "Nueva Linea num: " + conteo + ",\nFECHA:\t" +  LocalDate.now() + "\n HORA:\t " + LocalTime.now() + "\n" + actE.getActionCommand() );
				System.out.println( "Texto actual en shell: \t " + actE.getActionCommand() );
				System.out.println( "Mandar a llamar a los metodo de la clase analister, para que nos de datos del texto en este campo..." );
				String cadxEscribir = "NUM:" + (conteo-1)  + "\tF: " +  LocalDate.now() + "\tH: " + LocalTime.now() + "\tSHELL: " + fieldShell.getText();
				AnaLaAnalista.escribirEnCola(  d_r_c_Bases + "REG_acontecimiento.txt", cadxEscribir );
				
				fieldShell.setText( "@us: " );
			}//fin del actionPerformed
					
		} ); //fin de clase interna anonima
		
	}//fin del metodo
	public JButton getShell() { return this.botonShell; }
	public JTextField getCampoShell() { return this.fieldShell; }
	
	
	
	private void ajustesPPoniente() {
		//ya estan inicializados e incluso agregados, los botones de este panel, solo les falta ponen Icono
		String dirImg[] = { 
				this.d_r_c_AudioVisual + "Icono01Configs.png", 
				this.d_r_c_AudioVisual + "Icono02Inicio.png",
				this.d_r_c_AudioVisual + "Icono03Invent.png",
				this.d_r_c_AudioVisual + "Icono04Laboral.png",
				this.d_r_c_AudioVisual + "Icono05Registr.png",
				this.d_r_c_AudioVisual + "Icono06Reportes.png" 
				};		
		this.kolors[0] = new Color( 255,255,255 ); //blanquito
		this.kolors[1] = new Color( 255,251,137 ); //Amarillo 
		this.kolors[2] = new Color( 156,231,255 ); //azul 
		this.kolors[3] = new Color( 255,186,186 ); //rojito
		this.kolors[4] = new Color( 166,255,135 ); //verde
		this.kolors[5] = new Color( 214,214,214 ); //negrogris
		for( int i=0;i<6;i++ ) this.botonesIzk[i].setIcon( new ImageIcon( dirImg[i] ) );
		for( int i=0;i<6;i++ ) this.botonesIzk[i].setHorizontalTextPosition( SwingConstants.CENTER );
		for( int i=0;i<6;i++ ) this.botonesIzk[i].setVerticalTextPosition( SwingConstants.BOTTOM );
		for( int i=0;i<6;i++ ) pPoniente.add( botonesIzk[i] ); //agrega los botones de contenido
		for( int i=0;i<6;i++ ) botonesIzk[i].setBackground( kolors[i] );
		
		System.out.println( "termina: ajustesPPoniente(), PanelUnikoydiff" );
	}//fin del metodo
	
	private void ajustesPOriente() { //modificando todo lokes es el panel Historiko, sus eventos etc, lo menos codigo posible xfa
		
		
		this.panelHistorial[0].setLayout( new BoxLayout( panelHistorial[0],1 ) ); //box layout en vertical
		this.crearAgregarLinea( "NUM:" + conteo  + "\tF: " +  LocalDate.now() + "\tH: " + LocalTime.now() + "\tinicioSHELL::::" );
	
		
		System.out.println( "termina: ajustesPOriente(), PanelUnikoydiff" );
	}//fin del metodo privado
	
	private void ajustesPNorte() { //ajustando tod
		this.pNorte.add( unaBarra ); //se agrega en el sistemaGridLayout de 1x1
		JToggleButton b = unaBarra.getBotonAxion();
		b.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				
				
				if( b.isSelected() ) {
					b.setForeground( Color.BLACK );
					b.setText( "DESACTIVAR EL SHELL" );
					pSur.setVisible( true );
				}else {
					b.setForeground( Color.RED );
					b.setText( ">>CLIK PARA ACTIVAR EL SHELL<<" );
					pSur.setVisible( false );
				}
				
//aqui insertar un metodo que captura los datos necesarios del sistema operativo o bien de internet, pero que obtenga una hora exacta con presicion de segundos y la muestre tanto en pantalla como en el objeto de tipo JTextArea
				
				
			}
		} );//fin de clase interna anonima LISTENER
		
		
		System.out.println( "termina: ajustesPNorte(), PanelUnikoydiff" );
	}//fin del metodo privado
	
	
	private void ajustesPCentro() { // ajustando todo lo que es el contenido y subcontenidos y sus eventos etc. el --- codigo posible xfavor!
		for( int i=0;i<6;i++ ) panelKonteNidos[i].add( new JLabel( "ETIQUETA PARA EL PANEL: " + i ) ); // agregar unaetiqueta informativa
		for( int i=0;i<6;i++ ) pCentro.add( panelKonteNidos[i], nomb_botonesIzkPROVISIONAL[i] ); //agrega cartas al siste de cartas del CENTRO
		for( int i=0;i<1;i++ ) pOriente.add( scrollHistoryal[i], nombs_PanelHistorial[i] ); // agrega al sistema de cartas al objeto de tipo ScrollPanel del ORIENTE
		for( int i=0;i<6;i++ ) panelKonteNidos[i].setBackground( kolors[i] );
		
		this.splitCentral.setLeftComponent( pCentro );
		this.splitCentral.setRightComponent( pOriente ); //recordad que cualquier intento de meter mas de un lemento en los JSplitPane, arrojará un error o una excepcion
		this.splitCentral.setOneTouchExpandable( true );
		this.splitCentral.setEnabled( true );		
		
		this.scrollHistoryal[0].setVerticalScrollBar( scrollHistoryal[0].createVerticalScrollBar() );
//		this.scrollHistoryal[0].setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		this.scrollHistoryal[0].setViewportView( panelHistorial[0] );
		
		System.out.println( "termina: ajustesPCentro(), PanelUnikoydiff" );
	}//fin del metodo private 

	
	public void crearAgregarLinea( String s ) { //
		this.listaHist.add( new LineaInformativaHistorik() ); //lista hist es un array de objetos LINEAINFORMATIVAHISTORIK
		
		this.panelHistorial[0].add( listaHist.get( conteo )); //listaHistorial es un arrayList
		this.panelHistorial[0].add( Box.createVerticalStrut( 10 ) );
		
		
		listaHist.get( conteo ).getCampotxt().setText( s ); //modificamos el texto de determinada listaInformativaHist
		System.out.println( "LLEVAMOS AGREGADAS: >>" + (conteo+1) + "<< LINEAS HISTORICAS EN ESTA SESION" + "\n\n" );

		//AQUI ABAJO DAR LAS INSTRUCCIONES PARA QUE SE ESCRIBA EN EL DISCO, EN UN MISMO ARCHIVO ESPECIFICO, CADA LINEA DEL HISTORIAL CON UN FORMATO ADECUADO 
		//La creacion de una linea es una historia
		
		conteo++;
		System.out.println( "termina: crearAgregarLinea(), PanelUnikoydif" );
	}//fin del metodo
	


		
	private void configurarStaClaseforInic() { //se encarga que este objeto heredero de JPanel se configure en tamaño, color, y generales etc
		this.setLayout( new BorderLayout( 10,10 ));
		this.add( splitCentral, BorderLayout.CENTER ); //en el panel de centro no se inserta un panel, se inserta un splitPanel donde cabe lo del CENTRO + del del ORIENTE 
		this.add( pPoniente, BorderLayout.WEST );
		this.add( pNorte, BorderLayout.NORTH );	
		this.add( pSur, BorderLayout.SOUTH );
		System.out.println( "termina: configurarStaClaseforInic(), PanelUnikoydiff" );
	}//FIN DEL METODO PRIVADO
	
	
	
	public void prepararParaInicTodo() { //ESTE METODO PREPARA, O MANDA A PREPARAR A CADA UNO DE LOS ATRIBUTOS DE LA CLASE, PARA QUE TENGAN UNA CONFIGURACION MINIMA XDEFECTO PARA AGREGARSE POSTERIORMENTE EN LA CLASE QUE LA CONTIENE.
		//POR LO TANTO NO CONVOCAR AKI A NINGUNA METODO DE LA CLASE CONTENEDORA (PanelUnikoYDiff)


//INICIALIZACIONES-CONSTRUCCIONES, de los atributos que requieren inicializacion especial
		for( int i=0;i<6;i++ ) panelKonteNidos[i] =  new JPanel();  //un panel destos para cada boton del Poniente
		for( int i=0;i<1;i++ ) panelHistorial[i] = new JPanel(); //existe un solo lemento en el Array, pero pueden ser mas
		for( int i=0;i<1;i++ ) scrollHistoryal[i] = new JScrollPane(); //existe un solo lemento en el Array, pero pueden ser mas
		for( int i=0;i<6;i++ ) botonesIzk[i] = new JButton( nomb_botonesIzkPROVISIONAL[i] ); //un boton que deberá estar personalizado y tener un logotipo
		this.pOriente = new JPanel( new CardLayout( 20,20 ) ); 
		this.pCentro = new JPanel( new CardLayout( 20,20 ) );
		this.pPoniente = new JPanel( new GridLayout( 6,1 ) ); //Contiene el menu de 6botones que pertenece a cada Kontenido
		this.pNorte = new JPanel( new GridLayout( 1,1 ) ); //Correcto
		this.pSur = new JPanel( new FlowLayout()  );
		this.sistDeCartas01 = (CardLayout)pCentro.getLayout(); //inicializa y da valor al atributo
		this.sistDeCartas02 = (CardLayout)pOriente.getLayout(); //inicializa y da valor al atributo
		
//AGRAGACIONES DE LOS OBJETOS ANTES INICIADOS:
		this.sistDeCartas01.show( pCentro , nomb_botonesIzkPROVISIONAL[3] ); 
		this.sistDeCartas02.show( pOriente , nombs_PanelHistorial[0] ); 
		
	
		System.out.println( "termina: prepararParaInicTodo(), PanelUnikoydiff" );
	} //fin del metodo preparar para iniciar todo

	
	public void establecerListenersFull( ActionListener aL ) {
		for( int i=0;i<6;i++ ) botonesIzk[i].addActionListener( aL ); //botones que al accionar cambian el contenido del centro
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private class BarrasNorte extends JPanel{
		
		private SpringLayout layOut = new SpringLayout();
		private JMenuBar barry = new JMenuBar();
		private JButton botonProisional = new JButton( ">>AXION<<" );
		private JToggleButton botonProvisional = new JToggleButton( ">>CLIK PARA ACTIVAR EL SHELL<<" );
		private ArrayList<JMenu> menusTo2 = new ArrayList<JMenu>();
		private ArrayList<JMenuItem> itemsTo2 = new ArrayList<JMenuItem>(); 
		private JLabel etqDfk = new JLabel( "etxxq)_danz|Qssa@g54_.," );
		private String cadena1[] = {
				"hola",
				"holaewds",
				"textowersdf",
				"area51",
				"tdsfdsvxcz",
				"2342547",
				"2346418" };


		public BarrasNorte() {
					
			this.setBackground( Color.YELLOW );
			this.setVisible( true );
			this.setLayout( new SpringLayout() );
		
			
			this.barry = configBarra(); 
			this.add( barry );
			
			this.add( botonProvisional );
			botonProvisional.setForeground( Color.RED );
			
			SpringLayout sp = (SpringLayout)this.getLayout();
			sp.putConstraint( SpringLayout.WEST, barry, 50, SpringLayout.WEST, this );
			sp.putConstraint( SpringLayout.NORTH, barry, 10, SpringLayout.NORTH, this);

			sp.putConstraint( SpringLayout.EAST, botonProvisional, -50, SpringLayout.EAST, this );
			sp.putConstraint( SpringLayout.NORTH, botonProvisional, 10, SpringLayout.NORTH, this);
			sp.putConstraint( SpringLayout.SOUTH, this, 15, SpringLayout.SOUTH, botonProvisional );
			
			
			
			
			System.out.println( "termina: BarrasNorte(), BarrasNorte" );
		}//fin del contructor
		
		
		public JMenuBar configBarra() {
			JMenuBar b = new JMenuBar();
			JMenu m[] = new JMenu[5];
			JMenuItem it[] = new JMenuItem[9];
			String s01[] = {
					"-ARCHIVO-",
					"-EDITAR-",
					"-VER-",
					"-HERRAMIENTAS-",
					"-USUARIO-" };
			String s02[] = {
					"item456",
					"item20",
					"item32",
					"item45",
					"item19",
					"item02153124",
					"item45",
					"itwerm",
					"itewm"};
			
			for( int j=0;j<5;j++ ) {
				m[j] = new JMenu( s01[j] );
				b.add( m[j] );
				for(int i=0;i<9;i++) {
					m[j].add( new JMenuItem( s02[i] ) );
				}//agrega a cada MENU una serie de ITEMS
			}//agrega a cada MENU una serie de ITEMS
			
			
			System.out.println( "termina: configBarra(), BarrasNorte" );
			return b;
		}//fin del metodo
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public JMenuBar getBarryta() {
			return this.barry;
		}
		public JToggleButton getBotonAxion() {
			return this.botonProvisional;
		}
		
		
		
		
	}//fin de bloque de clase

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	

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




