package swan.spring.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import swan.spring.board.service.WriteArticleService;
import swan.spring.board.vo.ArticleVO;
import swan.spring.member.service.MemberService;
import swan.spring.member.vo.MemberVO;

public class MainThree {
	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContextThree.xml");
		WriteArticleService articleService =
				factory.getBean("writeArticleServiceImpl", WriteArticleService.class);
		articleService.write(new ArticleVO());
		
		MemberService memberService = 
				factory.getBean("memberServiceImpl", MemberService.class);
		memberService.regist(new MemberVO());
		factory.close();
	}
}
