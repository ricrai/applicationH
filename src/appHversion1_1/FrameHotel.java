package appHversion1_1;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import javax.swing.JFrame;

public class FrameHotel extends JFrame implements ActionListener, MouseListener{

	public final String TITULO_GRAL = "Bienvenido a la Aplicación"; 
	private final Color AZULITO_PRRON = new Color( 110,140,239 );
	Dimension tam_monitor;
	
	private JPanel panelOperaciones;

	private JPanel panelCentro;
			private JPanel panelesCentro[];
			private final Color ColoresP_Centro[] = { 
					new Color( 253,255,58 ),
					new Color( 0,191,13 ),  
					new Color( 0,255,66 ),
					new Color( 0,162,255 ),
					new Color( 0,30,255 ),
					new Color( 216,0,255 ) };
			
				private JPanel P_SubCont[][];
			private final String N_P_SubCont[][] = { 
					{ "Espacio de bienvenida", "Historial de eventos", "Tutorial de uso", "Contenido EXTRA", "", "", "", "" }, 
					{ "Reg. Flujos de efectivo", "Reg. Clientes", "Reg. Actividades", "Reg. Reportes fechados", "Imprimir registros", "Tutorial: Cómo navegar aqui", "", "" }, 
					{ "Cómo funciona INVENTARIOS", "Inventario Consumibles", "Inventario Herramientas", "", "", "", "", "" }, 
					{ "Reporte Ventas", "Reporte Gastos", "Reporte Sucesos", "Reporte para oficiales", "Nuevo tipoReporte", "Generar reporte", "Historial de reportes", "Como funcion REPORTES" }, 
					{ "Agenda Calendario", "Historial de pagos", "Prestaciones y bonos", "Recursos humanos", "Contactos y comunicaciones", "Actualizar perfiles", "Contratos", "Como funciona LABORAL"},
					{ "Configuraciones Visuales", "Apariencia por temas", "Config. Formularios", "Cómo funciona CONFIGURACIONES", "datosDelProgramaLinkDirecto", "", "", "" } };//un nombre para cada panelSubcont
			
			
		private JPanel panelIzquierda;
			private JButton botonesIzq[];
			private final String NOMB_BOTONESyPANELES[] = { 
					"Inicio", 
					"Registros", 
					"Inventarios", 
					"Reportes" , 
					"Laboral", 
					"Configuraciones" };
			private final int N1 = NOMB_BOTONESyPANELES.length;
			private final int N2 = 8;
			private final String DESCRIPCION_BOTONES[] = { 
					"boton1", 
					"boton2", 
					"boton3", 
					"boton4", 
					"boton5", 
					"boton6" };
			
		private JPanel panelArriba;
			private JMenuBar barraPrincipal;
				private JMenu menusDeBarra[];
				private JMenuItem itemsDeBarra[];
				private final String NOMS_MENUS_BARRA[] = { 
						"Archivo", 
						"Apariencia",
						"Herramientas",
						"Buscador",
						"Usuario"};
				private final String NOMS_ITEMS_BARRA[] = { 
						"Nuevo", "Normal", "Viejo", "Copiar", "Cortar", "Pegar",
						"Tamaño", "Color", "Saborr",
						"Edicion", "Tool 02",
						"Buscar", "Avanzado",
						"Cambiar Usuario", "Cerrar Sesión", "Salir de la APP"};

	
	public FrameHotel() {

		tam_monitor = Toolkit.getDefaultToolkit().getScreenSize(); 
		
		setTitle( TITULO_GRAL );		
		setBounds( 0,0, tam_monitor.width,tam_monitor.height );			
		
		panelCentro = crearPanelCen();
		panelIzquierda = crearPanelIzq();
		panelArriba = crearPanelArr();		
		
		panelOperaciones = new JPanel();
		panelOperaciones.setLayout( new BorderLayout( 20,15 ));
		panelOperaciones.setBackground( ColoresP_Centro[0] );
		panelOperaciones.add( panelArriba, BorderLayout.NORTH );
		panelOperaciones.add( panelIzquierda, BorderLayout.WEST );
		panelOperaciones.add( panelCentro, BorderLayout.CENTER );
		
		add( panelOperaciones );
		

		
		
	}

