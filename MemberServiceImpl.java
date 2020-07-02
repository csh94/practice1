package swan.spring.member.service;

import org.springframework.stereotype.Service;

import swan.spring.member.vo.MemberVO;
import swan.spring.member.vo.UpdateInfo;
@Service
public class MemberServiceImpl implements MemberService {
	
	
    public MemberServiceImpl() {
    }

	@Override
	public void regist(MemberVO member) {
		System.out.println("MemberServiceImpl.regist() 메서드 실행");
	}

	@Override
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("MemberServiceImpl.update() 메서드 실행");
		return true;
	}

}
