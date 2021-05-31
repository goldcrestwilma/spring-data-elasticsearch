package mcgee.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import mcgee.model.Blog;

@Repository
public interface BlogEsRepository extends ElasticsearchRepository<Blog, String> {

    List<Blog> findByTitle(String title);

}
