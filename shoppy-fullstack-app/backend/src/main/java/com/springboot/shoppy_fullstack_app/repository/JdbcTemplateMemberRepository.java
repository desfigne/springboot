package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository // jdbcTemplateMemberRepository
public class JdbcTemplateMemberRepository implements MemberRepository {
    private final JdbcTemplate jdbcTemplate;
//    private String name;
    // 생성자
    public JdbcTemplateMemberRepository(DataSource dataSource) {
//        this.name = name;
        this.jdbcTemplate = new JdbcTemplate(dataSource); // 커넥션 생성
    }

    @Override
    public int save(Member member) {
        // jdbc 객체를 이용하여 DB의 member 테이블에 insert
        String sql="insert into member(id, pwd, name, phone, email, mdate) values (?, ?, ?, ?, ?, now())"; // preparedStatement
        Object[] param = {
                member.getId(),
                member.getPwd(),
                member.getName(),
                member.getPhone(),
                member.getEmail()
        };
        int rows = jdbcTemplate.update(sql, param);
        return rows;
    }

    @Override
    public Long findById(String id) {
        String sql = "SELECT count(id) from member where id=?;";
        Long count = jdbcTemplate.queryForObject(sql, Long.class, id);
        return count;
    }
}
