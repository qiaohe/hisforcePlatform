package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Johnson on 2015/11/18.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    public List<Article> findByHospitalId(Long hospitalId);
}
