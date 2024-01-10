package com.banco.backend.api;

import com.banco.backend.dots.ClienteDots;
import com.banco.backend.models.ClienteModel;
import com.banco.backend.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ClienteController {
    @Autowired
    private final ClienteRepository clienteRepository;
    public ClienteController(ClienteRepository cr){
        this.clienteRepository=cr;
    }

    @PostMapping("/novo")
    public ResponseEntity<ClienteModel> criarConta(@RequestBody @Validated ClienteDots clienteDots){
        var clienteModel = new ClienteModel();

        BeanUtils.copyProperties(clienteDots,clienteModel);

        //Validação deveria ser feita no front-end mas nesse caso decidi fazer no Back-End (por que não existe front
        // kkk)
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }
}
