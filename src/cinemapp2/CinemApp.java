/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemapp2;

import java.util.*;
import java.io.*;

/**
 *
 * @author MSI PC
 */
public class CinemApp {

    /**
     * @param args the command line arguments
     */
   public static Random aleatorio = new Random(System.currentTimeMillis());
   static long tiempoInicial;
   static long tiempoFinal;
   static int datos;
   static int datosE;
    public static void main(String[] args) {
        // TODO code application logic here
tiempoInicial=System.nanoTime();
    

datos=15;
datosE=datos/2;

CineArbol cine= new CineArbol("Cinepolis");

//Creacion de datos en arbol

int a=0;
int e=0;
int i=0;
int o=0;
int u=0;

ArrayList<String> nombres= new ArrayList<String>(); 

for(int j=0;j<datos;j++){
    
    
    
    PeliAr p=new PeliAr(NombrePelicula(e,i,o,u));
    for(int q=0;q<7;q++){
        for(int w=0;w<100;w++){
            p.getHorarios()[q].ComprarSilla(NombrePersona(), w);
        }
    }
    cine.insertPeliculaClase(p);
    nombres.add(p.getNombre());

    u++;
    if(u==41){
        u=0;
        o++;
    }
    if(o==35){
        o=0;
        i++;
    }
    if(i==41){
        i=0;
        e++;
    }
    if(e==41){
        e=0;
        a++;
    }
    
}

//Eliminacion de datos en arbol
/*
aleatorio.setSeed(aleatorio.nextLong());
for(int g=0;g<datosE;g++){
    int indiceTemp=aleatorio.nextInt(nombres.size());
  
    cine.removePelicula(nombres.get(indiceTemp));
    nombres.remove(indiceTemp);
 aleatorio.setSeed(aleatorio.nextLong());
}*/

//Busqueda de dato en arbol
/*
for(int y=0;y<datosE;y++){
aleatorio.setSeed(aleatorio.nextLong());
String nombresel=nombres.get(aleatorio.nextInt(nombres.size()));
PeliAr match=cine.buscarPelicula(nombresel);
System.out.print("Nombre: ");
System.out.println(match.getNombre());
}*/

//Almacenamiento en archivo

try{
fileOut(cine);
}catch(IOException f){
    System.out.println("Fallo en la operacion");
}
/*
PrintOut(cine);
*/









/*

CineArbol cineco=new CineArbol("cinepolis");
// Interfaz de uso

boolean ingreso=false;
int tipousuario=-1;
 int count =0;
 boolean comprado=false;

Scanner interfaz= new Scanner(System.in);
      while(true){ 
while(!ingreso){

System.out.println("Presione 1 para ingresar u otro tecla para salir");
       
      char seleccion=interfaz.next().charAt(0);
       
       
       
        if(seleccion=='1'){
            count=0;
            System.out.println("Ingrese su usuario: ");
           String usuario = interfaz.next();
            System.out.println("Ingrese su clave: ");
            String clave= interfaz.next();
            if(usuario.equals("admin") && clave.equals("admin")){
                tipousuario=0;
                ingreso=true;
            }else if(usuario.equals("client") && clave.equals("client")){
                tipousuario=1;
                ingreso=true;
            }else{
                System.out.println("Usuario o clave incorrectos");
            }

        }else{
            System.exit(0);
        }    
}
 while (ingreso){
     
              
    if(tipousuario==0){
       count=0;
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        cineco.traverseInDriver();
        System.out.println("Bienvenido. Seleccione la accion a realizar");
        System.out.println("1. Insertar Pelicula");
        System.out.println("2. Buscar Pelicula");
        System.out.println("3. Eliminar Por Nombre");
        System.out.println("4. Ingresar datos desde archivo");
        System.out.println("5. Guardar datos en archivo");
        System.out.println("6. Actualizar pelicula");
        System.out.println("Otra tecla para salir");
        
        
        char seleccion= interfaz.next().charAt(0);
        switch(seleccion){
            case '1':
            
                   System.out.println("Ingresar nueva pelicula");
                System.out.println("Ingrese el nombre");
                String saltoDeLinea = interfaz.nextLine();
                String nombre=interfaz.nextLine();
                System.out.println("Ingrese el genero");
                String genero=interfaz.next();
                System.out.println("Ingrese la duracion en minutos");
                saltoDeLinea=interfaz.nextLine();
                int duracion =interfaz.nextInt();
                cineco.insertPelicula(nombre,genero,duracion);
                   System.out.println("Pelicula ingresada correctamente");
              
          try{
               detener();
          }catch(InterruptedException e ){
          }
        break;
            case '2':
                
                System.out.println("Buscar pelicula");
               if(cineco.getRoot()!=null){
                System.out.println("Ingrese el nombre");
                    saltoDeLinea=interfaz.nextLine();
                PeliAr elegida=cineco.buscarPelicula(interfaz.nextLine());
                if(elegida!=null){
                   
                    System.out.println("Se encontro la pelicula");
                    System.out.println("Genero: "+ elegida.getGenero());
                    System.out.print("Duracion: ");
                    System.out.println(elegida.getDuracion()); 
                    System.out.println("Horarios:");
                    for(int i=0;i<elegida.getHorarios().length;i++){
                        System.out.print(i+1);
                        System.out.print(". ");
                        System.out.println(elegida.getHorarios()[i].getHorario());
                    }
                    System.out.println("Presione 1 para continuar u otra tecla para salir");
                    char seleccionCom=interfaz.next().charAt(0);
                   if(seleccionCom=='1'){
                       System.out.println("Seleccione un horario para continuar:");
                    int seleccionH= interfaz.nextInt();
                    Horario h= elegida.getHorarios()[seleccionH-1];
                       System.out.println("Presione 1 para ver las sillas disponibles o 2 para ver todas las sillas");
                       int seleccionS= interfaz.nextInt();
                       if(seleccionS==2) h.MostrarTodas();
                       if(seleccionS==1) h.MostrarDisponibles();
                   }  
                }else{
                    System.out.println("No se encuentra la pelicula");
                }
               }else{
                   System.out.println("Inventario vacio"); 
               }
               try{
               detener();
          }catch(InterruptedException e ){
          }
               
               break;
            case '3':
                
                System.out.println("Eliminar por nombre");
                if(cineco.getRoot()!=null){
                System.out.println("Ingrese el nombre de la pelicula");
                saltoDeLinea=interfaz.nextLine();
                String nombre2= interfaz.nextLine();
                boolean eliminado=cineco.removePelicula(nombre2);
                if(eliminado) System.out.println("Eliminada con exito");
                else System.out.println("No se pudo eliminar");
                
                }else{
                    System.out.println("Inventario vacio");
                }
               try{
               detener();
          }catch(InterruptedException e ){
          }
               break;
          
            case '4':
             
                System.out.println("Aviso: Se eliminaran todos los datos ya existentes");
                System.out.println("Presione 1 para continuar u otra tecla para salir");
               saltoDeLinea=interfaz.nextLine();
                char eleccion=interfaz.nextLine().charAt(0);
                if(eleccion=='1'){
                cineco.setRoot(null);
                try{
                cineco=fileIn(cineco);
                }catch(IOException e){
                    System.out.println("Fallo en la operacion");
                   cineco.setRoot(null);
                }
                
                }
                try{
               detener();
          }catch(InterruptedException e ){
          }
                
                
               break;
               
            case '5':
                System.out.println("Guardar datos en archivo");
                System.out.println("Atencion: Se sobreescribira el archivo si ya existe");
                System.out.println("Presione 1 para continuar u otra tecla para salir");
                saltoDeLinea=interfaz.nextLine();
                char eleccion2=interfaz.nextLine().charAt(0);
                if(eleccion2=='1'){
                   try{
                    fileOut(cineco);
                       System.out.println("Exito en la operacion, revise el archivo");
                   }catch(IOException g){
                       System.out.println("Fallo en la operacion");
                   }
                }
                try{
               detener();
          }catch(InterruptedException e ){
          }
                break;
                
            case '6':
                System.out.println("Actualizar pelicula");
                System.out.println("Tenga en cuenta que los horarios y las compras existentes permaneceran intactas");
                System.out.println("Ingrese el nombre de la pelicula que desea actualizar u otra tecla para salir");
                saltoDeLinea=interfaz.nextLine();
                String eleccion1=interfaz.nextLine();
                PeliAr p=cineco.buscarPelicula(eleccion1);
                if(p!=null){
                 cineco.removePelicula(eleccion1);
                System.out.println("Ingrese el nuevo nombre o 0 si no desea actualizarlo");
                String nuevo=interfaz.nextLine();
                if(!nuevo.equals("0")){
                p.setNombre(nuevo);
                        }
                    System.out.println("Ingrese el nuevo genero o 0 si no desea actualizarlo");
                    String generoN=interfaz.nextLine();
                    if(!generoN.equals("0")){
                        p.setGenero(generoN);
                    }
                    System.out.println("Ingrese la nueva duracion o 0 si no desea actualizarla");
                   
                    int duracionN=Integer.parseInt(interfaz.nextLine());
                    if(duracionN!=0){
                        p.setDuracion(duracionN);
                    }
                    cineco.insertPeliculaClase(p);
                    System.out.println("Actualizacion correcta");
                }
                   try{
               detener();
          }catch(InterruptedException e ){
          }
                
                    break;
                    
            default:
                ingreso=false;
                tipousuario=-1;
                break;
        }
        
        
        
    }
    else if(tipousuario==1){
        
      
       if(cineco.getRoot()!=null){
            System.out.println("");
        System.out.println("");
        System.out.println("");
        
        cineco.traverseInDriver();
        
        System.out.println("Bienvenido. Ingrese el nombre de la pelicula que desea ver o una tecla para salir");
 
       if(count==0){
        String saltoDeLinea=interfaz.nextLine();
       }
       count++;
        

        
        PeliAr elegida=cineco.buscarPelicula(interfaz.nextLine());
        if(elegida!=null){
                    System.out.println("Se encontro la pelicula");
                    System.out.println("Genero: "+ elegida.getGenero());
                    System.out.print("Duracion: ");
                    System.out.println(elegida.getDuracion()); 
                    System.out.println("Horarios:");
                    for(int i=0;i<elegida.getHorarios().length;i++){
                        System.out.print(i+1);
                        System.out.print(". ");
                        System.out.println(elegida.getHorarios()[i].getHorario());
                    }
                    System.out.println("Presione 1 para continuar u otra tecla para salir");
                    char seleccionCom=interfaz.nextLine().charAt(0);
                   if(seleccionCom=='1'){
                       System.out.println("Seleccione un horario para continuar:");
                    char seleccionH= interfaz.nextLine().charAt(0);
                    Horario h= elegida.getHorarios()[Character.getNumericValue(seleccionH)-1];
                    h.MostrarDisponibles();
                       System.out.println("Presione 1 para comprar, 2 para cancelar compra u otra tecla para salir");
                       char seleccionS= interfaz.nextLine().charAt(0);
                       switch(seleccionS){
                           case '1':
                               System.out.println("Ingrese el codigo de la silla");
                               String codigo= interfaz.nextLine();
                               char fila=codigo.charAt(0);
                               int columna=0;
                               if(codigo.length()==3){
                                   columna=10;
                               }else{
                                    columna=Character.getNumericValue(codigo.charAt(1));
                               }
                               int numero=-1;
                               switch(fila){
                                   case 'A':
                                       numero=columna-1;
                                       break;
                                   case 'B':
                                       numero=10+columna-1;
                                       break;
                                   case 'C':
                                       numero=20+columna-1;
                                       break;
                                   case 'D':
                                       numero=30+columna-1;
                                       break;
                                   case 'E':
                                       numero=40+columna-1;
                                       break;
                                   case 'F':
                                       numero=50+columna-1;
                                       break;
                                   case 'G':
                                       numero=60+columna-1;
                                       break;
                                   case 'H':
                                       numero=70+columna-1;
                                       break;
                                   case 'I':
                                       numero=80+columna-1;
                                       break;
                                   case 'J':
                                       numero=90+columna-1;
                                       break;
                                   
                               }
                               System.out.println("Ingrese el nombre del titular");

                               h.ComprarSilla(interfaz.nextLine(), numero);
                               System.out.print("Comprado ");
                               System.out.print(h.getSillas()[numero].getFila()+" ");
                                  System.out.println(h.getSillas()[numero].getNumero());

                                 try{
                                detener();
                              }catch(InterruptedException e ){
                                  }
                                  
                                  
                                  
                                  break;
                            
                           case '2':
                               System.out.println("Ingrese el codigo de la silla");
                               String codigo2= interfaz.nextLine();
                               char fila2=codigo2.charAt(0);
                               int columna2=0;
                               if(codigo2.length()==3){
                                   columna2=10;
                               }else{
                                    columna2=Character.getNumericValue(codigo2.charAt(1));
                               }
                               int numero2=-1;
                               switch(fila2){
                                   case 'A':
                                       numero2=columna2-1;
                                       break;
                                   case 'B':
                                       numero2=10+columna2-1;
                                       break;
                                   case 'C':
                                       numero2=20+columna2-1;
                                       break;
                                   case 'D':
                                       numero2=30+columna2-1;
                                       break;
                                   case 'E':
                                       numero2=40+columna2-1;
                                       break;
                                   case 'F':
                                       numero2=50+columna2-1;
                                       break;
                                   case 'G':
                                       numero2=60+columna2-1;
                                       break;
                                   case 'H':
                                       numero2=70+columna2-1;
                                       break;
                                   case 'I':
                                       numero2=80+columna2-1;
                                       break;
                                   case 'J':
                                       numero2=90+columna2-1;
                                       break;
                                   
                               }
                              
                               h.CancelarCompra(numero2);
                               System.out.print("Cancelado ");
                               System.out.print(h.getSillas()[numero2].getFila()+" ");
                                  System.out.println(h.getSillas()[numero2].getNumero());
                                  try{
                                 detener();
                                  }catch(InterruptedException e ){
                                  }
                                  break;
                           default:

                               try{
                             detener();
                            }catch(InterruptedException e ){
                               }
                               
                               break;
                                  
                              
                       }
                   }  
        
    }else{
            ingreso=false;
            tipousuario=-1;
        }
       }else{
           System.out.println("No hay acciones disponibles");
           ingreso=false;
           tipousuario=-1;
           try{
               detener();
          }catch(InterruptedException e ){
          }
       }
    
    
    
    
    
 }

    }



      }*/


















    /*    
        
        datos=50;
        datosE=datos/2;
        
        
      
        //CREAR DATOS LINKED
        
     
        CineLinked cineco=new CineLinked();


    
 
     for(int i=0;i<datos;i++){
     boolean logrado=false;
     PeliculaLinked P=new PeliculaLinked(NombrePelicula());
     logrado=cineco.insert(P);
     
     if(logrado){
     int hora=9;
    for(int p=0;p<7;p++){
        for(int m=0;m<100;m++){
        P.BuscarHorario(hora).ComprarSilla(NombrePersona(),m);
        }
        hora=hora+2;
    }
    }
    }
     
     //MOSTRAR PELICULAS LINKED
     //cineco.print();
    
     //ELIMINAR PELICULAS POR INDICE LINKED
     
     for(int b=0;b<datosE;b++){ 
     cineco.deleteIndex(aleatorio.nextInt(cineco.getCount()));
     aleatorio.setSeed(aleatorio.nextLong());
     }
     
     
     //ELIMINAR SILLA POR SILLA DE LAS PELICULAS LINKED
     
     PeliculaLinked ptrP1=cineco.getHead();
     for(int w=0;w<10000;w++){
     HorarioLinked ptrH1=ptrP1.getHead();
     while(ptrH1!=null){
         for(int y=0;y<100;y++){
            ptrH1.CancelarCompra(y); 
         }
         ptrH1=ptrH1.getNext();
     }
     ptrP1=ptrP1.getNext();
     }
     
    
     //IMPRIMIR CADA SILLA DE LAS PELICULAS LINKED
     
     PeliculaLinked ptrP=cineco.getHead();
     int contadorP=0;
     while(ptrP!=null){
         System.out.print("Pelicula ");
         System.out.println(contadorP+1);
        HorarioLinked ptrH=ptrP.getHead();
        int contador1=0;
        while(ptrH!=null){
            System.out.print("Horario ");
            System.out.println(contador1+1);
            ptrH.MostrarTodas();
            ptrH=ptrH.getNext();
            contador1++;
        }
        ptrP=ptrP.getNext();
        contadorP++;    
     }
        
     
        
    
     
    
    // CREAR DATOS ARRAY
       
 Cine cineco=new Cine(datos);
    
 int contador=0;
      
 for(int i=0;i<datos;i++){
     boolean logrado=false;
Pelicula P=new Pelicula(NombrePelicula());
logrado=cineco.insertar(P);
if(logrado){
    contador++;
for(int u=0;u<7;u++){
    for (int o=0;o<100;o++){
        cineco.getPeliculas()[contador-1].getHorarios()[u].ComprarSilla(NombrePersona(), o);
    }
}
 }
 }
// ELIMINAR PELICULAS ARRAY

 for(int v=0;v<datosE;v++){
     cineco.eliminarIndice(aleatorio.nextInt(cineco.getCount()));
     aleatorio.setSeed(aleatorio.nextLong());
 }
 
 
 

 //MOSTRAR PELICULAS ARRAY
    
cineco.output();

   
    
    // ELIMINAR SILLA POR SILLA DE LAS PELICULAS ARRAY
    
for(int h=0;h<5000;h++){
   for(int s=0;s<7;s++){
    for (int d=0;d<100;d++){
        cineco.getPeliculas()[h].getHorarios()[s].CancelarCompra(d); 
}     
   }
}
  
    //MOSTRAR TODAS LAS SILLAS DE LAS PELICULAS ARRAY
    
int numeroP=1;

for(int i=0;i<cineco.getCount();i++){
    System.out.print("Pelicula ");
    System.out.println(numeroP);
    numeroP++;
for(int u=0;u<7;u++){
    System.out.print("Horario ");
    System.out.println(u+1);
  cineco.getPeliculas()[i].getHorarios()[u].MostrarTodas();
}
}    
  
    */
    
   
        
    System.out.print("Creacion de ");
              System.out.print(datos*700); 
                System.out.print(" datos");
                System.out.println(" e impresion en pantalla");
              //  System.out.print(datosE*700);
               // System.out.println(" datos en arboles");
   
               tiempoFinal=System.nanoTime();
    System.out.print("Tiempo de ejecucion en s: ");
    
    
   System.out.println((double)(tiempoFinal-tiempoInicial)/1000000000);
    
    
    }
   public static String NombrePersona(){
String[] Nombre={"Miguel","Nicolas","Rodrigo","Angel","Deolan","Julian","Andres","Juan","Jose","Luis","Maria","Guadalupe","Francisco","Juana","Antonio","Jesus","Pedro","Alejandro","Manuel","Margarita","Carlos","Roberto","Fernando","Daniel","Jorge","Ricardo","Eduardo","Javier","Rafael","Martin","Raul","David","Marco","Arturo","Veronica"};
//35
String[] Apellido={"Gonzales","Rodriguez","Gomez","Fernandez","Lopez","Diaz","Martines","Perez","Garcia","Sanchez","Romero","Torres","Alvarez","Ruiz","Ramirez","Florez","Benitez","Acosta","Medina","Herrera","Suarez","Aguirre","Jimenez","Gutierrez","Pereira","Rojas","Molina","Castro","Ortiz","Silva","Nunez","Cabrera","Morales","Moreno","Vera"};   
 


int intaleatorio = aleatorio.nextInt(Nombre.length);
int intaleatorio1 = aleatorio.nextInt(Nombre.length);


String resultado=Nombre[intaleatorio]+" "+Apellido[intaleatorio1];


aleatorio.setSeed(aleatorio.nextLong());


 return   resultado; 
}
 
 

public static String NombrePelicula(int e, int i, int o , int u){
     
     
     String[] Sustantivos = {"Amor","Lobo","Camino","Edificio","Elevador","Paso","Hombre","Barco","Piano","Policia","Soldado","Tigre","Leon","Coyote","Carro","Tren","Avion","Ingeniero","Doctor","Presidente","Violin","Sacerdote","Globo","Payaso","Saxofon","Nino","Motociclista","Espectro","Angel","Fotografo","Pintor","Orfanato","Abogado","Capitan","Zapato"};
     //35
     String[] Adjetivos ={"Nocturno","Esquizofrenico","Rojo","Embrujado","Millonario","Mentiroso","Asustadizo","Enamorado","Corrupto","Paraco","Mamerto","Guerrillo","Veneco","Valiente","Magico","Barato","Invisible","Genio","Malvado","Azul","Negro","Asesino","Bonito","Feo","Futbolista","Borracho","Estafador","Apostador","Sonador","Triste","Feliz","Decapitado","Creido","Marginado","Maltratado","Golpeado","Manipulado","disecado","toteado","enfriado","cocinado"};
     //41
     String[] Verbos= {"roba un","juega con","baila con","maneja un","soborna un","toca un","habla con","sana un","adora a","perrea con","mata a","come","asesina a","golpea a","llora con","trata a","chismosea con","corre con","persigue a","estudia un","muere con","cocina un","observa a","besa a","bellaquea con","conduce un","se rumbea a","hace trampa con","humilla a","dispara a","imagina a","se enamora de","abdica por","saluda a","tiene sexo con","felicita a","traiciona a","muere de amor por","sinte celos de","no puede vivir sin","termina con"};
     //41

     String resultado=Sustantivos[aleatorio.nextInt(Sustantivos.length)]+" "+Adjetivos[e]+" "+Verbos[i]+" "+Sustantivos[o]+" "+Adjetivos[u];
aleatorio.setSeed(aleatorio.nextLong());

 return   resultado; 
 
 
 
}
    