	public JPanel crearPanelCen() {
		panelesCentro = new JPanel[ N1 ];
		P_SubCont = new JPanel[ N1 ][ N2 ];
		JPanel pa = new JPanel();
		pa.setLayout( new CardLayout() );
	
		
		JScrollPane panlScroll[] = new JScrollPane[ N1 ];
		JScrollBar b_despV[]  = new JScrollBar[ N1 ];
		//JScrollBar b_despH = new JScrollBar( 0 );
		
		for( int i=0;i<N1;i++ ) {
			panelesCentro[i] = new JPanel();
		}
		
		
		for( int i=0;i<N1;i++ ) { //ESTE CICLO FOR ES EL QUE AGREGA TODOS LOS SUBCONTENIDOS--------ESTE CICLO FOR ES EL QUE AGREGA TODOS LOS SUBCONTENIDOS--------ESTE CICLO FOR ES EL QUE AGREGA TODOS LOS SUBCONTENIDOS--------
			panelesCentro[i].setLayout( new GridLayout( N2,1,5,5 ));
			panlScroll[i] = new JScrollPane( panelesCentro[i] );
			b_despV[i] = new JScrollBar( 1 );
			panelesCentro[i].setBackground( ColoresP_Centro[i] );
			panlScroll[i].add( b_despV[i] );			
			pa.add( panlScroll[i] , NOMB_BOTONESyPANELES[i] ); //lo agrega al sistema de Cartas
			System.out.println("");
			for( int j=0;j<N2;j++ ) {
				
				if( ""!=N_P_SubCont[i][j] ) {
					P_SubCont[i][j] = hacerSubPanel( i,j ); //inicializa y construye los P_subconteidos
					panelesCentro[i].add( P_SubCont[i][j] ); //agrega al panel correspondiente
					System.out.printf( "-[%d,%d]- ", i,j );
				}
				else {
					hacerSubPanel( i,j );
					System.out.printf( "-[___]- " );
				}
			}//FIN DEL FORInter
		}//Fin de FORexter
		
		pa.setBackground( ColoresP_Centro[0] );
	
		return pa;
	}//fin del metodo
	
	
	
	

	public JPanel crearPanelIzq() {
		JPanel p = new JPanel();
		Font f = new Font( "Ubuntu Condensed", Font.BOLD , 30 );
		Border b_bot = BorderFactory.createLineBorder( Color.DARK_GRAY, 5, true );
		
		int NUM_B = this.NOMB_BOTONESyPANELES.length;
		botonesIzq = new JButton[ NUM_B ];
		
		p.setLayout( new GridLayout( NUM_B,1,5,5 ) );
		p.setBackground( ColoresP_Centro[0] );
		for( int i=0;i<NUM_B;i++ ) { //inicializa y agrega los botones con su descripcion
			
			botonesIzq[i] = new JButton( NOMB_BOTONESyPANELES[i] );
			p.add( botonesIzq[i] );
			botonesIzq[i].setToolTipText( this.DESCRIPCION_BOTONES[i] );
			botonesIzq[i].setVerticalAlignment( 0 );
			botonesIzq[i].setHorizontalAlignment( 2 );
			botonesIzq[i].setFont( f );
			botonesIzq[i].setBorder( b_bot );
			botonesIzq[i].setBackground( ColoresP_Centro[i] );
			botonesIzq[i].setForeground( Color.BLACK );
			botonesIzq[i].addActionListener( this );
			
		}//fin del FOR
		
		return p;	
	}//fin del metodo
	
	public JPanel crearPanelArr() {
		JPanel p = new JPanel( new FlowLayout() );
			
		p.setBackground( ColoresP_Centro[0] );	
		p.add( crearBarra() );
				
		return p;
	}//fin del metodo
	

	
	
	
	
