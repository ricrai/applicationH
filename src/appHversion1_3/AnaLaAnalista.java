package appHversion1_3;
//TODAS LAS RESTRICCIONES Y APPUNTES DE TODAS LAS RESPECTIVAS CLASES, DEBEN IR HASTA ABAJO DEL DOCUMENTO COMO UN SOLO COMENTARIO MULTILINEA

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;






public class AnaLaAnalista {
	
	private String descripcionxD = "";
 	private String nomb_direxMadre = "/home/omnitr3x3000/git/AppHotelByrat/src/appHversion1_3/"; // la direccion de la carpeta donde se encuntran guardadas todos los archivos .java, como ruta absoluta en mi sistemas de linux
 	private String nomb_direxMadreRelativo = "src/appHversion1_3/"; //relativo a la carpeta del proyecto, misma donde se aloja el repositorio
	//verificar si es bueno declarar un objeto STREAMER como atributo, compartiendo las diversas operaciones ese mismo objeto o, que en cada metodo de la clase se instancien Streamers temporales
 	
	
	public AnaLaAnalista() { //constructor sin args
	
	
	
	
		System.out.println( "termina: AnaLaAnalista(), AnaLaAnalista");
	} //fin del metodo constructor del ANALISTER

	
	
	public boolean esArbolante( String s ) { //metodo al que pasandole la ruta absoluta o relativa, devuelve TRUE si el archivo da origen a un arbol.... si el archivo no existe el manejador de excepciones hace lo propio
		boolean laNtflx = intentarXCharStreams( s );
		/*PSEUDOCODIGO DEL METODO:
		 *1- Verificar que exista el archivo que se pasa como cadena de caracteres,
		 *2- Imprimir el archivo en pantalla,
		 *3- Imprimir cuantas lineas tiene,
		 *4- Imprimir el primer caracter de cada linea, excepto si es lineaVacia,
		 *5- Contar cuantas veces se imprimio cada numero y externarlo por consola,
		 *6- Externar por consola cuantos elementos de grado uno tiene el arbol 
		 * FIN
		 * 
		 * */
		
		
		System.out.println( "termina: esArbolante(), AnaLaAnalista" );
		return laNtflx;
	}//fin del metodo boolean esArbolante?
	
	
	
	public boolean intentarXCharStreams( String s ) { //se intenta que al convocar este metodo en algun lugar se verifique su existencia y se copie el contenido del archivo
		File archiX = null;
		FileReader fr = null;
		Boolean binar = false;
		int conteoDeLns = 0;
		
		try {
			archiX = new File( s ); //in bloque TRY
			fr = new FileReader( s );  //in bloque TRY
			
			
			obtenerArraysdStr( archiX );
	
			

			int anterior_Aski = 0;
			int char_Aski = 0;

			while(( char_Aski=fr.read() )!=-1 ) { //la instruccion: fr.read, hace el trabajo de leer caracter x caracter el archivo de texto, y guardar su equivalente en ASCII en la variable tipoEntero, para luego escribir en el archivo nuevo el propio caracter

				if( (char)(char_Aski)=='\n' ) { //entra en el condicional si el caracter leido es diferente q salto de linea
					if( (char)(anterior_Aski)=='\n' ) {
						//hacer nada
					}else {
						conteoDeLns++;
					}//fin del else-IF
				}//fin de IF
				
				anterior_Aski = char_Aski;
			}//fin del ciclo while
			System.out.println( "\n\n\nSE HAN CONTADO: " + conteoDeLns + " LINEAS DE TEXTO EFECTIVO\n\n" );
			
		} catch( IOException e ) {
		
			System.err.println( "SE DESENKDENADO UNA EXCEPCION, no leyo bien... " + e.toString() + " akitermina el bloque catch" );
			e.printStackTrace();
		
		} finally {
			
			if( fr!=null ) {
				try {
					fr.close();
				} catch (IOException e) {
					System.err.println( "OTRRA ESEPCION... no pudo cerrar adecuadamente" );
					e.printStackTrace();
				}//fin de try/catch
			}//fin IF
			
		}//fin del bloque finally
		
		
		
		System.out.println( "termina: intentarXCharStreams(), AnaLaAnalista" );
		return binar;
	}//fin del metodo intentarArchivoxFlujodeChar

	
	
