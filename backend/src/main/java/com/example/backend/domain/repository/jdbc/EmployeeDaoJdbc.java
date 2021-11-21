package com.example.backend.domain.repository.jdbc;

import java.util.List;

import com.example.backend.constants.Constants;
import com.example.backend.domain.model.MstEmployee;
import com.example.backend.domain.repository.dao.EmployeeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDaoJdbc implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbc;

    //指定したIDのデータを取得
    public MstEmployee selectOne(int cd) {
        String tableName = Constants.db.MST_EMPLOYEE_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName + "WHERE cd = ?";

        RowMapper<MstEmployee> rowMapper = new BeanPropertyRowMapper<>(MstEmployee.class);
        return jdbc.queryForObject(sql, rowMapper, cd);
    }

    //指定した文字列に部分一致するデータを取得
    public List<MstEmployee> selectLikeList(String likeStr) {
        String tableName = Constants.db.MST_EMPLOYEE_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName + "WHERE name LIKE ?";

        RowMapper<MstEmployee> rowMapper = new BeanPropertyRowMapper<>(MstEmployee.class);
        return jdbc.query(sql, rowMapper, likeStr);
    }

    //全てのデータを取得
    public List<MstEmployee> selectAll() {
        String tableName = Constants.db.MST_EMPLOYEE_TBL_NAME.getlabel();
        String sql = "SELECT * FROM " + tableName;

        RowMapper<MstEmployee> rowMapper = new BeanPropertyRowMapper<>(MstEmployee.class);
        return jdbc.query(sql, rowMapper);
    }
}
