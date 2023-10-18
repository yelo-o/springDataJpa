package me.whiteship.springdatademo;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // post, comment 생성 테스트
//        Post post = new Post();
//        post.setTitle("Spring Data Jpa 언제 보나요..?");
//
//        Comment comment = new Comment();
//        comment.setComment("빨리 보고 싶어요 흑흑");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("빨리 보고 싶어요 흑흑");
//        post.addComment(comment1);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(post);


        //post, comment 삭제 테스트
//        Session session = entityManager.unwrap(Session.class);
//        Post post = session.get(Post.class, 4L);
//        session.delete(post);

        //jpql로 작성
//        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
//        List<Post> posts = query.getResultList();
//        posts.forEach(System.out::println);

        //criteria로 작성
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);

        List<Post> posts = entityManager.createQuery(query).getResultList();
        posts.forEach(System.out::println);
    }
}
