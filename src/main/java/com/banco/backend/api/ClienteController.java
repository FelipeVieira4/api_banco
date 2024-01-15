

import com.banco.backend.dots.ClienteDots;
import com.banco.backend.models.ClienteModel;
import com.banco.backend.repository.ClienteRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Utilities;

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

    @GetMapping("/buscar")
    public ResponseEntity<ClienteModel> buscarConta(@RequestParam("id") @NotNull int idCliente,
                                                    @RequestParam("pass") @NotNull @NotBlank String passCliente) {
        ClienteModel clienteModel = clienteRepository.findById(idCliente).orElse(null);

        if (clienteModel != null && clienteModel.getSenha().equals(passCliente)) {
            return ResponseEntity.ok(clienteModel);
        }

        return ResponseEntity.notFound().build();
    }


     @DeleteMapping("/deletar")
    public ResponseEntity<ClienteModel> deletarConta(@RequestParam("id") @NotNull int idCliente,
                                                     @RequestParam("pass") @NotNull @NotBlank String pass){

        ClienteModel clienteModel = clienteRepository.findById(idCliente).orElse(null);

        if(clienteModel!=null && clienteModel.getSenha().equals(pass)){
            clienteRepository.delete(clienteModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
