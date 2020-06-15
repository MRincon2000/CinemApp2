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
public class PeliAr {
    private PeliAr left;

private PeliAr right;
 private Horario[] horarios;
private int duracion;
    private String nombre;
    private String genero;
    private String sala;


public PeliAr(String data) {
left = null;
this.nombre = data;
right = null;

this.horarios= new Horario[7];
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




    public PeliAr getLeft() {
        return left;
    }

    public void setLeft(PeliAr left) {
        this.left = left;
    }



    public PeliAr getRight() {
        return right;
    }

    public void setRight(PeliAr right) {
        this.right = right;
    }

    public Horario[] getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario[] horarios) {
        this.horarios = horarios;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
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


}
