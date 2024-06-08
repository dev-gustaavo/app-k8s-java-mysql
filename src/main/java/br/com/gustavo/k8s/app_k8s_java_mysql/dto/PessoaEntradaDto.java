package br.com.gustavo.k8s.app_k8s_java_mysql.dto;

import lombok.Getter;

@Getter
public class PessoaEntradaDto {
    private String nome;
    private String email;
    private String cpf;
}
