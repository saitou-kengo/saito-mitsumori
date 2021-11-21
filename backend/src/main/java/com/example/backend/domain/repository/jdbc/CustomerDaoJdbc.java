package com.example.backend.domain.repository.jdbc;

import java.util.List;

import com.example.backend.constants.Constants;
import com.example.backend.domain.model.MstCustomer;
import com.example.backend.domain.repository.dao.CustomerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomerDaoJdbc implements CustomerDao{
    
    @Autowired
    JdbcTemplate jdbc;

    //指定したIDのデータを取得
    public MstCustomer selectOne(int cd) {
        String tableName = Constants.db.MST_CUSTOMER_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName + "WHERE cd = ?";

        RowMapper<MstCustomer> rowMapper = new BeanPropertyRowMapper<>(MstCustomer.class);
        return jdbc.queryForObject(sql, rowMapper, cd);
    }

    //指定した文字列に部分一致するデータを取得
    public List<MstCustomer> selectLikeList(String likeStr) {
        String tableName = Constants.db.MST_CUSTOMER_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName + "WHERE name LIKE ?";

        RowMapper<MstCustomer> rowMapper = new BeanPropertyRowMapper<>(MstCustomer.class);
        return jdbc.query(sql, rowMapper, likeStr);
    }

    //全てのデータを取得
    public List<MstCustomer> selectAll() {
        String tableName = Constants.db.MST_CUSTOMER_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName;

        RowMapper<MstCustomer> rowMapper = new BeanPropertyRowMapper<>(MstCustomer.class);
        return jdbc.query(sql, rowMapper);
    }
}
