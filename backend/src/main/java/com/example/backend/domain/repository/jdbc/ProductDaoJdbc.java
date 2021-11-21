package com.example.backend.domain.repository.jdbc;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.example.backend.constants.Constants;
import com.example.backend.domain.model.MstProduct;
import com.example.backend.domain.repository.dao.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductDaoJdbc implements ProductDao {

    @Autowired
    JdbcTemplate jdbc;

    //指定したIDのデータを取得
    public MstProduct selectOne(int cd) {
        String tableName = Constants.db.MST_PRODUCT_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName + "WHERE cd = ?";

        RowMapper<MstProduct> rowMapper = new BeanPropertyRowMapper<>(MstProduct.class);
        return jdbc.queryForObject(sql, rowMapper, cd);
    }

    //指定した文字列に部分一致するデータを取得
    public List<MstProduct> selectLikeList(String likeStr) {
        String tableName = Constants.db.MST_PRODUCT_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName + "WHERE name LIKE ?";

        RowMapper<MstProduct> rowMapper = new BeanPropertyRowMapper<>(MstProduct.class);
        return jdbc.query(sql, rowMapper, likeStr);
    }

    //全てのデータを取得
    public List<MstProduct> selectAll() {
        String tableName = Constants.db.MST_PRODUCT_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName;

        RowMapper<MstProduct> rowMapper = new BeanPropertyRowMapper<>(MstProduct.class);
        return jdbc.query(sql, rowMapper);
    }
    
}