	public JPanel hacerSubPanel( int a, int b ) { //para construir los elementos de la matrix(n1)(n1)
		JPanel p = new JPanel( new BorderLayout() );
		
		p.setBackground( ColoresP_Centro[a] );
		Font FuentStd = new Font( "FreeMono", Font.BOLD, 30);
		TitledBorder borda = new TitledBorder( BorderFactory.createLineBorder( Color.DARK_GRAY, 10, true), "--"+this.N_P_SubCont[a][b]+"--", TitledBorder.CENTER ,TitledBorder.CENTER, FuentStd, Color.BLACK );
		p.add( new JButton("------------------"), BorderLayout.EAST );
		p.add( new JButton("------------------"), BorderLayout.WEST );
		p.setBorder( borda );
		
		switch( a ) {
		case 0: //panel que pertenece al 1boton INICIOS
			switch( b )  {
			case 0: p.add( hacerP_00(), BorderLayout.CENTER );
			break;
			case 1: p.add( hacerP_01(), BorderLayout.CENTER );
			break;
			case 2:	p.add( hacerP_02(), BorderLayout.CENTER );
			break;
			case 3: p.add( hacerP_03(), BorderLayout.CENTER );
			break;
			case 4: p.add( hacerP_04(), BorderLayout.CENTER );
			break;
			case 5: p.add( hacerP_05(), BorderLayout.CENTER );
			break;
			case 6: p.add( hacerP_06(), BorderLayout.CENTER );
			break;
			case 7: p.add( hacerP_07(), BorderLayout.CENTER );
			break;
			default:
			}//fin de swithci nterno
		break;
		case 1://panel que pertenece al 2boton REGISTROS
			switch( b )  {
			case 0: p.add( hacerP_10(), BorderLayout.CENTER );
			break;
			case 1: p.add( hacerP_11(), BorderLayout.CENTER );
			break;
			case 2:	p.add( hacerP_12(), BorderLayout.CENTER );
			break;
			case 3: p.add( hacerP_13(), BorderLayout.CENTER );
			break;
			case 4: p.add( hacerP_14(), BorderLayout.CENTER );
			break;
			case 5: p.add( hacerP_15(), BorderLayout.CENTER );
			break;
			case 6: p.add( hacerP_16(), BorderLayout.CENTER );
			break;
			case 7: p.add( hacerP_17(), BorderLayout.CENTER );
			break;
		default:
			}//fin de swithci nterno
		break;
		case 2: //panel que pertenece al 2boton  INVENTARIOS
			switch( b )  {
			case 0: p.add( hacerP_20(), BorderLayout.CENTER );
			break;
			case 1: p.add( hacerP_21(), BorderLayout.CENTER );
			break;
			case 2:	p.add( hacerP_22(), BorderLayout.CENTER );
			break;
			case 3: p.add( hacerP_23(), BorderLayout.CENTER );
			break;
			case 4: p.add( hacerP_24(), BorderLayout.CENTER );
			break;
			case 5: p.add( hacerP_25(), BorderLayout.CENTER );
			break;
			case 6: p.add( hacerP_26(), BorderLayout.CENTER );
			break;
			case 7: p.add( hacerP_27(), BorderLayout.CENTER );
			break;
			default:
			}//fin de swithci nterno
		break;
		case 3: ////panel que pertenece al 3boton REPORTES
			switch( b )  {
			case 0: p.add( hacerP_30(), BorderLayout.CENTER );
			break;
			case 1: p.add( hacerP_31(), BorderLayout.CENTER );
			break;
			case 2: p.add( hacerP_32(), BorderLayout.CENTER );
			break;
			case 3: p.add( hacerP_33(), BorderLayout.CENTER );
			break;
			case 4: p.add( hacerP_34(), BorderLayout.CENTER );
			break;
			case 5: p.add( hacerP_35(), BorderLayout.CENTER );
			break;
			case 6: p.add( hacerP_36(), BorderLayout.CENTER );
			break;
			case 7: p.add( hacerP_37(), BorderLayout.CENTER );
			break;
			default:
			}//fin de swithci nterno
		break;
		case 4: //panel que pertenece al 4boton  LABORAL
			switch( b )  {
			case 0: p.add( hacerP_40(), BorderLayout.CENTER );
			break;
			case 1: p.add( hacerP_41(), BorderLayout.CENTER );
			break;
			case 2:	p.add( hacerP_42(), BorderLayout.CENTER );
			break;
			case 3: p.add( hacerP_43(), BorderLayout.CENTER );
			break;
			case 4: p.add( hacerP_44(), BorderLayout.CENTER );
			break;
			case 5: p.add( hacerP_45(), BorderLayout.CENTER );
			break;
			case 6: p.add( hacerP_46(), BorderLayout.CENTER );
			break;
			case 7: p.add( hacerP_47(), BorderLayout.CENTER );
			break;
			default:
			}//fin de swithci nterno
		break;
		case 5: ////panel que pertenece al 5boton CONFIGURACIONES
			switch( b )  {
			case 0: p.add( hacerP_50(), BorderLayout.CENTER );
			break;
			case 1: p.add( hacerP_51(), BorderLayout.CENTER );
			break;
			case 2:	p.add( hacerP_52(), BorderLayout.CENTER );
			break;
			case 3: p.add( hacerP_53(), BorderLayout.CENTER );
			break;
			case 4: p.add( hacerP_54(), BorderLayout.CENTER );
			break;
			case 5: p.add( hacerP_55(), BorderLayout.CENTER );
			break;
			case 6: p.add( hacerP_56(), BorderLayout.CENTER );
			break;
			case 7: p.add( hacerP_57(), BorderLayout.CENTER );
			break;
			default:
			}//fin de swithci nterno
		break;
		
		}//fin SWItch externo
		
		return p;
	}
	
