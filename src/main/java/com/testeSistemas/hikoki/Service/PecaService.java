package com.testeSistemas.hikoki.Service;

import com.testeSistemas.hikoki.Entity.PecaEntity;
import com.testeSistemas.hikoki.Repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PecaService {

    @Autowired
    private PecaRepository pecaRepository;

    public List<PecaEntity> listarPecas() {
        Sort sort = Sort.by("dataCriacao").descending()
                .and(Sort.by("versao").descending());
        return pecaRepository.findAll(sort);
    }

    public PecaEntity listarId(Integer id) {
        return pecaRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }


    public PecaEntity adicionarPeca(PecaEntity pecaEntity) {
        return pecaRepository.save(pecaEntity);
    }

    public PecaEntity adicionarVersao(PecaEntity pecaEntity) {
        if (pecaRepository.findByVersao(pecaEntity.getVersao()).isPresent()) {
            throw new NoSuchElementException("Essa versao ja existe.");
        }
        return pecaRepository.save(pecaEntity);
    }


    public PecaEntity alterarNome(Integer id, PecaEntity pecaAtualizar) {
        PecaEntity pecaExistente = pecaRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        pecaExistente.setNomePeca(pecaAtualizar.getNomePeca());

        return pecaRepository.save(pecaExistente);
    }

    public void deletarPeca(Integer id) {
        if (pecaRepository.existsById(id)) {
            pecaRepository.deleteById(id);
        }
    }


}
