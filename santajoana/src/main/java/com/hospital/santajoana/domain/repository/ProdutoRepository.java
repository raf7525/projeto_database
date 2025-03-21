package com.hospital.santajoana.domain.repository;

import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hospital.santajoana.domain.entity.Produto;

@Repository
public class ProdutoRepository extends BaseRepository<Produto> {

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        super("PRODUTO","ID_PRODUTP",jdbcTemplate, (rs, rowNum) -> new Produto(
            rs.getLong("ID_PRODUTO"),
            rs.getString("NOME"),
            rs.getString("DESCRICAO"),
            rs.getBigDecimal("PRECO")
        ));
    }

    public Produto save(Produto produto) {
        String insertSql = "INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertSql,
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco());
        return produto;
    }

    public Optional<Produto> findById(Long id) {
        return super.findById(id);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Produto update(Produto produto) {
        String updateSql = "UPDATE PRODUTO SET NOME = ?, DESCRICAO = ?, PRECO = ? WHERE ID_PRODUTO = ?";
        jdbcTemplate.update(updateSql,
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getId()
        );
        return produto;
    }
}
