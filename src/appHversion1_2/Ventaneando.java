package appHversion1_2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

public class Ventaneando extends JFrame implements ActionListener, MouseListener, KeyListener, ComponentListener, MenuKeyListener, ItemListener, InputMethodListener{ 
	private static final long serialVersionUID = 6187060261330937189L;
		
	
	/*
	 * 
	 * ABREVIACIONES USADAS A LO LARGO DEL CODICE
	 * 
	 * pnl = panel;
	 * bu = botones;
	 * num = numeros;
	 * nom = nombres de algo;
	 * co = colores;
	 * 
	 * 
	 * */
	
		
	private static ScheduledExecutorService timer;
	//PANELINICIO. Se encuentra inicializado en el metodo hacerBloqueoIngreso
	private static LocalTime tiempoActual;
	private String caracteresDeHr[];
	private String hrFormateada;
	private String tituloGral = "";
	public Ventaneando() { //constructor xdfkto 
				
		timer = Executors.newSingleThreadScheduledExecutor();
		final Runnable unaTarea = new Runnable() {
				public void run() {	
				tiempoActual = LocalTime.now();
				caracteresDeHr = new String[3];				
				caracteresDeHr[0] = aDosDigitos( tiempoActual.getHour() );
				caracteresDeHr[1] = aDosDigitos( tiempoActual.getMinute() );
				caracteresDeHr[2] = aDosDigitos( tiempoActual.getSecond() );
				hrFormateada = caracteresDeHr[0] + caracteresDeHr[1] + caracteresDeHr[2];
				actualizarEtiquetahr();
			  } //fin del metodo RUN

		}; //fin de la Clase Interna Anonimus
			
		timer.scheduleAtFixedRate( unaTarea, 1, 1, TimeUnit.SECONDS );
//------Clases del tiempo^^^^^^^^^^^^^--------
		
		
		
		iniciarPrecondiciones(); // establece lo mas basico para que funcione el JFRame	
		hacerblokeodIngreso(); //Agrega el primerSistema de cartas, correspondiente al ingreso de contraseñas y añade a la pila la creacion del resto de los espacios

		add( panelINICIO );
				

	} // fin de constructor
	
	
	
	
	
	
	
