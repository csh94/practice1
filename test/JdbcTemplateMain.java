package swan.spring.guestbook.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import swan.spring.guestbook.dao.jdbcTemplateGuestMessageDao;
import swan.spring.guestbook.vo.GuestMessage;

public class JdbcTemplateMain {
	private GuestMessage makeGuestMessage(String guestName, String message) {
		GuestMessage msg = new GuestMessage();
		msg.setGuestName(guestName);
		msg.setMessage(message);
		msg.setRegistryDate(new Date());
		return msg;
	}
	public static void main(String[] args) {
		String[] configLocations = new String[] {"applicationContext.xml"};
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext(configLocations);
		jdbcTemplateGuestMessageDao dao =
				context.getBean("jdbcTemplateGuestMessageDao", jdbcTemplateGuestMessageDao.class);
		JdbcTemplateMain myTest = new JdbcTemplateMain();
		dao.insert(myTest.makeGuestMessage("나", "나나나나"));
		dao.insert(myTest.makeGuestMessage("너", "너너너너"));
		dao.insert(myTest.makeGuestMessage("유", "유유유유"));
		
		int count = dao.count();
		System.out.println("전체글 수 : " + count);
		List<GuestMessage> list = dao.select(1, count);
		for(GuestMessage msg : list) {
			System.out.println(msg.getId() + " : " + msg.getGuestName() + " : " +
					msg.getMessage() + " : " + msg.getRegistryDate());
		}
		context.close();
	}
}
