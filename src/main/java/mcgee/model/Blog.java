package mcgee.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Getter;
import mcgee.provider.IndexNameProvider;

import lombok.Setter;

@Setter
@Getter
//@Document(indexName = "blog-#{@IndexNameProvider.timeSuffix()}")
//@Document(indexName = "blog-#{T(java.time.LocalDate).now().toString()}")
@Document(indexName = "blog", shards = 1, replicas = 0)
public class Blog {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String content;

    /*
    @Field(type = FieldType.Date)
    private Date log_date;

    @Field(type = FieldType.Text)
    private String log_text;

    @Field(type = FieldType.Long)
    private Long price;
     */

}
