package com.testeSistemas.hikoki.Service;

import com.testeSistemas.hikoki.Entity.VersionEntity;
import com.testeSistemas.hikoki.Repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VersionService {

    @Autowired
    private VersionRepository versionRepository;

    public List<VersionEntity> listarVersoes(){
        Sort sort = Sort.by("versao").descending();

        return versionRepository.findAll(sort);
    }

    public VersionEntity adicionarVersao(VersionEntity versionEntity){
        if(versionRepository.findByVersao(versionEntity.getVersao()).isPresent()){
            throw new NoSuchElementException("Essa versao ja existe.");
        } return versionRepository.save(versionEntity);

    }

    public void deletarVersao(Integer id){
        if(versionRepository.existsById(id)){
            versionRepository.deleteById(id);
        }
    }

}
