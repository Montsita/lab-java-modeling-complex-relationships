package service;

import enums.Status;
import model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() { return memberRepository.findAll(); }

    public Optional<Member> getMemberById(Long id){ return memberRepository.findById(id); }

    public List<Member> buscarPorStatusMiembro(Status statusMiembro) {
        return memberRepository.findByStatus(statusMiembro);
    }
}
