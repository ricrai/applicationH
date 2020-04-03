package appHversion1_3;
//TODAS LAS RESTRICCIONES Y APPUNTES DE TODAS LAS RESPECTIVAS CLASES, DEBEN IR HASTA ABAJO DEL DOCUMENTO COMO UN SOLO COMENTARIO MULTILINEA


import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class BarrasNorte extends JPanel{
	
	private SpringLayout layOut = new SpringLayout();
	private JMenuBar barry = new JMenuBar();
	private JButton botonProvisional = new JButton( ">>AXION<<" );
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
//INICIALIZACION DE LOS ATRIBUTOS:
		
		this.barry = configBarra(); 
		this.add( barry );
		this.add( botonProvisional );
		
		SpringLayout sp = (SpringLayout)this.getLayout();
		sp.putConstraint( SpringLayout.WEST, barry, 50, SpringLayout.WEST, this );
		sp.putConstraint( SpringLayout.NORTH, barry, 10, SpringLayout.NORTH, this);
		//sp.putConstraint( SpringLayout.SOUTH, this, 1, SpringLayout.SOUTH, barry );

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
				"menu5",
				"menu234",
				"menu2",
				"menuasd",
				"menu324" };
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
	public JButton getBotonAxion() {
		return this.botonProvisional;
	}
	
	
	
	
}//fin de bloque de clase









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
 * */
