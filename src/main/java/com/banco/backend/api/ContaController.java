package com.banco.backend.api;


import com.banco.backend.dots.ContaDots;
import com.banco.backend.models.ClienteModel;
import com.banco.backend.models.ContaModel;
import com.banco.backend.repository.ClienteRepository;
import com.banco.backend.repository.ContaRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaRepository contaRepository;
    private ClienteRepository clienteRepository;



    public ContaController(ContaRepository contaRepositoryP, ClienteRepository clienteRepositoryP){
        this.contaRepository=contaRepositoryP;
        this.clienteRepository=clienteRepositoryP;
    }


    @PostMapping()
    public ResponseEntity<ContaModel> createConta(@Validated @RequestBody ContaDots contaDots){

        var contaModel = new ContaModel();
        BeanUtils.copyProperties(contaDots,contaModel);

        ClienteModel clienteModel = clienteRepository.findById(contaDots.clienteID()).orElse(null);

        if (clienteModel != null) {
            contaModel.setClienteID(clienteModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(contaModel));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping()
    public ResponseEntity<ContaModel> searchConta(@RequestParam(name="id") @NotNull int contaID){

        ContaModel clienteModel = contaRepository.findById(contaID).orElse(null);

        if (clienteModel != null) {
            return ResponseEntity.ok(clienteModel);
        }

        return ResponseEntity.notFound().build();
    }
}
