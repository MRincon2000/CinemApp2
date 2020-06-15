/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemapp2;
import java.io.*;
/**
 *
 * @author MSI PC
 */
public class CineArbol {
    private CineArbol next;
     private PeliAr root;
     int count=0;
     boolean elimination=false;
     private String nombre;
public CineArbol(String nombre) {
this.root = null;
this.nombre = nombre;
this.next= null;
}

public void insertPelicula(String nombre, String genero, int duracion) {
root = insert(nombre,genero, duracion,root);
}
private PeliAr insert(String nombre,String genero, int duracion, PeliAr p) {
if(p == null){
p = new PeliAr(nombre);
p.setDuracion(duracion);
p.setGenero(genero);
}else
if(nombre.compareTo(p.getNombre())<0)
p.setLeft(insert(nombre,genero,duracion,p.getLeft()));
else
if(nombre.compareTo(p.getNombre())>0)

p.setRight(insert(nombre,genero,duracion,p.getRight()));
else
System.out.println("No se pudo ingresar la pelicula.");
return p;
}
public void insertPeliculaClase(PeliAr t) {
root = insertClase(t,root);
}
private PeliAr insertClase(PeliAr t, PeliAr p) {
if(p == null){
p = t;
}else
if(t.getNombre().compareTo(p.getNombre())<0)
p.setLeft(insertClase(t,p.getLeft()));
else
if(t.getNombre().compareTo(p.getNombre())>0)

p.setRight(insertClase(t,p.getRight()));
else
System.out.println("No se pudo ingresar la pelicula.");
return p;
}

public void traverseInDriver(){
System.out.println("Lista de Peliculas:");
if (root!=null){
    count=0;
traverseIn(root);
}else
System.out.print("No hay peliculas disponibles");
System.out.println();
}


private void traverseIn(PeliAr p) {
if(p.getLeft() != null)
traverseIn(p.getLeft());
count++;
    System.out.print(count);
    System.out.print(". ");
System.out.println(p.getNombre());
if(p.getRight() != null)
traverseIn(p.getRight());
}

public void traverseInFile(File f) throws IOException{
if (root!=null){
    PrintStream salida= new PrintStream(f);
    traverseInF(root,f,salida);

}else
System.out.println("No hay datos para almacenar");
}


private void traverseInF(PeliAr p, File F, PrintStream salida) {
if(p.getLeft() != null)
traverseInF(p.getLeft(),F,salida);

salida.print(p.getNombre()+","+p.getGenero()+",");
salida.flush();
salida.print(p.getDuracion());
salida.flush();
salida.println(",");
salida.flush();

for(int i=0; i<7;i++){

    Horario h= p.getHorarios()[i];
    
    for(int u=0; u<100;u++){
       if(h.getSillas()[u].isOcupado()){
        salida.print(h.getSillas()[u].getCliente());   
       }else{
           salida.print(" ");
       }
       salida.print(",");
    }
       salida.println();
       salida.flush();
        }

if(p.getRight() != null)
traverseInF(p.getRight(),F,salida);
}

public void traverseInPrint() {
if (root!=null){
    count=0;
    traverseInP(root,System.out);

}else
System.out.println("No hay datos para mostrar");
}


private void traverseInP(PeliAr p,PrintStream salida) {
if(p.getLeft() != null)
traverseInP(p.getLeft(),salida);
count++;
    System.out.print(count);
    System.out.print(". ");
salida.print(p.getNombre()+","+p.getGenero()+",");
salida.flush();
salida.print(p.getDuracion());
salida.flush();
salida.println(",");
salida.flush();

for(int i=0; i<7;i++){
    System.out.print("Horario ");
    System.out.print(i+1);
    System.out.println(":");
    Horario h= p.getHorarios()[i];
    
    h.MostrarTodas();
    
        }

if(p.getRight() != null)
traverseInP(p.getRight(),salida);
}











public PeliAr findMin(PeliAr p) {
if(p != null)
while(p.getLeft() != null)
p = p.getLeft();
return p;
}



public boolean removePelicula(String nombre){
    elimination=false;
    root=remove(nombre,root);
    return elimination;
}
private PeliAr remove(String nombre, PeliAr p){
if(p!=null)
    if(nombre.compareTo(p.getNombre())<0)
    p.setLeft(remove(nombre,p.getLeft()));
    else if(nombre.compareTo(p.getNombre())>0)
    p.setRight(remove(nombre,p.getRight()));

    else if(p.getLeft()==null && p.getRight() ==null)
    p = null;
    else if(p.getLeft() ==null)
            p = p.getRight();
    else if(p.getRight() ==null)
            p = p.getLeft();
    else {
        PeliAr t =findMin(p.getRight());
        p.setNombre(t.getNombre());
        p.setDuracion(t.getDuracion());
        p.setGenero(t.getGenero());
        p.setHorarios(t.getHorarios());
        p.setRight(remove(p.getNombre(),p.getRight()));
        elimination=true;
    }else
System.out.println("La pelicula no existe");
return p;

}







public PeliAr buscarPelicula(String nombre){
PeliAr p=buscar(nombre,root);
return p;
}

private PeliAr buscar(String nombre, PeliAr p){

    
    while(p!=null){
    if (p.getNombre().equals(nombre)){
        break;
    }else if(nombre.compareTo(p.getNombre())<0){
        p=p.getLeft();
    }else if(nombre.compareTo(p.getNombre())>0){
        p=p.getRight();
    }    
    }
    return p;

}








public PeliAr getRoot() {
        return root;
    }

public void setRoot(PeliAr root) {
        this.root = root;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CineArbol getNext() {
        return next;
    }

    public void setNext(CineArbol next) {
        this.next = next;
    }


}
