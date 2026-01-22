package org.example;

import org.example.model.Pais;
import org.example.model.Presidente;
import org.example.service.PaisService;
import org.example.service.PresidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Secuencia {


    @Autowired
    private PaisService paisService;
    @Autowired
    private PresidenteService presidenteService;

    public void practica2() {


        // Inserir datos Json na base de datos
        paisService.insertarPaisesyPresidente("src/main/resources/dataPaises.json", "src/main/resources/dataPresidentes.json");

        var presidentes = presidenteService.listarPresidentes();

        var paises = paisService.leerPaises();

        presidentes.forEach(System.out::println);
        paises.forEach(System.out::println);


        // Modificamos el presidente del primer país
        Presidente presidente = new Presidente();
        presidente.setNome("Juan Perez");
        presidente.setIdade(56);
        presidente.setPartido("Partido Democrático");
        var presidenteNuevo = presidenteService.insertarPresidente(presidente);
        paises.get(0).setId_presidente(presidenteNuevo.getId());
        paisService.modificarPais(paises.get(0));

        // Modificamos la organización del segundo país
        paises.get(1).setOrganizacion("Nueva Organización Internacional");
        paisService.modificarPais(paises.get(1));

        System.out.println("----- Después de las modificaciones -----");
        presidentes = presidenteService.listarPresidentes();
        paises = paisService.leerPaises();
        presidentes.forEach(System.out::println);
        paises.forEach(System.out::println);

        System.out.println("----- Eliminando todos los presidentes -----");
        presidenteService.eliminarPresidentes();
        presidentes = presidenteService.listarPresidentes();
        presidentes.forEach(System.out::println);

        System.out.println("----- Eliminando todos los paises -----");
        paisService.eliminarPaises();
        paises = paisService.leerPaises();
        paises.forEach(System.out::println);










    }
}
