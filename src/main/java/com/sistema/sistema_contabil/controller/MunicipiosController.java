package com.sistema.sistema_contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import com.sistema.sistema_contabil.model.Municipios;
import com.sistema.sistema_contabil.repository.MunicipiosRepository;


@RestController
@RequestMapping("/api/ibge")
@CrossOrigin(origins = "http://localhost:4200") // ajuste conforme necessário
public class MunicipiosController {

    @Autowired
    private MunicipiosRepository municipiosRepository;

    @PostMapping
    public Municipios salvar(@RequestBody Municipios municipios) {
        return municipiosRepository.save(municipios);
    }

    // listar
   // @GetMapping
   // public List<Municipios> listar() {
    //return municipiosRepository.findAll();s
    //}

/*  @GetMapping
    public List<Municipios> listar() {
    List<Municipios> lista = municipiosRepository.findAll();
    //System.out.println("Retornando municipios: " + lista);
    return lista;
} */

    @GetMapping
    public Page<Municipios> listar(
            @RequestParam(defaultValue = "") String filtro,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return municipiosRepository.buscarComFiltro(filtro, pageable);
    }

}
