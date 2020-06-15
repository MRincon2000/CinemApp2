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
public class Horario{
    
    private int horario;
    private Silla[] sillas;
    public Horario(int horario) {
        this.horario = horario;
        this.sillas= new Silla[100];
        char fila='A';
        int numero=1;
        int count=0;
        int asci=65;
        for(int i=0;i<100;i++){
            this.sillas[i]= new Silla(fila,numero);
        numero=numero+1;
        count++;
        if(count%10==0){
            asci++;
            fila=(char)asci;
            numero=1;
        }
        }   
    }
    public int getHorario() {
        return horario;
    }
    public void setHorario(int horario) {
        this.horario = horario;
    }

    public void MostrarDisponibles(){
        for(int p=0;p<100;p++){
           if( !this.sillas[p].isOcupado()){
               System.out.print(this.sillas[p].getFila());
               System.out.print(this.sillas[p].getNumero());
               System.out.print(":   ");
               System.out.println(this.sillas[p].getPrecio());
           }
        }
    }
    public void MostrarTodas(){
        for(int p=0;p<100;p++){
               System.out.print(this.sillas[p].getFila());
               System.out.print(this.sillas[p].getNumero());
               System.out.print(":   ");
               
               if(this.sillas[p].isOcupado()){
                   System.out.println("Ocupado  " + this.sillas[p].getCliente());
               }
               else System.out.println("Desocupado");
        }
    }
    public void ComprarSilla(String nombre,int numero){
      if(!this.sillas[numero].isOcupado()){
        this.sillas[numero].setCliente(nombre);
        this.sillas[numero].setOcupado(true);
      }else{
          System.out.println("La silla ya se encuentra ocupada");
      }
    }
    public void CancelarCompra(int numero){
        if(this.sillas[numero].isOcupado()){
         this.sillas[numero].setCliente("");
        this.sillas[numero].setOcupado(false);
       }else{
           System.out.println("La silla no se encuentra ocupada");
       }
    }

    public Silla[] getSillas() {
        return sillas;
    }

    public void setSillas(Silla[] sillas) {
        this.sillas = sillas;
    }
    
}
