package Util;
/**
 * @author Santiago González y Santiago Dávila
 * Clase funcional para el guardado de canciones
 */
public class List
{
    //Atributos de la clase
    public Node first;
    public Node last;

    public static int size;
    /**
     *Constructor de la clase
     */
    public List(){
        first=null;
        last=null;
        size=0;
    }
    /**
     *Validacipon de la lista
     */
    public boolean IsEmpty(){
        if(first==null && last==null){
            return true;
        }else{
            return false;
        }
    }
    /**
     *Limpieza de la lista
     */
    public void clear(){
        while (!IsEmpty()){
            borrar(first);
        }
    }
    /**
     *Inserción de datos en la lista
     * @param name y direccion
     */
    public void insertar(String name,String direccion)
    {
        Node nuevo=new Node(name,direccion);

        if(first == null)
        {
            first = nuevo;
            first.siguiente = first;
            nuevo.anterior = last;
            last = nuevo;
        }
        else
        {
            last.siguiente = nuevo;
            nuevo.siguiente = first;
            nuevo.anterior = last;
            last = nuevo;
            first.anterior = last;
        }
    }
    /**
     *Método que devuelve el tamaño de la lista
     */
    public int size()
    {
        if (IsEmpty())
        {
            return 0;
        }
        else
        {
            return size;
        }
    }
    /**
     *Método que devuelve el index del nodo buscado
     */
    public int index(Node b)
    {
        Node aux=first;
        int count=0;

        do
        {
            if(aux==b)
            {
                return count;
            }

            aux=aux.siguiente;
            count++;
        }while (aux!=first);
    return -1;
    }
    /**
     *Método para buscar un nodo
     */
    public Node get_song(int index)
    {
        if(index<0 || index>=size)
        {
            return null;
        }

        int n=0;
        Node aux=first;

        while (n!=index)
        {
            aux=aux.siguiente;
            n++;
        }
        return aux;
    }
    /**
     *Método para borrar un nodo
     */
    public void borrar(Node n)
    {
        boolean found=false;
        Node actual=first;
        Node previous=last;

        do
        {
            if(n==first)
            {
                if(actual==first)
                {
                    first=first.siguiente;
                    last.siguiente=first;
                    first.anterior=last;
                }
                else if(actual==last)
                {
                    last=previous;
                    first.anterior=last;
                    last.siguiente=first;
                }
                else
                {
                    previous.siguiente=actual.siguiente;
                    actual.siguiente.anterior=previous;
                }
                found=true;
            }
            previous=actual;
            actual=actual.siguiente;
        }while (actual!=first && found==false);
    }
}
