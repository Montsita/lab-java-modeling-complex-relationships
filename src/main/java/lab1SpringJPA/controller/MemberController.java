package lab1SpringJPA.controller;

import lab1SpringJPA.enums.MemberStatus;
import lab1SpringJPA.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lab1SpringJPA.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService miembroService;

    @GetMapping
    public List<Member> getAllMembers(){ return miembroService.getAllMembers();}

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id){
        Optional<Member> balneario = miembroService.getMemberById(id);
        return balneario.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/status-miembro")
    public ResponseEntity<List<Member>> buscarPorStatusMiembro(@RequestParam MemberStatus statusMiembro){
        List<Member> miembros = miembroService.buscarPorStatusMiembro(statusMiembro);
        return ResponseEntity.ok(miembros);
    }
}
