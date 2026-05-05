package com.testeSistemas.hikoki.Service;

import com.testeSistemas.hikoki.Entity.UserEntity;
import com.testeSistemas.hikoki.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> listarUsuarios(){
        Sort sort  = Sort.by("setor").descending()
                .and(Sort.by("nomeUser"));
        return userRepository.findAll(sort);
    }

    public UserEntity adicionarUsuario(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public UserEntity atualizarUsuario(Integer idUser, UserEntity userEntity){
        UserEntity userExistente = userRepository.findById(idUser)
                .orElseThrow(NoSuchElementException::new);

        userExistente.setNomeUser(userEntity.getNomeUser());
        userExistente.setKey(userEntity.getKey());
        userExistente.setSetor(userEntity.getSetor());

        return userRepository.save(userExistente);
    }

    public void desligarUsuario(Integer idUser){
        if(userRepository.existsById(idUser)){
            userRepository.deleteById(idUser);
        }
    }

}
