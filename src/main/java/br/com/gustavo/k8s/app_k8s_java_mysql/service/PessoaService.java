package br.com.gustavo.k8s.app_k8s_java_mysql.service;

import br.com.gustavo.k8s.app_k8s_java_mysql.dto.PessoaDto;
import br.com.gustavo.k8s.app_k8s_java_mysql.dto.PessoaEntradaDto;
import br.com.gustavo.k8s.app_k8s_java_mysql.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper mapper;

    public PessoaDto save(PessoaEntradaDto pessoaEntrada) throws Exception {
        try {
            var pessoaEntity = mapper.convertValue(pessoaEntrada, PessoaDto.class);
            return pessoaRepository.save(pessoaEntity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
