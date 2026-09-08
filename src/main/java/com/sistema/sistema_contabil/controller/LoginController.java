package com.sistema.sistema_contabil.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.model.seguranca.Usuario;
import com.sistema.sistema_contabil.security.JwtUtil;
import com.sistema.sistema_contabil.service.LoginService;

@RestController
@RequestMapping("/api/login")
//@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
    boolean autenticado = loginService.autenticarUsuario(usuario.getEmail(), usuario.getSenha());
    if (autenticado) {
        String token = jwtUtil.generateToken(usuario.getEmail());
        return ResponseEntity.ok().body(Collections.singletonMap("token", token));
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login inválido");
    }
}

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/criar-usuario")
    public String criarUsuario(@RequestBody Usuario usuario) {
        return loginService.cadastrarUsuario(usuario);
    }


    // Exemplo no Controller
    @GetMapping("/api/teste-protegido")
    public ResponseEntity<String> testeProtegido() {
    return ResponseEntity.ok("Token JWT válido. Acesso permitido!");
    }


}


/* 

    @PostMapping
    public boolean login(@RequestBody Usuario usuario) {
        System.out.println("Login recebido: " + usuario.getLogin());
        System.out.println("🔵 Início do login no back-end");
        long inicio = System.nanoTime();
        long fim = System.nanoTime();
        long duracaoMs = (fim - inicio) / 1_000_000; // converte para milissegundos
    System.out.println("⏱️ Tempo total de execução (back-end): " + duracaoMs + " ms");

        return loginService.autenticarUsuario(usuario.getLogin(), usuario.getSenha());
        
    
    }

    */



/* 

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        System.out.println("Recebido do front:");
        System.out.println("Login: " + usuario.getLogin());
        System.out.println("Senha: " + usuario.getSenha());

         Optional<Usuario> userOpt = usuarioRepository.findByLogin(usuario.getLogin());

    if (userOpt.isPresent()) {
        Usuario user = userOpt.get();

        if (passwordEncoder.matches(usuario.getSenha(), user.getSenha())) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        }
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
}

*/

        
/* 
        boolean usuarioValido = usuarioRepository
                .findByLoginAndSenha(usuario.getLogin(), usuario.getSenha())
                .isPresent();

        if (usuarioValido) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
        }
    }

*/
/* 
        // endpoint temporário para criar usuários com senha criptografada
        @PostMapping("/criar-usuario")
        public String criarUsuario(@RequestBody Usuario usuario) {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            usuarioRepository.save(usuario);
            return "Usuário criado com sucesso!";
}

}
*/