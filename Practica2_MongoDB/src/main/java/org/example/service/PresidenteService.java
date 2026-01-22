package org.example.service;

import org.example.model.Presidente;
import org.example.repository.PaisRepository;
import org.example.repository.PresidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresidenteService {

    @Autowired
    private final PresidenteRepository presidenteRepository;


    public PresidenteService(PresidenteRepository presidenteRepository) {
        this.presidenteRepository = presidenteRepository;
    }


    public List<Presidente> listarPresidentes(){
        return presidenteRepository.findAll();
    }

    public Presidente insertarPresidente(Presidente presidente){
        return presidenteRepository.save(presidente);
    }

    public void eliminarPresidentes(){
        presidenteRepository.deleteAll();
    }

    public void eliminarPresidentePorId(String id){
        presidenteRepository.deleteById(id);
    }


}
