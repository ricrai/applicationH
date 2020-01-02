package appHversion1_2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
/*POSIBLES ATRIBUTOS (aun no se definen)
 * - Todo formulario debe construirse a partir de un aray de strings, el de los titulos de la "camposAYenar"
 * 
 * 
 * 
 * */




//Clase que se crea para agregar con facilidad los subcontenidos de Los Kontenidos dela aplicacion
//Un formulario es el espacio donde se solicitan ciertos datos relacionados entre si. Los textos y componentes como botones, que se ocupen para rellenar la informacion a obtener, son parte del formulario.  

public class Formulario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3760818504513777750L;

	
	
	
	
	
	
	
	
	
	
	
	public Formulario() {
		//setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
		
	} //fin del constructor sin argumentos


	
	
	
	
	
	
	
	
	//ACTUALMENTE ESTE METODO NO SE OCUPA, DMA:191219
	public static Formulario hacerFormStandar( String s[], Font fnt, JTextField jtxt[] ) { 
//Se ha intentado hacer con BoxLayout pero ha fayado
		
		//Se le pasa por parametros un array de String s[], donde s[0] es el titulo del panel en creacion, y el resto de los elementos del array, son los titulos de las etiquetas de los datosSolicitados
		//Se consideran y se deben mantener de igual largo los arrays, pero el elemento JTextArea[0] nunca se ocupara 
		
		
		Formulario f = new Formulario();
		Border b = BorderFactory.createTitledBorder( BorderFactory.createBevelBorder(2),s[0],1,1 ); // titulo del general
		int num01 = s.length; //Determina el largo del formulario, el numero de preguntas que tendra. = (tamañoDelArray -1)..  		
		Box cajaUnikVertical = Box.createVerticalBox();
		cajaUnikVertical.setBorder( b );
		f.add( cajaUnikVertical );
		Border bord = BorderFactory.createLineBorder( Color.BLACK,10,true ); //borde de cada caja horizontal
		cajaUnikVertical.add( Box.createVerticalStrut( 50 ) );
		Box cajasHoriz[] = new Box[ num01 ]; //
		JLabel j[] = new JLabel[ num01 ];
		 		
		for( int i=1;i<num01;i++ ) { //ciclo de inicializacion de las caja horizontales
				cajasHoriz[i] = new Box( BoxLayout.X_AXIS );
				j[i] = new JLabel( s[i] );
				cajasHoriz[i].add( Box.createGlue() );
				cajasHoriz[i].add( Box.createHorizontalStrut(10) );
				//JLabel j = new JLabel( s[i] );
				
				j[i].setBorder( BorderFactory.createRaisedSoftBevelBorder() );
				j[i].setLabelFor( jtxt[i] );
				cajasHoriz[i].add( j[i] );
				cajasHoriz[i].add( Box.createHorizontalGlue() );
				jtxt[i].setColumns( 10 );
				 	
				cajasHoriz[i].add( jtxt[i] );
				
				cajasHoriz[i].add( new JToggleButton("::") );
				cajasHoriz[i].add( new JButton("::") );
				cajasHoriz[i].add( new JButton("::") );
				cajasHoriz[i].setBorder( BorderFactory.createCompoundBorder( BorderFactory.createBevelBorder(1),BorderFactory.createMatteBorder( 1, 15, 1, 1, Color.BLACK ) ) );
				
				//cajasHoriz[i].setBorder( BorderFactory.createTitledBorder( bord, s[i], 0, 0, fnt, Color.BLACK) );
				//BorderFactory.createTitledBorder(border, title, titleJustification, titlePosition, titleFont, titleColor)
				cajaUnikVertical.add( cajasHoriz[i] );
				cajaUnikVertical.add( Box.createVerticalStrut(10) );
				
				/*
				if ( i==2 ) {
					anchoEt = j.getWidth(); 
					altoEt = j.getHeight();
					d = new Dimension( anchoEt, altoEt );
					System.out.println( "medidias de la etiquema mas ancha es: " +  anchoEt  +" y "+ altoEt  );
				}
				*/
				
			}//fin del for 	
	
		
		System.out.println( "El tamaño del componente mas grande es: " + j[2].getWidth() + " y " + j[2].getHeight()  );
		
		
		return f; //Regresa el objeto d tipo Formulario, heredero de JPanel
	
	} //fin de metodo estatico

	
	
	
	
	
	
	
	
	
	public static Formulario hacerFormStd01( String s[], Font fnt, JTextField txtField[] ) {

		//Hace un formulario que usando diseño de SPRINGLAYOUT construyen y acomoda los elementos que se le pasan por parametro, AUN ES BOCETO
		//Aunque podria trabajar sin necesidad de recibir ningun tipo de parametros, se le pasan esos tres elementos, ya que deben estar declarados en el codigo principal para poder referirlos en el manejo de eventos, mismo que se realiza desde la clae Ventanenado
		//Para que funcione la invocacion a este metodo, los ambosArrays que se pasan por parametro deben de ser iguales en longitud
 
		
		Formulario formu = new Formulario();
		SpringLayout sprLayout = new SpringLayout();
		Border brd = BorderFactory.createTitledBorder(( BorderFactory.createMatteBorder( 3,10,3,3, Color.red )), s[0], 3, 2, fnt, Color.RED);
		JLabel jlbl[] = new JLabel[ s.length ];
		formu.setBorder( brd ); //
		formu.setLayout( sprLayout ); //layout instaciado
		Component componenteReferencia = formu; //componente referencia va cambiando durante las iteraciones del ciclo de abajo
		Point skinaDerAbj;
		
		for ( int j=0;j<txtField.length;j++ ) {
			jlbl[j] = new JLabel( s[j] );
			txtField[j] = new JTextField( "scroto: "+j );
		} //fin del for
		
		
		
		for( int i=1;i<txtField.length;i++ ) { 
			//el ciclo NOinicia en 0, ya que el elemento 0 del arrayDeStrings ya se uso para el titulo.  
			
			txtField[i].setColumns( 15 );
			sprLayout.putConstraint( SpringLayout.NORTH,txtField[i],30,SpringLayout.NORTH,componenteReferencia ); // 30 pixeles entre NORTE del componenteReferencia y NORTE del componente anterior
			sprLayout.putConstraint( SpringLayout.NORTH,jlbl[i],31,SpringLayout.NORTH,componenteReferencia );  // 30 pixeles entre el NORTE del componenteReferencia y el NORTE de la etiqueta
			sprLayout.putConstraint( SpringLayout.WEST,txtField[i],200,SpringLayout.WEST,formu ); // 200 pixeles entre los OESTES del fomrulario y las textField
			sprLayout.putConstraint( SpringLayout.EAST,jlbl[i],-5,SpringLayout.WEST,txtField[i] ); //5 pixeles entre el ESTE de los txtFields y el ESTE de las jlabels			
			formu.add( jlbl[i] );
			formu.add( txtField[i] );
			componenteReferencia = txtField[i];
		}//fin del for
		
		skinaDerAbj = txtField[ txtField.length-1 ].getLocation();
		//Dimension tam_campotxt = txtField[ txtField.length-1 ].getSize();
	
		formu.setMinimumSize( new Dimension( skinaDerAbj.x+200 ,skinaDerAbj.y+100 ));
		formu.setSize( formu.getMinimumSize() );
		
		return formu;
	} //fin del metodo estatico 

	
	
	
	
	
	
	
	
	private String kmpos[];
	private JTextField txtFiels[];
	private int LONGI;
	public Formulario hacerFormularioStd( String s[] ) {
		
		this.LONGI = s.length-1; 
		kmpos = new String[ this.LONGI ];
		txtFiels = new JTextField[ this.LONGI ];
		setLayout( new SpringLayout() );
		for( int i=0;i<this.LONGI;i++ ) {
			kmpos[i] = s[ i+1 ];
			txtFiels[i] = new JTextField("ingrese datos....");
		} //fin del for
			
		return this;
	}//Fin del metodo hacerFormularioStandar
	
	
	
	
	
	
	
	
	
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		
		
		//Al descomentar el siguiente ciclo se dibujan tres lineas de un pixel de ancho en donde se indica
		/*
		for( int i=0;i<3;i++ ){ 
			if (i==1) {
				g.setColor( Color.BLACK );
				g.drawLine( 219,25,219,600 );	
			} else {
				g.setColor( Color.GRAY );
				g.drawLine( 218+i,25,218+i,600 );
			}
		} 
		*/
		
	} //fin del metodo PaintComponent
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------------------------------------------------
	
	private class listenerCIP implements ActionListener{ //CLASE INTERNA PRIVADA como escuchador local, de pruebas 

		public void actionPerformed( ActionEvent e ) {
			System.out.println( "Se ha desencadenado una accion en la clase interna privada" );
			
		}//fin del metodo ActionPerformed
		
	} //FIN DE Clase Interna Privada 
	
	//DECLARAR AQUI ABAJO UNA SECCION DE COMENTARIOS CONTENIENDO CLASES INTERNA ANONIMAS LISTAS PARA COPIAR Y PEGAR EN EL CODIGO DE ALGUN COMPONENTE
	
	
}