	public JMenuBar crearBarra() {
		//variables de bloque
		int num_menus = NOMS_MENUS_BARRA.length;
		int num_items = NOMS_ITEMS_BARRA.length;
		Border b_menu = BorderFactory.createLineBorder( Color.DARK_GRAY, 2, true );
		Font f_menu = new Font( "Ubuntu", Font.BOLD , 20 );
		Font f_item = new Font( "Ubuntu", Font.ITALIC, 20 );
		
		//inicializaciones y agregaciones
		barraPrincipal = new JMenuBar();
		menusDeBarra = new JMenu[ num_menus ];
		itemsDeBarra = new JMenuItem[ num_items ];
				
		for ( int i=0;i<num_menus;i++ ) {
			menusDeBarra[i] = new JMenu( this.NOMS_MENUS_BARRA[i] );			
			menusDeBarra[i].setBorder( b_menu );
			menusDeBarra[i].setFont( f_menu );//----------estas2
			menusDeBarra[i].setForeground( Color.DARK_GRAY );//estas2
			barraPrincipal.add( menusDeBarra[i] );
		}//fin FOR que inicia/agregar los menus

		for ( int i=0;i<num_items;i++ ) {
			itemsDeBarra[i] = new JMenuItem( this.NOMS_ITEMS_BARRA[i] );
			itemsDeBarra[i].setFont( f_item );
			itemsDeBarra[i].setForeground( Color.DARK_GRAY );
		} //for que inicializa y configura los items
		
		//agrega unox1 los items
		menusDeBarra[0].add( itemsDeBarra[0] );
		menusDeBarra[0].add( itemsDeBarra[1] );
		menusDeBarra[0].add( itemsDeBarra[2] );
		menusDeBarra[0].addSeparator();
		menusDeBarra[0].add( itemsDeBarra[3] );
		menusDeBarra[0].add( itemsDeBarra[4] );
		menusDeBarra[0].add( itemsDeBarra[5] );
		menusDeBarra[1].add( itemsDeBarra[6] );
		menusDeBarra[1].add( itemsDeBarra[7] );
		menusDeBarra[1].addSeparator();
		menusDeBarra[1].add( itemsDeBarra[8] );
		menusDeBarra[2].add( itemsDeBarra[9] );
		menusDeBarra[2].add( itemsDeBarra[10] );
		menusDeBarra[3].add( itemsDeBarra[11] );
		menusDeBarra[3].add( itemsDeBarra[12] );
		menusDeBarra[4].add( itemsDeBarra[13] );
		menusDeBarra[4].add( itemsDeBarra[14] );
		menusDeBarra[4].add( itemsDeBarra[15] );
		
		
		return barraPrincipal;
	}
	
