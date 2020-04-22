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
	
	//verificar si es bueno declarar un objeto STREAMER como atributo, compartiendo las diversas operaciones ese mismo objeto o, que en cada metodo de la clase se instancien Streamers temporales
 	//su fuerte de esta clase son los metodos static..
 	
 	
 	private String d_a_Raiz = "src/appHversion1_3/"; //siglas de DIRECCION ABSOLUTA DEL DIRECTORIO RAIZ
	private String d_r_c_Bases = "src/appHversion1_3/bases/"; //siglas de DIRECCION RELATIVA DE BASES
	private String d_r_c_AudioVisual = "src/appHversion1_3/audioVisual/"; //siglas de DIRECCION RELATIVA DE ARCHIVOS UTILIZABLES
	
 	
 	
 	
	
	public AnaLaAnalista() { //constructor sin args
	
	
	
	
		System.out.println( "termina: AnaLaAnalista(), AnaLaAnalista");
	} //fin del metodo constructor del ANALISTER

	
	
	public static void escribirEnCola( String s1, String s2 ) {
		//metodo q se le pasa por parametro la direccion de un archivo de REGISTRO, y una cadena de caracteres que se escribirá en la siguiente linea del ultimo contenido del mismo archivo, conservando lo que ya tenia
		File supuestoArchivo = new File( s1 );
		Scanner lector = null;
		Formatter escritor = null;
		try {
	
			if( supuestoArchivo.exists() ) {
				System.out.println( "Claro que existe!!!!......\n....y tiene la sig. informacion: " );
				lector = new Scanner( supuestoArchivo );
				int cont = 1;
				String nuevaLineaObtenida;
				String lineasJuntas = "";
								
				while( lector.hasNext() ) {
					nuevaLineaObtenida = lector.nextLine() + " \n";
					lineasJuntas = lineasJuntas + nuevaLineaObtenida; //en este punto del codigo, en cada ciclo se ha agregado un salto de linea por la instruccion anterior, por lo tanto cuando termine el ciclo el puntero estara en la linea siguiente del ultimo caracter que se escribio
					cont++;
				}//fin del while				
				lector.close();
				lineasJuntas = lineasJuntas + s2 + "\n";
				System.out.println( lineasJuntas + "TIENE " + (cont) + " LINEAS.............................................................................................................................................................." );
				escritor = new Formatter( supuestoArchivo );
				escritor.format( "%s",lineasJuntas );
				escritor.close();	
			}else {
				escritor = new Formatter( supuestoArchivo ); //se declara fuera del condicional ya que si o sí se usa el FORMATTER
				System.out.println( "Claro que NO existe!!!!.....\n...debe crearse..." );
				escritor.format( "se ha borrado todo el puto contenido que tenia, y en su lugar se ha escrito esta linea %d", 2 ); // escribe la cadena de caracteres en la direccion del archivo
				escritor.close();
			}//fin del if
			
		} catch ( IOException e ) {
			System.err.println( "---> PROBLEMA DE ENTRADA/SALIDA DE DATOS <---" );
			e.printStackTrace();
		} finally {
			System.out.println( "Siempre se ejecuta la clausula finally" );
			
		} //fin del manejo de excepciones

		System.out.println( "\ntermina: escribirEnCola(), AnaLaAnalista\n" );
	} //fin del metodo
	
	
	
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
		System.out.printf("%s ", valorDeRetorno ? "SI SE HA ENCONTRADO EL ARCHIVO!!":"NO SE HA ENCONTRADO EL ARCHIVO!!" );
		
		System.out.println( "termina: versieisteArchivoEnCarpeta(), AnaLaAnalista" );
		return valorDeRetorno;
	}//fin del metodo BUSCAR ARCHIVO EN LA CARPETA
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
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
 * siguele bajando krnal
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
 * ya kasi
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
 * */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	class Acontecimiento { //clase que modela la entradaDeRegistro mas basica que existe con 5 datos, de esta clase heredan otras, que son registros mas completos

		protected int fecha;
		protected int hora;
		protected String usuario;
		protected String metodo;
		protected String cod_A;
		
		public Acontecimiento( int i1, int i2, String s1, String s2, String s3 ) {
			this.fecha = i1;
			this.hora = i2;
			this.usuario = s1;
			this.metodo = s2;
			this.cod_A = s3;	
		}//fin del constructor con parametos
		
		
		
		
		public Acontecimiento() {
			this.fecha = 0;
			this.hora = 0;
			this.usuario = "inex";
			this.metodo = "inex";
			this.cod_A = "inex";	
		}//fin del constructor por defecto
		
		
		
		
		public int getFecha() {
			return this.fecha;
		}
		public void setFecha( int i ) {
			this.fecha = i;
		}
		
	}//fin de clase que modela un Acontecimiento














	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	class Informativo extends Acontecimiento {
		
		protected Acontecimiento precursorA; //este objeto contiene (5 datos) informacion en sus atributos que podemos resctar desde los metodos de esta clase heredera
		protected char tipo;
		protected String deskrp;
		protected String cod_I;
		
		
		public Informativo( Acontecimiento a, char c, String s1, String s2 ) {
			
			this.precursorA = a;
			this.tipo = c;
			this.deskrp = s1;
			this.cod_I = s2;	
		}//fin del constructor
		
		
		public Informativo() {
			this.precursorA = null;
			this.tipo = 'a';
			this.deskrp = "inex";
			this.cod_I = "inex";
		}//fin del constructor
		
	}//fin de clase que modela un Acontecimiento Informativo












































	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	class Contable extends Informativo {
		
		protected Informativo precursorI; //este objeto contiene (5 + 3 datos) informacion en sus atributos que podemos resctar desde los metodos de esta clase heredera
		protected String concepto;
		protected boolean sumaoresta;
		protected float cantidad;
		protected String cod_C;
		//este objeto contiene (5 datos) informacion en sus atributos que podemos resctar desde los metodos de esta clase heredera
		
		
		public Contable( Informativo i , String s, boolean b, float f, String c ) { //De preferencia: siempre llamar a este metodo,y no al constructor por defecto 
			this.precursorI = i;
			this.concepto = s;
			this.sumaoresta = b;
			this.cantidad = f;
			this.cod_C = c;
		}//fin del constructor con cuatro argumentos
		

		public Contable() {
			this.precursorI = null;
			this.concepto = "inex";
			this.sumaoresta = false;
			this.cantidad = 0;
			this.cod_C = "inex";
		}//fin del constructor por defecto
		
		
		
		
		
	}//fin de clase que modela un Acontecimiento Informativo Contable
	
	
	
	
	
	
	
	
	
	
	

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