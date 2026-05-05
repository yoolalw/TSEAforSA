package com.testeSistemas.hikoki.Controller;

import com.testeSistemas.hikoki.Entity.VersionEntity;
import com.testeSistemas.hikoki.Service.VersionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/versoes")
@CrossOrigin(origins = "*")
public class VersionController {
    @Autowired
    private VersionService versionService;

    @GetMapping
    public List<VersionEntity> listarVersoes(){
        return versionService.listarVersoes();
    }

    @PostMapping("/novaVersao")
    public ResponseEntity<VersionEntity> adicionarVersao(@RequestBody VersionEntity versionEntity){
        return ResponseEntity.ok(versionService.adicionarVersao(versionEntity));
    }

    @DeleteMapping("/{id}")
    public void deletarVersao(@PathVariable Integer id){
        versionService.deletarVersao(id);
    }

}
