package com.testeSistemas.hikoki.Controller;

import com.testeSistemas.hikoki.Entity.UserEntity;
import com.testeSistemas.hikoki.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @PostMapping("/novoUser")
    public ResponseEntity<UserEntity> adicionarUsuario(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.adicionarUsuario(userEntity));
    }

    @PutMapping("{/idUser}")
    public ResponseEntity<UserEntity> atualizarUsuario(@PathVariable Integer idUser,
                                                       @RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.atualizarUsuario(idUser, userEntity));
    }

    @DeleteMapping("{idUser}")
    public void desligarUsuario(@PathVariable Integer idUser) {
        userService.desligarUsuario(idUser);
    }

}
