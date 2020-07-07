package swan.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swan.spring.board.dao.ArticleDAO;
import swan.spring.board.vo.ArticleVO;


@Service
public class WriteArticleServiceImpl implements WriteArticleService {
	@Autowired
	private ArticleDAO articleDao;


	@Override
	public void write(ArticleVO article) {
		System.out.println("WriteArticleServiceImpl.write() 메서드 실행");
		articleDao.insert(article);
	}

}
