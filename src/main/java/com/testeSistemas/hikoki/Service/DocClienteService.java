package com.testeSistemas.hikoki.Service;

import com.testeSistemas.hikoki.Entity.DocCliente;
import com.testeSistemas.hikoki.Repository.DocClienteRepository;
import com.testeSistemas.hikoki.Repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocClienteService {

    @Autowired
    private DocClienteRepository docClienteRepository;

    public List<DocCliente> listarDocCliente() {
        Sort sort = Sort.by("nomeCliente").descending();
        return docClienteRepository.findAll();
    }

    public DocCliente novoDocCliente(DocCliente docCliente) {
        return docClienteRepository.save(docCliente);
    }

    public void deletarDocCliente(Integer id) {
        if(docClienteRepository.existsById(id)) {
            docClienteRepository.deleteById(id);
        }

    }

}