	//Metodo No usa ni inicializa atributos del objeto
	public String aDosDigitos( int i ) { //Usando para formatear la hora que se muestra en la parte norte del programa, metodo que convierte un entero de uno o dos digitos a una cadena de caracteres de dos elementos 
		String s;
		
		if ( i>=0 && i<10 ) s = "0" + i;
		else s = "" + i;
		
		return s;
	}
	
	
	
	
	
	
	
	
	private CardLayout cardLyt_Inicial; //Se accede a este objeto desde varios metodos del programa
	private JTextField areaT; //Se accede desde varios metodos, para comprobar si lo q el usuario escribe aqui es exactamente igual a las contraseñas y datos registrados
	private JPanel panelINICIO; //Se accede desde varios puntos del programa. y tiene distribucion CardLayout	
	private final String accionesEnBlokeo[] = { 
			"NO HACER NADA", 
			"INGRESAR" };
	public void hacerblokeodIngreso() { //hace que funcione otro sistema de cartas que se usara para el ingreso de las constraseñas, AUN ES CODIGO NODEFINITIVO
		JButton btn_accionesEnBlk[] = new JButton[ accionesEnBlokeo.length ]; // botones de 
		JPanel pnl_contra; //panel donde se ingresa la contraseña, antes de dar o no axeso al usuario
		JPanel pnl_fondo; //es el contenedor de todos los componentes de la GUI, tiene distribucion borderLayout	
		Box b = Box.createHorizontalBox();
		
		for( int i=0;i<accionesEnBlokeo.length;i++ ) btn_accionesEnBlk[i] = new JButton( accionesEnBlokeo[ i ]) ;
		
		panelINICIO = new JPanel( new CardLayout( 10,10 ));
		cardLyt_Inicial = (CardLayout)panelINICIO.getLayout();
		pnl_contra = new JPanel( new GridLayout( 4,1 ) );
		areaT = new JTextField("contraseñitis");
		pnl_contra.add( new JLabel("BIENVENIDO AL PROGRAMA, INGRESE SU CONTRASEÑA: ") );
		pnl_contra.add( areaT );
		btn_accionesEnBlk[1].addActionListener( this );
		b.add( btn_accionesEnBlk[ 0 ]);
		btn_accionesEnBlk[ 0 ].addActionListener( this );
		b.add( Box.createHorizontalStrut(100) );
		b.add( btn_accionesEnBlk[ 1 ]);
		pnl_contra.add( b );
		pnl_contra.setBackground( Color.ORANGE );
		pnl_fondo = hacerpnlFondo(); //CONSMOCONTENIDO el panel fondo se construye primero, y en su pila de llamadas los metodos se constuyen los demas panles, termina su trabajo al dejar funcionando el sistema de cartas, pero no agrega contenido interno alas Cartas
		panelINICIO.setBackground( Color.ORANGE );
		panelINICIO.add( pnl_contra, accionesEnBlokeo[0] ); //Agrega el panel de proteccion al sistema de cartas
		panelINICIO.add( pnl_fondo, accionesEnBlokeo[1] ); //Agregar el panel de cosmoKONTENIDO
		cardLyt_Inicial.show( panelINICIO , accionesEnBlokeo[0] ); 
		
	}// fin del metodo de bloqueo al ingresar.
	
	
	
	
	
	
	
	
	private JPanel pnl_N; //NORTE: tiene diseño del que sea.. solo contiene un elemento, que es la barra de menu
	private JPanel pnl_C; //CENTRO: tiene diseño de CARDLAYOUT y subContiene otro array de JScrolpane's
	private JPanel pnl_O; //OESTE: tiene diseño de GridLayout y contiene los botones, que deben estar siempre a la mano
	public JPanel hacerpnlFondo() {
		JPanel pnl = new JPanel();
		pnl.setLayout( new BorderLayout( 0,10 ) );
		pnl.setBackground( Color.ORANGE );
		pnl_O = hacerpnlO(); //oeste
		pnl_C = hacerpnlC(); //centro
		pnl_N = hacerpnlN(); //norte
		cambiarColor( azarDestino.nextInt(6) );
		pnl.add( pnl_O, BorderLayout.WEST ); //oeste
		pnl.add( pnl_C, BorderLayout.CENTER ); //centro
		pnl.add( pnl_N, BorderLayout.NORTH ); //norte
		
		return pnl;
	} //fin del metodo hacerPanelFONDO q tiene distribucion BorderLayout
	
	
	
	
	
	
	
	
	
