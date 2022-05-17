package Persistance;

import java.io.*;

public class Persistance
{
    private FileOutputStream outputFile;
    private ObjectOutputStream writerFile;

    private FileInputStream inputFile;
    private ObjectInputStream readerFile;

    //--------------------------------------------------------------------------
    //Methods to use the file writer
    public void initOutput(String className)
    {
        try
        {
            outputFile = new FileOutputStream("src/main/java/Persistance/"+className+".ini");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error al crear el archivo");
            System.out.println(e.getMessage());
        }

        try
        {
            writerFile = new ObjectOutputStream(outputFile);
        }
        catch (IOException e)
        {
            System.out.println("Error al acceder al archivo");
            System.out.println(e.getMessage());
        }
    }

    public void writeSerializable(Object o)
    {
        if (writerFile != null)
        {
            try {
                writerFile.writeObject(o);
            } catch (IOException e) {
                System.out.println("error al escribir los datos en el archiuvo");
                System.out.println(e.getMessage());
            }
        }
    }

    public void closeWriterSerializable()
    {
        if (writerFile != null)
        {
            try
            {
                writerFile.close();
            }
            catch (Exception e)
            {
                System.out.println("Error al cerrar el archivo");
                System.out.println(e.getMessage());
            }
        }
    }

    //--------------------------------------------------------------------------
    //Methods to use the file reader
    public void initInput(String className)
    {
        try
        {
            inputFile = new FileInputStream("src/main/java/Persistance/"+className+".ini");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error al abrir el archivo");
            System.out.println(e.getMessage());
        }

        try
        {
            readerFile = new ObjectInputStream(inputFile);
        }
        catch (IOException e)
        {
            System.out.println("Error al leer al archivo");
            System.out.println(e.getMessage());
        }
    }

    public Object readSerializable()
    {
        Object aux = null;
        if (readerFile != null)
        {
            try
            {
                aux = readerFile.readObject();
            }
            catch (IOException e)
            {
                System.out.println("Error al leer el archivo");
                System.out.println(e.getMessage());
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Error al convertir los datos");
                System.out.println(e.getMessage());
            }
        }
        return aux;
    }

    public  void closeReaderSerializable()
    {
        if (readerFile != null)
        {
            try
            {
                readerFile.close();
            }
            catch (IOException e)
            {
                System.out.println("Error al cerrar el archivo");
                System.out.println(e.getMessage());
            }
        }
    }
}
