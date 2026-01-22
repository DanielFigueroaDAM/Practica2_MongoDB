package org.example.service;

import org.example.model.Pais;
import org.example.model.Presidente;
import org.example.repository.PaisRepository;
import org.example.repository.PresidenteRepository;
import org.example.utils.UtilJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PaisService {


    private final PaisRepository paisRepository;


    private final PresidenteRepository presidenteRepository;


    public PaisService(PaisRepository paisRepository, PresidenteRepository presidenteRepository) {
        this.paisRepository = paisRepository;
        this.presidenteRepository = presidenteRepository;
    }

    public List<Pais> leerPaises(){
         return paisRepository.findAll();
    }

    public Pais modificarPais(Pais pais){
        Pais p= paisRepository.findByNome(pais.getNome());
        if (p!=null){
            p.setNome(pais.getNome());
            p.setOrganizacion(pais.getOrganizacion());
            p.setPartidos(pais.getPartidos());
            p.setId_presidente(pais.getId_presidente());
        }else {
            // Manejar el caso en que el país no exista, por ejemplo, lanzar una excepción
            throw new RuntimeException("El país con nombre " + pais.getNome() + " no existe.");
        }
        return paisRepository.save(p);
    }
    public Pais modificarPais(String presidente, Pais pais){
        Pais p= paisRepository.findByNome(pais.getNome());
        if (p!=null){
            p.setId_presidente(presidente);
        }else {
            // Manejar el caso en que el país no exista, por ejemplo, lanzar una excepción
            throw new RuntimeException("El país con nombre " + pais.getNome() + " no existe.");
        }
        return paisRepository.save(p);

    }

    public void insertarPais(Pais pais){
        paisRepository.save(pais);
    }

    public void eliminarPaises(){
        paisRepository.deleteAll();
    }

    // Inserir datos importados dun arquivo JSON
    public void insertarPaisesyPresidente(String arquivoJsonPaises, String arquivoJsonPresidentes) {
        UtilJson utilJson = new UtilJson();
        try {
            utilJson.readJsonFile(arquivoJsonPaises, Pais.class).forEach(this::insertarPais);
            utilJson.readJsonFile(arquivoJsonPresidentes, Presidente.class).forEach(presidenteRepository::save);
        } catch (IOException e) {
            System.out.println("Erro ao ler os arquivos JSON: " + e.getMessage());
        }
    }


}
