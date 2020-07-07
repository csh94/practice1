package swan.spring.member.service;

import swan.spring.member.vo.MemberVO;
import swan.spring.member.vo.UpdateInfo;

public interface MemberService {
	void regist(MemberVO member);
	boolean update(String memberId, UpdateInfo info);
}
