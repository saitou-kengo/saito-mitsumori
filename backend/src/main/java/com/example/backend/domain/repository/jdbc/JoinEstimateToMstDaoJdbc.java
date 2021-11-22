package com.example.backend.domain.repository.jdbc;

import java.util.List;

import com.example.backend.constants.Constants;
import com.example.backend.domain.model.JoinEstimateToMst;
import com.example.backend.domain.repository.dao.JoinEstimateToMstDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JoinEstimateToMstDaoJdbc implements JoinEstimateToMstDao {

    @Autowired
    JdbcTemplate jdbc;

    //全てのデータを取得
    public List<JoinEstimateToMst> selectAll() {
        String estimateTblName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String customerTblName = Constants.db.MST_CUSTOMER_TBL_NAME.getlabel();
        String employeeTblName = Constants.db.MST_EMPLOYEE_TBL_NAME.getlabel();
        String sql = "SELECT " + estimateTblName + ".*, "+ customerTblName + ".name, " + employeeTblName + ".name "
            + " FROM " + estimateTblName
            + " INNER JOIN " + customerTblName
            + " ON " + estimateTblName + ".customer_cd = " + customerTblName + ".cd"
            + " INNER JOIN " + employeeTblName
            + " ON " + estimateTblName + ".employee_cd = " + employeeTblName + ".cd";

        RowMapper<JoinEstimateToMst> rowMapper = new BeanPropertyRowMapper<>(JoinEstimateToMst.class);
        return jdbc.query(sql, rowMapper);
    }

    //指定したIDのデータを取得
    public JoinEstimateToMst selectOne(int id) {
        String estimateTblName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String customerTblName = Constants.db.MST_CUSTOMER_TBL_NAME.getlabel();
        String employeeTblName = Constants.db.MST_EMPLOYEE_TBL_NAME.getlabel();
        String sql = "SELECT " + estimateTblName + ".*, "+ customerTblName + ".name, " + employeeTblName + ".name "
            + " FROM " + estimateTblName
            + " INNER JOIN " + customerTblName
            + " ON " + estimateTblName + ".customer_cd = " + customerTblName + ".cd"
            + " INNER JOIN " + employeeTblName
            + " ON " + estimateTblName + ".employee_cd = " + employeeTblName + ".cd"
            + " WHERE id = ?";

        RowMapper<JoinEstimateToMst> rowMapper = new BeanPropertyRowMapper<>(JoinEstimateToMst.class);
        return jdbc.queryForObject(sql, rowMapper, id);
    }

    //指定した文字列に部分一致する案件名のデータを取得
    public List<JoinEstimateToMst> selectLikeEstimateNameList(String likeEstimateName) {
        String estimateTblName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String customerTblName = Constants.db.MST_CUSTOMER_TBL_NAME.getlabel();
        String employeeTblName = Constants.db.MST_EMPLOYEE_TBL_NAME.getlabel();
        String sql = "SELECT " + estimateTblName + ".*, "+ customerTblName + ".name, " + employeeTblName + ".name "
            + " FROM " + estimateTblName
            + " INNER JOIN " + customerTblName
            + " ON " + estimateTblName + ".customer_cd = " + customerTblName + ".cd"
            + " INNER JOIN " + employeeTblName
            + " ON " + estimateTblName + ".employee_cd = " + employeeTblName + ".cd"
            + " WHERE estimate_name LIKE ?";

        RowMapper<JoinEstimateToMst> rowMapper = new BeanPropertyRowMapper<>(JoinEstimateToMst.class);
        return jdbc.query(sql, rowMapper, likeEstimateName);
    }

    //指定した文字列に部分一致する顧客名のデータを取得
    public List<JoinEstimateToMst> selectLikeCustomerNameList(String likeCustomerName) {
        String estimateTblName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String customerTblName = Constants.db.MST_CUSTOMER_TBL_NAME.getlabel();
        String employeeTblName = Constants.db.MST_EMPLOYEE_TBL_NAME.getlabel();
        String sql = "SELECT " + estimateTblName + ".*, "+ customerTblName + ".name, " + employeeTblName + ".name "
            + " FROM " + estimateTblName
            + " INNER JOIN " + customerTblName
            + " ON " + estimateTblName + ".customer_cd = " + customerTblName + ".cd"
            + " INNER JOIN " + employeeTblName
            + " ON " + estimateTblName + ".employee_cd = " + employeeTblName + ".cd"
            + " WHERE customer_name LIKE ?";
    
        RowMapper<JoinEstimateToMst> rowMapper = new BeanPropertyRowMapper<>(JoinEstimateToMst.class);
        return jdbc.query(sql, rowMapper, likeCustomerName);
    }

    //指定した文字列に部分一致する担当者名のデータを取得
    public List<JoinEstimateToMst> selectLikeEmployeeNameList(String likeEmployeeName) {
        String estimateTblName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String customerTblName = Constants.db.MST_CUSTOMER_TBL_NAME.getlabel();
        String employeeTblName = Constants.db.MST_EMPLOYEE_TBL_NAME.getlabel();
        String sql = "SELECT " + estimateTblName + ".*, "+ customerTblName + ".name, " + employeeTblName + ".name "
            + " FROM " + estimateTblName
            + " INNER JOIN " + customerTblName
            + "ON " + estimateTblName + ".customer_cd = " + customerTblName + ".cd"
            + " INNER JOIN " + employeeTblName
            + "ON " + estimateTblName + ".employee_cd = " + employeeTblName + ".cd"
            + " WHERE employee_name LIKE ?";

        RowMapper<JoinEstimateToMst> rowMapper = new BeanPropertyRowMapper<>(JoinEstimateToMst.class);
        return jdbc.query(sql, rowMapper, likeEmployeeName);
    }

    //指定した文字列に部分一致する担当者名のデータを取得
    public List<JoinEstimateToMst> selectLikeStatusList(String likeStatus) {
        String estimateTblName = Constants.db.ESTIMATE_TBL_NAME.getlabel();
        String customerTblName = Constants.db.MST_CUSTOMER_TBL_NAME.getlabel();
        String employeeTblName = Constants.db.MST_EMPLOYEE_TBL_NAME.getlabel();
        String sql = "SELECT " + estimateTblName + ".*, "+ customerTblName + ".name, " + employeeTblName + ".name "
            + " FROM " + estimateTblName
            + " INNER JOIN " + customerTblName
            + "ON " + estimateTblName + ".customer_cd = " + customerTblName + ".cd"
            + " INNER JOIN " + employeeTblName
            + "ON " + estimateTblName + ".employee_cd = " + employeeTblName + ".cd"
            + " WHERE status LIKE ?";

        RowMapper<JoinEstimateToMst> rowMapper = new BeanPropertyRowMapper<>(JoinEstimateToMst.class);
        return jdbc.query(sql, rowMapper, likeStatus);
    }
}
