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
public class Pelicula {
    
    private Horario[] horarios;
private double duracion;
    private String nombre;
    private String genero;
    private String sala;
     private int N;
    public Pelicula(String nombre) {
        this.nombre = nombre;

        this.N = 7;
        this.horarios= new Horario[N];
        int hora= 9;
       
        for(int i=0;i<7;i++){
           horarios[i] = new Horario(hora);
            hora=hora+2;
        }  
    }
    
    public void mostrar(){
        for(int o=0;o<7;o++){
            System.out.println(this.horarios[o].getHorario());
        }
    }
   
    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Horario[] getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario[] horarios) {
        this.horarios = horarios;
    }
   
    
    
}