 public static void detener() throws InterruptedException {
     Thread.sleep(1000);
 }   
   public static CineArbol fileIn(CineArbol cine)throws FileNotFoundException, IOException{
       File fileIn= new File("Almacenamiento.txt");
       
       Scanner ingreso=new Scanner(fileIn);

       
       while(ingreso.hasNext()){
          String datos=ingreso.nextLine();
          Scanner sc= new Scanner(datos).useDelimiter(",");
           String nombre= sc.next();
           String genero= sc.next();
           int duracion=Integer.parseInt(sc.next());
           
           PeliAr p=new PeliAr(nombre);
           p.setDuracion(duracion);
           p.setGenero(genero);
           cine.insertPeliculaClase(p);
           
           for(int i=0;i<7;i++){
               datos=ingreso.nextLine();

               Scanner sc2=new Scanner(datos).useDelimiter(",");
               
              for(int u=0;u<100;u++){
                  String cliente=sc2.next();
                  if(!cliente.equals(" ")){
                  p.getHorarios()[i].ComprarSilla(cliente, u);
                  }
              }
           
           }
           
           
           
       }
       
     return cine;  
   } 
   
   public static void fileOut(CineArbol cine) throws IOException{
       File almacen= new File("Almacenamiento.txt");

       try{
       if(!almacen.exists()){
           almacen.createNewFile();
       }
       cine.traverseInFile(almacen);
     
       }catch(IOException e){
           System.out.println("No se pudo crear el archivo");
       }
       
   }
   public static void PrintOut(CineArbol cine){
       
       cine.traverseInPrint();
     

       
   }
   
   
   
   
}
