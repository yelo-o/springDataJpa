package me.whiteship.springdatademo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class Account {
    @Id @GeneratedValue
    private Long id; //새로만든 어카운트는 레퍼런스가 0이 아니라 null 이므로 테이블에 id가 0인 레코드를 가진 어카운트랑 새로 만든 어카운트랑 완벽히 구분

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "owner") //mappedBy를 해야 쓸모없는 테이블이 하나 더 안 생김 (account_studies 와 같은), mappedBy 없으면 양방향 관계가 아니라 두 개의 단방향 관계
    private Set<Study> studies = new HashSet<>();

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date created = new Date();
//
//    private String yes;
//    @Transient
//    private String no;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name="street", column = @Column(name = "home_street"))
//    })
//    private Address address;




}
