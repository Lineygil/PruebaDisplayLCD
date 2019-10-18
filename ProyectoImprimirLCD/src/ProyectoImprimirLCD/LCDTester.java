import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LCDTester{

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> ordenesDeImpresion = new ArrayList<>();
        String size;
        int espacioEntreDigitos;
        
        try {

            try (Scanner lector = new Scanner(System.in)) {
                
                System.out.print("Espacio entre Digitos (0 a 10): ");
                size = lector.next();

                // Valida si es un numero
                if (Utilidades.esNumerico(size)) 
                {
                    espacioEntreDigitos = Integer.parseInt(size);
                    
                    // se valida que el espaciado este entre 0 y 10
                    if(espacioEntreDigitos <0 || espacioEntreDigitos >10)
                    {
                        throw new IllegalArgumentException("El espacio entre "
                                + "digitos debe estar entre 0 y 10");
                    }
                    
                } 
                else 
                {
                    throw new IllegalArgumentException("Cadena " + size
                            + " no es un entero");
                }
                
                do
                {
                    System.out.print("Entrada: ");
                    size = lector.next();
                    if(!size.equalsIgnoreCase(CADENA_FINAL))
                    {
                        ordenesDeImpresion.add(size);
                    }
                }while (!size.equalsIgnoreCase(CADENA_FINAL)); 
            }

            ImpresorLCD impresorLCD = new ImpresorLCD();

            Iterator<String> iterator = ordenesDeImpresion.iterator();
            while (iterator.hasNext()) 
            {
                try 
                {
                    
                    impresorLCD.imprimir(iterator.next(), espacioEntreDigitos);
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }

        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }

    }

}
