package mcgee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;

import javax.annotation.Resource;

import org.elasticsearch.index.query.QueryBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mcgee.model.Blog;
import mcgee.repository.BlogEsRepository;


import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ElasticsearchTest {
    @Resource
    BlogEsRepository blogEsRepository;

    @Test
    @DisplayName("ES 저장하기")
    void save() {
        Blog blog = new Blog();
        blog.setId("2");
        blog.setContent("content");
        blog.setTitle("title2");
        Blog indexedBlog = blogEsRepository.save(blog);

        assertThat(indexedBlog).isNotNull();
        assertThat(indexedBlog.getId()).isEqualTo(blog.getId());
    }

    @Test
    @DisplayName("제목으로 찾기")
    void findByTitle() {
        List<Blog> blogList = blogEsRepository.findByTitle("title2");

        assertThat(blogList.size()).isEqualTo(3);
    }

}
