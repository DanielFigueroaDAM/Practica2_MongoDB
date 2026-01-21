import org.example.model.Exercicio;
import org.example.model.Videoxogo;
import org.example.service.ConexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Secuencia {


    public void exameSolucion() {

        List<Videoxogo> videoxogos;
        Exercicio exercicio;

        // 1
        System.out.println("Execución Exercicio 1");
      
        System.out.println("FIN Exercicio 1");

        // 2
        System.out.println("Execución Exercicio 2");
 
        System.out.println("FIN Exercicio 2");

        // 3
        System.out.println("Execución Exercicio 3");

        System.out.println("FIN Exercicio 3");

        // 4
        System.out.println("Execución Exercicio 4");
        
        System.out.println("FIN Exercicio 4");

        // 5
        System.out.println("Execución Exercicio 5");
       
        System.out.println("FIN Exercicio 5");

        // 6
        System.out.println("Execución Exercicio 6");
       
        System.out.println("FIN Exercicio 6");

        // 7
        System.out.println("Execución Exercicio 7");
        
        System.out.println("FIN Exercicio 7");
    }
}
