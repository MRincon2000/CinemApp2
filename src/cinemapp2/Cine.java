/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemapp2;

/**
 *
 * @author MSI PC
 */
public class Cine {
    private int N;
    private int posicion;
    private int count;
    private Pelicula[] peliculas;

    public Cine(int N) {
        this.N = N;
        this.peliculas= new Pelicula[N];
    }
    public boolean empty(){
        return count<=0;
    }
    public boolean full(){
        return count>=this.N;
    }
    public boolean eliminar(String nombre){
        boolean deleted= false;
        if(!empty()){
            if (search(nombre)){
                for(int u=posicion;u<count-1;u++){
                    peliculas[u]=peliculas[u+1];
                }
                peliculas[count-1]=null;
                    count--;
                    deleted=true;
                
            }
        }
        else System.out.println("Inventario de peliculas vacio");
        return deleted;
    }
public boolean insertar(Pelicula peli){
    boolean inserted=false;
    if(!full()){
        //if(!search(peli.getNombre())){
            peliculas[count]=peli;
            count++;
            inserted=true;
        //}
        //else{
        //    System.out.println("Pelicula repetida");
       // }
    }
    else System.out.println("Inventario de peliculas lleno");
    return inserted;
}
private boolean search(String nombre){
    boolean found=false;

    posicion=0;
    while(posicion<count){
        
            if(peliculas[posicion].getNombre().equals(nombre)){
                found=true;
                break;
            }
 
        posicion++;
    
    }
    return found;
}
public int searchP(String nombre){
  boolean found=  this.search(nombre);
    if(found==true){
        return this.posicion;
    }
    else{
        return -1;
    }
}

public void output(){
    System.out.println("Lista: ");
    int g=0;
    while(g!=count){
        System.out.print("Pelicula ");
        System.out.print(g+1);
        System.out.print(": ");
        System.out.println(peliculas[g].getNombre());

        g++;
    }
    System.out.println();
    
}

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Pelicula[] peliculas) {
        this.peliculas = peliculas;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public boolean eliminarIndice(int indice){
       boolean deleted=false;
     
       if(indice<count && !empty()){
         
        for(int r=indice;r<count-1;r++){
            peliculas[r]=peliculas[r+1];
                }
                peliculas[count-1]=null;
                    count--;
                    deleted=true;
        
       }else{
           System.out.println("El indice no existe");
       }
       return deleted;
    }
}


