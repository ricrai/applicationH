package appHversion1_2;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Clase creada para ejecutar algun elemento/objeto que se esté diseñando por separado, 

public class SoloEjecuta {
	
	
	
	public static void main(String[] args) {
		
		
		/*
		Font fnt = new Font( "Arial",Font.BOLD,20 );
		String st[] = { "FORMULLARIO DE REGISTRO", 
				"Fecha de entrada: ", 
				"Hora de entrada: ", 
				"Numero de Hab: ", 
				"Vehiculo: ", 
				"Placas: ", 
				"Hora de salida: ", 
				"Importe: " };
		JTextField areaTexto[] = new JTextField[ st.length ];
		for( int i=0;i<st.length;i++ ) areaTexto[i] = new JTextField(); //inicia todo el array de arriba
		*/
		
		
		
		
		
		JFrame frm = new JFrame(  );
		frm.setBounds( 0,0,500,400 ); 
		frm.setVisible( true );
		frm.setTitle( "PROBANDO LOS FORMULARIOS" );
		
		//para hacer la llamada a este metodo estatico, se debe ya tener en un array, (obtenido desde archivos de texto) el cual contenga los nombre de los subContenidos, tambien se debe tener una array inicializado con las cajas de texto(txtField), y una fuente que estará sincronizada con lo demas(el resto de la GUI) 
		//frm.add( Formulario.hacerFormStd( st, fnt, areaTexto ) );
		
		frm.repaint();
		
	} //fin de metodo MAIN
	

} //fin de clase

