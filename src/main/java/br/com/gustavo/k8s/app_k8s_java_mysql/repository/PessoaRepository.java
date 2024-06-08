package br.com.gustavo.k8s.app_k8s_java_mysql.repository;

import br.com.gustavo.k8s.app_k8s_java_mysql.dto.PessoaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaDto, Integer> {
}