	public String[] obtenerArraysdStr( File f ) {
		String cadenasRetrn[] = { "" };
		BufferedReader bufRd = null;
		PrintWriter printWr = null;
		int lrg = f.getName().length(); 
		
		if( f.exists() ) {
			System.out.println( "EL ARCHIVO SI EXISTE... CONTINUAMOS\n\n..." );
			System.out.println( "y su nombre es: " + f.getName() );
			System.out.println( "La longitud del nombre es: " + lrg + " caracteres.\n\n" );
		
			
			if( (f.getName().charAt(lrg-4))=='.'&&(f.getName().charAt(lrg-3))=='t'&&(f.getName().charAt(lrg-2))=='x'&&(f.getName().charAt(lrg-1))=='t' ) {
				System.out.println("EL ARCHIVO ES DE TYPO TXT..... CONTINUAMOS...\n\n\n");
				
				try {
					bufRd = new BufferedReader( new FileReader(f) );
					printWr = new PrintWriter( new FileWriter( "src/appHversion1_3/nuevoDocAutocreado.txt" ) );
					String linea = "";
					char conNums[] = null;
					char sinNums[] = null;
					
					
					while( (linea=bufRd.readLine())!=null ) {

						if( linea.length()<=1 ) {
							//cuando la linea no tiene caracteres se omite hacer algo
						}else { //entrar en el bloque de ELSE implica que no está vacia la linea
							int contIterador = 0;
							int contdPts = 0;
							
							while( linea.charAt( contIterador )!='-' ) { 
								if( linea.charAt( contIterador )=='.' ) {
									contdPts++;
								}
								contIterador++;
								conNums = linea.toCharArray();

							}//fin del while
							
									
							if( contdPts==0 ) {
								System.out.print("\n");
								for( int i=0;i<linea.length()-2;i++ ) {
									sinNums = new char[linea.length()-2];
									sinNums[i] = conNums[i+2];
									System.out.print( sinNums[i] );
									printWr.println( sinNums[i] );
								}//fin del for
								System.out.println("");
								printWr.println( '\n' );
							} //fin del IF
							if( contdPts==1 ) {
								System.out.print("\t");
								for( int i=0;i<linea.length()-4;i++ ) {
									sinNums = new char[linea.length()-4];
									sinNums[i] = conNums[i+4];
									System.out.print( sinNums[i] );
									printWr.println( sinNums[i] );
								}//fin del for
								System.out.println("");
								printWr.println( '\n' );
							}//fin del IF
							
						}//fin del ELSE
					}//fin del wile
					System.out.println( "\n\n\n\n\n" );

					
				} catch ( IOException e ) {	
					System.err.println("NO SE HA PODIDO ABRIR EL BUFFEREDREADER");
					e.printStackTrace();
				} //fin del try Catch
				
				
				
			}else {
				System.out.println( "NOES UN DOC DE TEXTO" );
			}//fin del IF-ELSE
			
		}else {
			System.out.println( "NO EXISTE" );
		}//fin del IF-ELSE
		

		
		System.out.println( "termina: obtenerArraysdStr(), AnaLaAnalista" );
		return cadenasRetrn;
	}//fin del metodo ObtenerArrays de un archivo

	
	
	
	
	
	
	
	public static boolean intentarCrearArchivoBlanko( String s ) { //recibe por parametro EL PURITITO NOMBRE del archivo, considerar si se está usando ruta absoluta o relativa 
		boolean valDeRet = false;
		String direccionAbsolutaLinux = "/home/omnitr3x3000/git/AppHotelByrat/src/appHversion1_3/" + s; //direccion referente al directorio RAIZ, del archivo en kuestion
		Formatter salida = null;
		
		try {
			salida = new Formatter( direccionAbsolutaLinux );
			System.out.println( "Se ha construido correctamente el objeto FORMATTER" );
			
		} catch ( FileNotFoundException e ) {
			System.err.println("esepxion de Archivo no encontrado");
			e.printStackTrace();
		} catch ( SecurityException e ){
			System.err.println("esepxion de q no tienes axeso");
			e.printStackTrace();
		}//fin del bloque TRY-Catch
		
		System.out.println( "termina: intentarCrearArchivoBlanko(), AnaLaAnalista" );
		return valDeRet;
	} //fin del metodo 
	 
	
	
	
	
	public static boolean versiexisteArchivoEnCarpeta( String s ) { // metodo que verifica que no exista ya un archivo con el nombre que se manda por parametro en la carpetaMadre
		boolean valorDeRetorno = false;
		String carpMadreDirAbs = "/home/omnitr3x3000/git/AppHotelByrat/src/appHversion1_3/"; //direccion absoluta de la carpeta madre
		File supuestoArchi = new File( carpMadreDirAbs + s );

		valorDeRetorno = supuestoArchi.exists();
		System.out.printf("%s ", supuestoArchi.exists()? "SI SE HA ENCONTRADO EL ARCHIVO!!":"NO SE HA ENCONTRADO EL ARCHIVO!!" );
		
		
		System.out.println( "termina: versieisteArchivoEnCarpeta(), AnaLaAnalista" );
		return valorDeRetorno;
	}//fin del metodo BUSCAR ARCHIVO EN LA CARPETAic static boolean intentarCrearArchivoBlanko( String s ) { //recibe por parametro EL PURITITO NOMBRE del archivo, considerar si se está usando ruta absoluta o relativa 
	
	
	

	
	
	

} //fin del codigo de la clase ANALISTER









/*COMENTARIOS Y RESTRICCIONES 
 * *************************************************************
 * * * * * RGxx = restriccion general = "todas las clases deben seguir esta restriccion"
 * * * * * Rxx = restriccion = "algun apunte que se debe atender antes de considerar terminado el codigo de esta clase ANA LA ANALISTA" 
 * *************************************************************
 * 
 * RG01: Todas las impresiones en pantalla son anuncios de cómo se va a ejecutando el codigo, son mensajes para orientacion del programador 
 * RG02: Los mensajes para orientar al usuario apareceran en un objetoGrafico, debidamente señalizados (jlabel, jpanel, etc. )
 * RG03: No configurar los atributos, o los miembros de los atributos desde las clases superiores
 * 
 * *
 * * R01: Este analister debe de contener un metodo BOOL que verifique las formalidades de cada documento de texto que aspire a ser Arbolante
 * * 
 * *
 * *
 * *
 * *
 * *
 * *
 * *
 * *
 * *
 * */