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
public class ListaCines {
    private CineArbol head;

    public ListaCines() {
   this.head=null;
    }
public boolean insert(String nombre) {
boolean inserted;
CineArbol ptr;
CineArbol prev;
inserted = false;
ptr = head;
prev = null;
while(ptr != null && ptr.getNombre().compareTo(nombre)<0) {

prev = ptr;
ptr = ptr.getNext();
}
if(ptr == null || !ptr.getNombre().equals(nombre)) {
inserted = true;
CineArbol newp = new CineArbol(nombre);
newp.setNext(ptr);
if(prev == null)
head = newp;
else
prev.setNext(newp);
}
return inserted;
}
public boolean delete(String nombre){
    boolean deleted=false;
    CineArbol ptr=head;
    CineArbol prev=null;
    boolean found=false;
while(ptr!=null && ptr.getNombre().compareTo(nombre)<0){
    prev=ptr;
    ptr=ptr.getNext();
}
if (ptr.getNombre().equals(nombre)){
    deleted=true;
    if (prev==null){
       head=ptr.getNext();
    }
    else{
    prev.setNext(ptr.getNext());
    }
}
return deleted;
}

public CineArbol buscar(String nombre){
    CineArbol p= head;
    while(p!=null){
        if(p.getNombre().equals(nombre)){
            break;
        }
        else{
            p=p.getNext();
        }
        
    }
    return p;
}




public void printRecursive() {
System.out.print("List Recursive: ");
printR(head);
System.out.println();
}

private void printR(CineArbol p) {
if(p != null) {
System.out.print(p.getNombre()+" ");
printR(p.getNext());
}
}

}
