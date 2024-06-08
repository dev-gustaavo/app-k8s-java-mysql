package br.com.gustavo.k8s.app_k8s_java_mysql.controller;

import br.com.gustavo.k8s.app_k8s_java_mysql.dto.PessoaEntradaDto;
import br.com.gustavo.k8s.app_k8s_java_mysql.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoa")
public class AppController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity criarPessoa(@RequestBody PessoaEntradaDto entrada) throws Exception {
        pessoaService.save(entrada);
        return ResponseEntity.ok().build();
    }
}
