package org.example.service;

import org.example.model.Pais;
import org.example.model.Presidente;
import org.example.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private final PaisRepository paisRepository;

    @paisRepository
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
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
            p.setPresidente(pais.getPresidente());
        }else {
            // Manejar el caso en que el país no exista, por ejemplo, lanzar una excepción
            throw new RuntimeException("El país con nombre " + pais.getNome() + " no existe.");
        }
        return paisRepository.save(p);
    }
    public Pais modificarPais(Presidente presidente, Pais pais){
        Pais p= paisRepository.findByNome(pais.getNome());
        if (p!=null){
            p.setPresidente(presidente);
        }else {
            // Manejar el caso en que el país no exista, por ejemplo, lanzar una excepción
            throw new RuntimeException("El país con nombre " + pais.getNome() + " no existe.");
        }
        return paisRepository.save(p);

    }

    public void eliminarPaises(){
        paisRepository.deleteAll();
    }
}