	private JButton bu_Oeste[]; //botones pryncipales
	private Border bord_buOeste;
	private final String nom_bu_Oeste[] = { "--> INICIO <--", "--> REGISTROS <--", "--> INVENTARIOS <--",	"--> REPORTES <--", "--> LABORAL <--", "-> CONFIGURACION <-" }; //nombres que corresponden a cada boton de la lista izquierdaOeste, !!!EL LARGO DE ESTE ARRAY VA DETERMINANDO EL NUMERO DE KONTENIDO DEL PROGRAMA
	private Color co_dePaneles[][] = { //EN EL ARRAY:  [0][x]:Negro -- [1][x]:Azul -- [2][x]:Rojo -- [3][x]:Verde -- [4][x]:Cafe -- [0][5]:Violeta 
			{ new Color( 40,40,40 ), new Color( 54,54,54 ),new Color( 68,68,68 ),new Color( 82,82,82 ),new Color( 96,96,96 ),new Color( 110,110,100 ) },
			{ new Color( 3,0,75 ), new Color( 4,0,92 ), new Color( 5,0,109 ), new Color( 6,0,126 ), new Color( 7,0,143 ), new Color( 8,0,160 ) },
			{ new Color( 100,0,0 ), new Color( 124,0,0 ), new Color( 148,0,0 ), new Color( 172,0,0 ), new Color( 196,0,0 ), new Color( 220,0,0 ) },
			{ new Color( 7,50,0 ), new Color( 11,70,0 ), new Color( 14,90,0 ), new Color( 17,110,0 ), new Color( 20,130,0 ), new Color( 23,150,0 ) },
			{ new Color( 60,40,0 ), new Color( 74,50,0 ), new Color( 88,60,0 ), new Color( 102,70,0 ), new Color( 116,80,0 ), new Color( 130,90,0 ) },
			{ new Color( 32,1,62 ), new Color( 45,1,87 ), new Color( 58,1,112 ), new Color( 71,1,142 ), new Color( 84,1,167 ), new Color( 97,1,192 ) } };
	private final String nom_fuentes[] = { 
			"Ubuntu",
			"DejaVu Math TeX Gyre",
			"Liberation Mono",
			"Abyssinica SIL",
			"Phetsarath OT" };
	private static int ultimoTam; //tamaño de letra
	private static String ultimaFuent;
	public JPanel hacerpnlO() { //OESTE: tiene diseño de GridLayout y contiene los botones, que deben estar siempre a la mano
		bu_Oeste = new JButton[ NUM1 ]; //inicializa el array declarando su tamaño
		bord_buOeste = BorderFactory.createSoftBevelBorder( 1 );
		JPanel pnl = new JPanel(); //panel que sera retornado al final
		Color c1 = colorRandom(); 
		pnl.setLayout( new GridLayout( NUM1, 1 ) ); //Gridlayout de 6x1
				
		for( int i=0;i<this.NUM1;i++ ) {
			bu_Oeste[i] = new JButton( nom_bu_Oeste[i] ); //cada vuelta iniciliza un boton con Texto
			bu_Oeste[i].setBackground( co_dePaneles[5][i] ); //color del boton
			bu_Oeste[i].setForeground( c1 ); //color random
			bu_Oeste[i].setFont( new Font( nom_fuentes[4], 0, 14 ) );
			bu_Oeste[i].setBorder( bord_buOeste );
			bu_Oeste[i].addActionListener( this ); //Cada vuelta al boton antes creado le asigna Listener
			pnl.add( bu_Oeste[i] ); //Cada vuelta el boton antes creado lo agrega al panel en construccion
		} //fin del for
		
		return pnl; //regresa el panel en construccion
	} //fin del metodo hacerPanelOESTE, q tiene distribucion GridLayout 6x1
	
	
	
	
	
	
	
	
	
	private Random azarDestino;
	public Color colorRandom() { 
		Color c = null;
		azarDestino = new Random();
		int numR = 1 + azarDestino.nextInt( 3 );	
		if( numR==1 ) c = Color.WHITE;
		if( numR==2 ) c = Color.YELLOW;
		if( numR==3 ) c = Color.LIGHT_GRAY;
		
		return c;
	} //fin del metodo colorRANDOM q genera un color aleatorio entre tres opciones diferentes
	
	
	
	
	
	
	
	
	
