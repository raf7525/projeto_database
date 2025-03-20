package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hospital.santajoana.domain.entity.Produto;

public class ProdutoRepository extends BaseRepository<Produto> {

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "produto", (rs, rowNum) -> new Produto(
            // Map the fields once Produto class is implemented
        ));
    }

    public Produto save(Produto produto) {
        String insertSql = "INSERT INTO produto (...) VALUES (...)";
        // Implement once Produto class has fields defined
        return null;
    }

    public Produto findById(Long id) {
        return super.findById("id_produto", id);
    }

    public void delete(Long id) {
        super.delete("id_produto", id);
    }
}