	public void modificarF_Colores( int n1 ) {
		panelCentro.setBackground( ColoresP_Centro[ n1 ] );
		panelIzquierda.setBackground( ColoresP_Centro[ n1 ] );
		panelArriba.setBackground( ColoresP_Centro[ n1 ]);
		panelOperaciones.setBackground( ColoresP_Centro[ n1 ] );
	}

	
	
	
	public JPanel hacerP_00() {
		JPanel p = new JPanel(  ); 
		p.setLayout( new BoxLayout( p, BoxLayout.Y_AXIS) );
		Font FuentFormularios = new Font( "Arial",Font.PLAIN,20 );
		Border b= BorderFactory.createLineBorder( Color.GREEN, 4 );
		
		Box cV_0 = Box.createVerticalBox(); 
		p.add( cV_0 );
		
			Box cV_00 = Box.createVerticalBox();
			cV_00.setBorder( b );
			cV_0.add( cV_00 );
				Box cH_00 = Box.createHorizontalBox();
				cH_00.add( new JLabel("INGRESE NOMBREXD") );
				cH_00.add( new JTextField("aqui") );
				cH_00.add( new JTextField("O aqui") );
				Box cH_01 = Box.createHorizontalBox();
				cH_01.add( new JLabel("INGRESE NOMBREXD") );
				cH_01.add( new JTextField("aqui") );
				cH_01.add( new JTextField("O aqui") );
				Box cH_02 = Box.createHorizontalBox();
				cH_02.add( new JLabel("INGRESE NOMBREXD") );
				cH_02.add( new JTextField("aqui") );
				cH_02.add( new JTextField("O aqui") );
				Box cH_03 = Box.createHorizontalBox();
				cH_03.add( new JLabel("INGRESE NOMBREXD") );
				cH_03.add( new JTextField("aqui") );
				cH_03.add( new JTextField("O aqui") );
				
			cV_00.add( cH_00 );
			cV_00.add( cH_01 );
			cV_00.add( cH_02 );
			cV_00.add( cH_03 );
			
			
			
			Box cV_01 = Box.createVerticalBox();
			cV_01.setBorder( b );
			cV_0.add( cV_01 );
				Box cH_04 = Box.createHorizontalBox();
					cH_04.add(new JTextArea("dsjffhlsdkjnhvlgnksd") );
				
			cV_01.add( cH_04 );
				
			return p;
	}

	
	public JPanel hacerP_01() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_02() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_03() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_04() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_05() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_06() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_07() {
		JPanel p = new JPanel();
		
		return p;
	}
	
	
	public JPanel hacerP_10() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_11() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_12() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_13() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_14() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_15() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_16() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_17() {
		JPanel p = new JPanel();
		
		return p;
	}
	
	
	public JPanel hacerP_20() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_21() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_22() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_23() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_24() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_25() {
		JPanel p = new JPanel();
		
		return p;
	}	
	public JPanel hacerP_26() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_27() {
		JPanel p = new JPanel();
		
		return p;
	}
	
	
	
