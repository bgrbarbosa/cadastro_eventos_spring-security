package br.com.cadastroeventosapi.service;

import br.com.cadastroeventosapi.entity.Convidado;
import br.com.cadastroeventosapi.entity.dto.ConvidadoDTO;
import br.com.cadastroeventosapi.entity.dto.EventoDTO;
import br.com.cadastroeventosapi.repository.ConvidadoRepository;
import br.com.cadastroeventosapi.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    @Transactional(readOnly = true)
    public Page<ConvidadoDTO> findAll(Pageable pageable) {
        Page<Convidado> list = repository.findAll(pageable);
        return list.map(x -> mapper.map(x, ConvidadoDTO.class));
    }

    @Transactional(readOnly = true)
    public Optional<ConvidadoDTO> findById(Long id) {
        Optional<Convidado> obj = repository.findById(id);
        if (obj.isEmpty()){
            throw new ResourceNotFoundException("Entity no found: " + id);
        }
        return mapper.map(obj, Optional.class);
    }

    @Transactional
    public Convidado insert(ConvidadoDTO convidado) {
        return repository.save(mapper.map(convidado, Convidado.class));
    }

    @Transactional
    public ConvidadoDTO update(Long id, ConvidadoDTO convidadoDTO) {
            try {
                Convidado entity = repository.getOne(id);
                entity.setRgConvidado(convidadoDTO.getRgConvidado());
                entity.setCpfConvidado(convidadoDTO.getCpfConvidado());
                entity.setEmailConvidado(convidadoDTO.getEmailConvidado());
                entity.setTelConvidado(convidadoDTO.getTelConvidado());
                entity.setNomeConvidado(convidadoDTO.getNomeConvidado());
                entity = repository.save(entity);
                return mapper.map(entity, ConvidadoDTO.class);
            }
            catch (EntityNotFoundException e) {
                throw new ResourceNotFoundException("Id not found " + id);
            }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
