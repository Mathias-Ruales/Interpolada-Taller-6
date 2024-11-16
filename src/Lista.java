import javax.swing.*;

public class Lista {
    public Nodo inicio;
    public int tamano;

    public Lista() {
        inicio = null;
        tamano = 0;

    }
    public void agregar (int dato, JTextArea textArea){
        Nodo nuevodNodo=new Nodo(dato);
        if (inicio==null){
            inicio=nuevodNodo;
        } else {
            Nodo actual=inicio;
            while (actual.siguiente!=null){
                actual=actual.siguiente;
            }
            actual.siguiente=nuevodNodo;
        }
        tamano++;
        actualizarLista(textArea);
    }
    public boolean eliminar (int dato, JTextArea textArea){
        if(inicio==null){
            JOptionPane.showMessageDialog(null, "Lista vacia");
            return false;
        }
        if (inicio.dato==dato){
            inicio=inicio.siguiente;
            tamano--;
            return true;
        }
        Nodo actual=inicio;
        while (actual.siguiente!=null&&actual.siguiente.dato!=dato){
            actual=actual.siguiente;
        }
        if (actual.siguiente!=null){
            actual.siguiente=actual.siguiente.siguiente;
            tamano--;
            return true;
        }
        JOptionPane.showMessageDialog(null, "Elemento no encontrado;");
        actualizarLista(textArea);
        return false;
    }

    public int buscarlineal(int dato, JTextArea textArea){
        Nodo actual=inicio;
        int posicion=0;
        while (actual!=null) {
            if (actual.dato == dato) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1;
    }
    public void mostrarLista(JTextArea textArea){
        if (inicio==null){
            textArea.setText("Lista Vacia");
        } else{
            StringBuilder listaStr = new StringBuilder();
            Nodo actual=inicio;

            while (actual!=null){
                listaStr.append(actual.dato)
                        .append("\n");
                actual=actual.siguiente;
            }
            textArea.setText(listaStr.toString());
        }
    }

    public int buscarInterpolada(int dato, JTextArea textArea){
        ordenarBurbuja(textArea);
        int []array=convertirArray();

        int inicio=0, fin=tamano-1;

        while (inicio<=fin && dato >= array[inicio] && dato <= array[fin]){
            int pos = inicio + ((dato-array[inicio])*(fin-inicio)/(array[fin]-array[inicio]));

            if (array[pos]==dato){
                return pos;
            }
            if (array[pos]<dato){
                inicio=pos+1;
            } else {
                fin=pos-1;
            }
        }
        return -1;
    }

    public void actualizarLista(JTextArea textArea){
        mostrarLista(textArea);
    }

    public int [] convertirArray(){
        int [] array =new int[tamano];
        Nodo actual =inicio;
        int i=0;

        while (actual!=null){
            array[i++]=actual.dato;
            actual=actual.siguiente;
        }
        return array;
    }
    public void ordenarBurbuja(JTextArea textArea){
        if (inicio==null||inicio.siguiente==null){
            return;
        }
        boolean inter;
        do{
            inter=false;
            Nodo actual =inicio;
            Nodo siguiente=inicio.siguiente;

            while (siguiente!=null){
                if (actual.dato>siguiente.dato){
                    int temp = actual.dato;
                    actual.dato=siguiente.dato;
                    siguiente.dato=temp;
                    inter=true;
                }
                actual=siguiente;
                siguiente=siguiente.siguiente;
            }


        }while (inter);
        actualizarLista(textArea);
    }


}