	public JPanel hacerP_30() {
		JPanel p = new JPanel();
		Dimension d_00 = new Dimension( 150,30 );
		
		JLabel etiq[] = new JLabel[100];
		for( int i=0;i<etiq.length;i++ ) {
			etiq[i] = new JLabel();
			etiq[i].setPreferredSize( d_00 );
		}
		JTextField textF[] = new JTextField[100];
		for( int i=0;i<textF.length;i++ ) {
			textF[i] = new JTextField();
			textF[i].setPreferredSize( d_00 );
		}
		
		Box CAJON = Box.createVerticalBox();
		CAJON.setBorder( BorderFactory.createLineBorder(  Color.BLUE, 6 ) );
		p.add( CAJON );
		Box caja_V[] = new Box[100];
		for( int i=0;i<caja_V.length;i++ ) {
			caja_V[i] = Box.createVerticalBox();
			caja_V[i].setBorder( BorderFactory.createLineBorder(  Color.GREEN, 4 ) );
		}
		
		Box caja_H[] = new Box[100];
		for( int i=0;i<caja_H.length;i++ ) {
			caja_H[i] = Box.createHorizontalBox();
			caja_H[i].setBorder( BorderFactory.createLineBorder(  Color.BLACK, 3 ) );
		}//inicializa y agrega marcos
		
		Box caja_V2da[] = new Box[100];
		for( int i=0;i<caja_V2da.length;i++ ) {
			caja_V2da[i] = Box.createVerticalBox();
			caja_V2da[i].setBorder( BorderFactory.createLineBorder(  Color.GREEN, 2 ));
		}
		
		etiq[0].setText( "Nunik de Movimiento " );
		etiq[1].setText( "Producto vendido" );
		etiq[2].setText( "Cantidad de Piezas" );
		etiq[3].setText( "Importe total" );
		etiq[4].setText( "A quien se le vendió" );
		etiq[5].setText( "Fecha" );
		etiq[6].setText( "Observaciones" );
		
		
		for( int i=0;i<7;i++ ) {
			caja_H[i].add( etiq[i] );
			caja_H[i].add( textF[i] );	
			caja_V[0].add( caja_H[i] );
		}
		
		CAJON.add( caja_V[0] );
	
		return p;
	}
	public JPanel hacerP_31() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_32() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_33() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_34() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_35() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_36() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_37() {
		JPanel p = new JPanel();
		
		return p;
	}
	
	
	
	public JPanel hacerP_40() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_41() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_42() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_43() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_44() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_45() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_46() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_47() {
		JPanel p = new JPanel();
		
		return p;
	}
	
	
	
	public JPanel hacerP_50() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_51() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_52() {
		JPanel p = new JPanel();
		
		return p;
	}	
	public JPanel hacerP_53() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_54() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_55() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_56() {
		JPanel p = new JPanel();
		
		return p;
	}
	public JPanel hacerP_57() {
		JPanel p = new JPanel();
		
		return p;
	}

	
	

	
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout card = ( CardLayout )( panelCentro.getLayout() );
		
		if( e.getActionCommand()==this.NOMB_BOTONESyPANELES[0] ) {
			card.show( panelCentro, this.NOMB_BOTONESyPANELES[0] );
			modificarF_Colores( 0 );
		}
		if( e.getActionCommand()==this.NOMB_BOTONESyPANELES[1] ) {
			card.show( panelCentro, this.NOMB_BOTONESyPANELES[1] );
			modificarF_Colores( 1 );
		}
		if( e.getActionCommand()==NOMB_BOTONESyPANELES[2] ) {
			card.show( panelCentro, this.NOMB_BOTONESyPANELES[2] );
			modificarF_Colores( 2 );
		}
		if( e.getActionCommand()==this.NOMB_BOTONESyPANELES[3] ) {
			card.show( panelCentro, this.NOMB_BOTONESyPANELES[3] );
			modificarF_Colores( 3 );
		}
		if( e.getActionCommand()==this.NOMB_BOTONESyPANELES[4] ) {
			card.show( panelCentro, this.NOMB_BOTONESyPANELES[4] );
			modificarF_Colores( 4 );
		}
		if( e.getActionCommand()==this.NOMB_BOTONESyPANELES[5] ) {
			card.show( panelCentro, this.NOMB_BOTONESyPANELES[5] );
			modificarF_Colores( 5 );
		}
		
	}

}


