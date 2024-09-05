package controller;

import enums.Status;
import model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService balnearioService;

    @GetMapping
    public List<Member> getAllMembers(){ return balnearioService.getAllMembers();}

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id){
        Optional<Member> balneario = balnearioService.getMemberById(id);
        return balneario.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/status-miembro")
    public ResponseEntity<List<Member>> buscarPorStatusMiembro(@RequestParam Status statusMiembro){
        List<Member> balnearios = balnearioService.buscarPorStatusMiembro(statusMiembro);
        return ResponseEntity.ok(balnearios);
    }
}
