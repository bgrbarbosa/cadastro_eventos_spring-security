package br.com.cadastroeventosapi.service;


import br.com.cadastroeventosapi.entity.Evento;
import br.com.cadastroeventosapi.entity.dto.EventoDTO;
import br.com.cadastroeventosapi.repository.EventoRepository;
import br.com.cadastroeventosapi.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    @Transactional(readOnly = true)
    public Page<EventoDTO> findAll(Pageable pageable) {
        Page<Evento> list = repository.findAll(pageable);
        return list.map(x -> mapper.map(x, EventoDTO.class));
    }

/*    @Transactional(readOnly = true)
    public Page<Evento> findAll(Pageable pageable) {
        Page<Evento> list = repository.findAll(pageable);
        return list;
    }*/

    @Transactional(readOnly = true)
    public Optional<EventoDTO> findById(Long id) {
        Optional<Evento> obj = repository.findById(id);
        if (obj.isEmpty()){
            throw new ResourceNotFoundException("Entity no found: " + id);
        }
        return mapper.map(obj, Optional.class);
    }

    @Transactional
    public Evento insert(EventoDTO evento) {
        return repository.save(mapper.map(evento, Evento.class));
    }

    @Transactional
    public EventoDTO update(Long id, EventoDTO evento) {
            try {
                Evento entity = repository.getOne(id);
                entity.setDescEvento(evento.getDescEvento());
                entity.setHrEvento(evento.getHrEvento());
                entity = repository.save(entity);
                return mapper.map(entity, EventoDTO.class);
            }
            catch (EntityNotFoundException e) {
                throw new ResourceNotFoundException("Id not found " + id);
            }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
