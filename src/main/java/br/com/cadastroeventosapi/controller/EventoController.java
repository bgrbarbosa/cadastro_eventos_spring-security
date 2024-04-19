package br.com.cadastroeventosapi.controller;

import br.com.cadastroeventosapi.entity.dto.EventoDTO;
import br.com.cadastroeventosapi.service.EventoService;
import br.com.cadastroeventosapi.service.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {

    @Autowired
    EventoService service;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping
    public ResponseEntity<Object>findAll(@PageableDefault(page = 0, size = 10, sort = "idEvento", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<EventoDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

  @GetMapping(value = "/{id}")
    public ResponseEntity<Object>findById(@PathVariable(value = "id")  Long id) {
      Optional<EventoDTO>obj = service.findById(id);
      if (!obj.isPresent()) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Entity not found - ID: " + id));
      }
      return ResponseEntity.status(HttpStatus.OK).body(obj.get());
  }

    @PostMapping
    public ResponseEntity<Object>insert(@RequestBody @Valid EventoDTO dto){
        EventoDTO result = mapper.map(service.insert(dto), EventoDTO.class);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getIdEvento()).toUri();
        return ResponseEntity.created(uri).body(result);
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid EventoDTO dto) {
        dto = service.update(dto.getIdEvento(), dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object>  delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Registro deletado com sucesso!!");
    }

}
