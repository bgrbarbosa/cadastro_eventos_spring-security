package br.com.cadastroeventosapi.repository;

import br.com.cadastroeventosapi.entity.Convidado;
import br.com.cadastroeventosapi.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Long>, PagingAndSortingRepository<Convidado, Long> {
}