	private CardLayout kardMain;
	private JScrollPane pnlScrol_C[]; //Los paneles, cartas miembros del mazo
	private JScrollBar barrasVert[]; //para cada boton existe un Scrollpane y para cada ScrollPane existe una barraDeDesp
	private JPanel panelDentro[];
	public JPanel hacerpnlC() {
		JPanel pnl = new JPanel(); //inicializa el panel
		pnl.setLayout( new CardLayout( 30,30 )); //configura el modo de cartas
		kardMain = (CardLayout)(pnl.getLayout());
		pnlScrol_C = new JScrollPane[ NUM1 ];
		panelDentro = new JPanel[ NUM1 ];
		barrasVert = new JScrollBar[ NUM1 ];
		
		for( int i=0;i<NUM1;i++ ) {
			panelDentro[i] = new JPanel( new SpringLayout() );
			panelDentro[i].setBackground( Color.LIGHT_GRAY );
			barrasVert[i] = new JScrollBar( JScrollBar.VERTICAL );
			pnlScrol_C[i] = new JScrollPane( panelDentro[i], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER ); //inicializa el array de ScrolPanes mostrando el contenido de la caja b[i]
			pnlScrol_C[i].add( barrasVert[i] );
//			pnlScrol_C[i].createVerticalScrollBar(); //hace una barradDesp Vertical para el panel
	//		pnlScrol_C[i].setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ); //establece politica de la barra
			pnl.add( pnlScrol_C[i], nom_bu_Oeste[i] ); //agrega al sistema de cartas con los nombre respectivos
		} //fin del for
		
		
		
		
		
		//----------temprueba-----------------------------------------------------
			
		String s00[] = { "FORMULARIO DE PRUEBa", "piola", "polola", "koala", "malala", "etc","piola", "polola", "koala", "malala", "etc","piola", "polola", "koala", "malala", "etc","piola", "polola", "koala", "malala", "etc" };
		JTextField tf[] = new JTextField[ s00.length ];
		
		for( int i=0;i<s00.length;i++ ) tf[i] = new JTextField();
		
		Font fuentexx = new Font( "Arial",Font.BOLD,20 );
		Formulario fp = Formulario.hacerFormStd01( s00,fuentexx,tf );
		panelDentro[0].add( fp );
		fp.setSize( fp.getMinimumSize() );
		SpringLayout sprlyt = ( SpringLayout )( panelDentro[0].getLayout() );
		Spring spr = Spring.constant( 10,50,250 );
		sprlyt.putConstraint( SpringLayout.WEST,fp,50,SpringLayout.WEST,panelDentro[0] );
		sprlyt.putConstraint( SpringLayout.EAST,panelDentro[0],50,SpringLayout.EAST,fp );
		sprlyt.putConstraint( SpringLayout.NORTH,fp,10,SpringLayout.NORTH,panelDentro[0] );
		sprlyt.putConstraint( SpringLayout.SOUTH,panelDentro[0],10,SpringLayout.SOUTH,fp );
		
		//--------------temprueba-------------------------------------------------		
		
		
		
		kardMain.show( pnl,nom_bu_Oeste[0] ); //muestra el primer elemento delas Cartas
		return pnl;
	} //fin del metodo hacerPanelCENTRO q tiene una distribucion CardLayout
	
	
	
	
	
	
	
	
	private Border bord_Nort;
	private Border bord_MenuBar;
	private JMenuBar barraMenu; //La barra de menu muestra N contenidos siempre visibles: 		||| elem1 || elem2 || elem3 || elem4 || elem51 ||| cada uno despliega un submenu
	private JMenu elementosAlaVista[]; //empezando con 5 elementos vistos, solo el primero tiene submenus
	private JMenu delElem1[]; //corresponde a: CAMBIARAPARIENCIA tiene 3 opciones consistentes en: cambiarLetra, cambiarTamaño, cambiarColores
	private final String nom_delElem1[] = { 
			"Tipo de Letra", 
			"Tamaño de letra", 
			"Colores" } ;
	private JMenuItem opc_delElem1[]; // [16] =  cambiartipoL(5) + cambiarTamaL(5) + cambiarColor(7);
	private final String nom_opcDelElem1[] = { 
			"1)Ubuntu", 
			"2)DejaVu", 
			"3)Liberation", 
			"4)Abyssinica", 
			"5)Phetsarath", 
			"10 = Minima", 
			"12 = Pequeña", 
			"14 = Mediana", 
			"16 = Grande", 
			"18 = Maxima", 
			"1-Negro", 
			"2-Azul", 
			"3-Rojo", 
			"4-Verde", 
			"5-Cafe",  
			"6-Violeta" } ; //Array de cadenas que contiene los nombres de todos los items de la pestanha #1 de la barra de menu . [1/6]
	private final String nom_elemAlavista[] = { 
			"Cambiar Apariencia", 
			"JMenu2", 
			"Menu3",
			" Cuarto menu",
			"Salir...." } ; //Textos que se muestran en las pestanhas de cada elemento de la barra de menu
	private Box caja00v;
	private Box caja01v;
	private Box caja02v;
	private JLabel lab[];
	public JPanel hacerpnlN() {
		JPanel pnl = new JPanel();
		bord_Nort = BorderFactory.createLineBorder( Color.LIGHT_GRAY , 3, true );
		bord_MenuBar = BorderFactory.createBevelBorder(1);
		pnl.setLayout( new BoxLayout( pnl, BoxLayout.Y_AXIS ) );
		Box caja00 = Box.createHorizontalBox();
		barraMenu = new JMenuBar();
		elementosAlaVista = new JMenu[5]; //establecido 5 asi de huevos, el primero es de apariencia 
		delElem1 = new JMenu[3]; //cambiarTipo cambiarTam cambiarColor
		opc_delElem1 = new JMenuItem[16]; // 5,5,7
		
		for( int i=0;i<elementosAlaVista.length;i++ ) {
			elementosAlaVista[i] = new JMenu( nom_elemAlavista[i] ); //inicializa la primera rama de elementos del BarraMenu
			elementosAlaVista[i].setBorder( bord_MenuBar );
			barraMenu.add( elementosAlaVista[i] );
		}
		
		for( int i=0;i<delElem1.length;i++ ) {
			delElem1[i] = new JMenu( nom_delElem1[i] );
			elementosAlaVista[0].add( delElem1[i] );
		}
		
		for ( int i=0;i<this.nom_opcDelElem1.length;i++ ) {
			opc_delElem1[i] = new JMenuItem( nom_opcDelElem1[i] );
		}
		
		hacer_elem1_( 0 );
		hacer_elem1_( 1 );
		hacer_elem1_( 2 );
		caja00.setAlignmentX( RIGHT_ALIGNMENT );
			caja00v = Box.createVerticalBox();
			caja01v = Box.createVerticalBox();
			caja02v = Box.createVerticalBox();
			lab = new JLabel[3];
			lab[0] = new JLabel( "Fecha:\t\t " + LocalDate.now() );
			lab[1] = new JLabel( "Hora:	\t\t" + hrFormateada );
			lab[2] = new JLabel( "Otro" );
			caja00v.add( lab[0] );
			caja00v.add( lab[1] );
			caja00v.add( lab[2] );
			caja02v.add( barraMenu );
			caja01v.add( new JTextArea( "EN DESARROLLO\nCOMPONENTE PROVISIONAL\nDATOS DEL USUARIO ACTUAL",1,1 ) ); //quiza se agrege aqui un pequeño tipo de formulario
			caja00v.setBorder( bord_Nort );
			caja01v.setBorder( bord_Nort );
			caja02v.setBorder( bord_Nort );
		
		caja00.add( caja00v );
		caja00.add( Box.createHorizontalGlue() );
		caja00.add( Box.createHorizontalStrut(20) );
		caja00.add( caja01v );
		caja00.add( Box.createHorizontalStrut(20) );
		caja00.add( caja02v );
		pnl.add( caja00 );
		
		return pnl;
	} //fin del metodo hacerPanelNORTE q tiene distribucion BoxLayout
	
	
	
	
	
	
	
	
	//lab[] Se inicializa en el metodo "hacerPanelNorte"
	public void actualizarEtiquetahr () {
		String ora = "" + hrFormateada.charAt(0) + hrFormateada.charAt(1) + ":" + hrFormateada.charAt(2) + hrFormateada.charAt(3) + ":" + hrFormateada.charAt(4) + hrFormateada.charAt(5);
		lab[0].setText( "Fecha:  [" + LocalDate.now() + "]" );
		lab[1].setText( "Hora:    [  " + ora + "  ]");
		lab[2].setText( "Clima:"  );	
	} //fin del metodo actualizarEtiqueta
	
	
	
	
	
	
	//opc_delElem[]. Se encuentra declarado en el metodo ____
	//delElem1[]. Se encuentra declarado en el metodo_____
	public void hacer_elem1_( int i ) {
		if( i==0 ) {
			delElem1[i].add( opc_delElem1[0] );
			opc_delElem1[0].addActionListener( this );
			delElem1[i].add( opc_delElem1[1] );
			opc_delElem1[1].addActionListener( this );
			delElem1[i].add( opc_delElem1[2] );
			opc_delElem1[2].addActionListener( this );
			delElem1[i].add( opc_delElem1[3] );
			opc_delElem1[3].addActionListener( this );
			delElem1[i].add( opc_delElem1[4] );
			opc_delElem1[4].addActionListener( this );		
		}
		else if ( i==1 ) {
			delElem1[i].add( opc_delElem1[5] );
			opc_delElem1[5].addActionListener( this );
			delElem1[i].add( opc_delElem1[6] );
			opc_delElem1[6].addActionListener( this );
			delElem1[i].add( opc_delElem1[7] );
			opc_delElem1[7].addActionListener( this );
			delElem1[i].add( opc_delElem1[8] );
			opc_delElem1[8].addActionListener( this );
			delElem1[i].add( opc_delElem1[9] );
			opc_delElem1[9].addActionListener( this );	
		}
		else if ( i==2 ) {
			delElem1[i].add( opc_delElem1[10] );
			opc_delElem1[10].addActionListener( this );
			delElem1[i].add( opc_delElem1[11] );
			opc_delElem1[11].addActionListener( this );
			delElem1[i].add( opc_delElem1[12] );
			opc_delElem1[12].addActionListener( this );
			delElem1[i].add( opc_delElem1[13] );
			opc_delElem1[13].addActionListener( this );
			delElem1[i].add( opc_delElem1[14] );
			opc_delElem1[14].addActionListener( this );
			delElem1[i].add( opc_delElem1[15] );		
			opc_delElem1[15].addActionListener( this );
		}
		
	}//fin del metodo hacerElemento1
	
	
	
	
	
	
	//ultimaFuent. Se encuentra declarado en el metodo_____
	//UltimoTamaño. Se encuentra declarado en el metodo ______
	//tituloGral. Se encuentra declarado en el metodo ______
	//tituloGeneral. Se encuentra declarado en el metodo _______
	//nom_fuentes[]. Se encuentra declarado en el metodo _________
	public void iniciarPrecondiciones() { 
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 50,50,1000,500 );
		setVisible( true );
		setTitle( tituloGral );
		ultimaFuent = nom_fuentes[4];
		ultimoTam = 16;
	} //fin del metodo iniciarPrecondiciones
	
	
	
	
	
	
	
	
	public String getTituloGral() {
		return tituloGral;
	}
	public void setTituloGral( String s ) { //Al establecer o restablecer el titulo de la ventana se debe actualizar el ATRIBUTO, y usar el metodo SETTITLE 
		this.tituloGral = s;
		this.setTitle( s );
	}
	
	
	
	
	
	
	public String getHrFormateada() {
		return hrFormateada;
	} // la Hora actual no puede reEstablecerse
	
	
	
	
	
	
	//nom_bu_Oeste[]. Se encuentra declarado en el metodo _________
	//bu_Oeste[]. Se encuentra declarado en el metodo _________
	//pnl_C. Se encuentra declarado en el metodo ______
	//pnl_O. Se encuentra declarado en el metodo ______
	public void cambiarColor( int i ) {//EN EL ARRAY:  [0][x]:Negro -- [1][x]:Azul -- [2][x]:Rojo -- [3][x]:Verde -- [4][x]:Cafe -- [0][5]:Violeta
		
		for( int j=0;j<nom_bu_Oeste.length;j++ ) {
			bu_Oeste[j].setBackground( co_dePaneles[i][j] );
		}
		
		pnl_C.setBackground( bu_Oeste[0].getBackground() );
		pnl_O.setBackground( bu_Oeste[0].getBackground() );
	} //fin del metodo cambiarColor
	
	
	
	
	
	
	
	//ultimaFuent. Se encuentra declarado en el metodo_____
	//UltimoTamaño. Se encuentra declarado en el metodo ______
	//tituloGral. Se encuentra declarado en el metodo ______
	public Font cambiarFyT( String st, int tam ) {
		ultimaFuent = st; //Actualiza las variables statiks
		ultimoTam = tam;
		int suma = Font.TRUETYPE_FONT;
		Font fnt = new Font( st, suma ,tam);		
		
		for( int j=0;j<NUM1;j++ ) bu_Oeste[j].setFont( fnt );
		
		return fnt;
	} //Fin del metodo CambiarFuenteyTamaño
	
	
	
	
	
	
	
	//kardMain. Se encuentra declarado en el metodo _____
	//pnl_C Se encuentra declarado en el metodo _____
	//pnl_O Se encuentra declarado en el metodo _____
	//nom_bu_Oeste[]. Se encuentra declarado en el metodo _____
	public void cambiarKontenido( int i ) { 
		kardMain.show( pnl_C,nom_bu_Oeste[i] ); //el LayoutManager "barajea" las cartas del panelCentro (pnl_c)
		pnl_C.setBackground( bu_Oeste[i].getBackground() ); //cambia el colo de fondo del panel central
		pnl_O.setBackground( bu_Oeste[i].getBackground() ); 
		System.out.println( "La hora es: " + getHrFormateada() );
	}//fin del metodo cambiarContenido
	
	
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////METODOS DE ESCUCHADORES LISTENER ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-------------------------------------------meto2 de interfaces---------->>>>----------------------------------------------------------------------------------------------------------------------------
	
	
	public void actionPerformed( ActionEvent e ) {
		
		String s = areaT.getText() + "     ";
		String c = "contra" + "     ";

		System.out.println( "El boton oprimido es: " + e.getActionCommand() + "\n\n");
		
		if( e.getActionCommand()==nom_bu_Oeste[0] ) cambiarKontenido( 0 );
		if( e.getActionCommand()==nom_bu_Oeste[1] ) cambiarKontenido( 1 );
		if( e.getActionCommand()==nom_bu_Oeste[2] ) cambiarKontenido( 2 );
		if( e.getActionCommand()==nom_bu_Oeste[3] ) cambiarKontenido( 3 );
		if( e.getActionCommand()==nom_bu_Oeste[4] ) cambiarKontenido( 4 );
		if( e.getActionCommand()==nom_bu_Oeste[5] ) cambiarKontenido( 5 );
		
		if( e.getActionCommand()==accionesEnBlokeo[0] )	;
		if( e.getActionCommand()==accionesEnBlokeo[1] ) { 	
			if ( s.charAt(0)==c.charAt(0)&&s.charAt(1)==c.charAt(1)&&s.charAt(2)==c.charAt(2)&&s.charAt(3)==c.charAt(3)&&s.charAt(4)==c.charAt(4) ) cardLyt_Inicial.show( panelINICIO, accionesEnBlokeo[1] );
			else System.out.println( "La contraseña no coincide" ); 
		}
				
		if( e.getActionCommand()==nom_opcDelElem1[0] ) cambiarFyT( nom_fuentes[0], ultimoTam );
		if( e.getActionCommand()==nom_opcDelElem1[1] ) cambiarFyT( nom_fuentes[1], ultimoTam );
		if( e.getActionCommand()==nom_opcDelElem1[2] ) cambiarFyT( nom_fuentes[2], ultimoTam );
		if( e.getActionCommand()==nom_opcDelElem1[3] ) cambiarFyT( nom_fuentes[3], ultimoTam );
		if( e.getActionCommand()==nom_opcDelElem1[4] ) cambiarFyT( nom_fuentes[4], ultimoTam );
		if( e.getActionCommand()==nom_opcDelElem1[5] ) cambiarFyT( ultimaFuent, 12 );
		if( e.getActionCommand()==nom_opcDelElem1[6] ) cambiarFyT( ultimaFuent, 14 );
		if( e.getActionCommand()==nom_opcDelElem1[7] ) cambiarFyT( ultimaFuent, 16 );
		if( e.getActionCommand()==nom_opcDelElem1[8] ) cambiarFyT( ultimaFuent, 18 );
		if( e.getActionCommand()==nom_opcDelElem1[9] ) cambiarFyT( ultimaFuent, 20 );		
		if( e.getActionCommand()==nom_opcDelElem1[10] ) cambiarColor( 0 );
		if( e.getActionCommand()==nom_opcDelElem1[11] ) cambiarColor( 1 ); 
		if( e.getActionCommand()==nom_opcDelElem1[12] ) cambiarColor( 2 ); 
		if( e.getActionCommand()==nom_opcDelElem1[13] ) cambiarColor( 3 ); 
		if( e.getActionCommand()==nom_opcDelElem1[14] ) cambiarColor( 4 ); 
		if( e.getActionCommand()==nom_opcDelElem1[15] ) cambiarColor( 5 );
		
	}//fin de ACTIONPERFORMED


	public void mouseClicked( MouseEvent e ) {
		
	}


	public void mouseEntered( MouseEvent e ) {
		
	}


	public void mouseExited( MouseEvent e ) {

		
	}


	public void mousePressed( MouseEvent e ) {

		
	}


	public void mouseReleased( MouseEvent e ) {

		
	}


	public void keyPressed( KeyEvent e ) {

		
	}

	public void keyReleased( KeyEvent e ) {
		
	}


	public void keyTyped( KeyEvent e ) {
		
	}


	public void componentHidden( ComponentEvent e ) {

		
	}



	public void componentMoved( ComponentEvent e ) {
		
	}



	public void componentResized( ComponentEvent e ) {
		
	}


	public void componentShown( ComponentEvent e ) {

		 
	}



	public void menuKeyPressed( MenuKeyEvent e ) {
		System.out.println( e.getSource() );
		
	}


	public void menuKeyReleased( MenuKeyEvent e ) {
		
	}



	public void menuKeyTyped( MenuKeyEvent e ) {

		
	}


	
	public void itemStateChanged( ItemEvent e ) {

		
	}


	public void caretPositionChanged( InputMethodEvent e ) {

		
	}



	public void inputMethodTextChanged( InputMethodEvent e ) {
		
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	//ENUMERACIONES INFORMALES:
	private final int NUM1 = this.nom_bu_Oeste.length; //Cumpliendo la regla, para cada boton de la izquierda una carta se tiene en el sistema de CardLayout
	
	
	
	
	
}//FIN DE TODO EL CODIGO DE ESTE DOCUMENTO













//-----------------------COMENTARIOS------------e---------------------------------------COMENTARIOS---------------------------------------------------COMENTARIOS----------------------------
// El programa se enfoca en todos? los formularios mediante los que el usuario ingrese los datos, y NO se desenfocará hasta que el usuario termine rellenar dicho formulario
// Para log	rar ser mas intuitivo se usaran colores y Simbolos
// Esta clase contiene todos los Listener que se ocuparan, y sus metodos deben estar en contacto directo con la asistenteRITMAH 
