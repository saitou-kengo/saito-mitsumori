package com.example.backend.constants;

public class Constants {
    private Constants() {

    }

    public enum db {
        DB_NAME("test"),
        ESTIMATE_TBL_NAME("estimates"),
        ESTIMATE_DETAIL_TBL_NAME("estimate_details"),
        MST_PRODUCT_TBL_NAME("mst_products"),
        MST_EMPLOYEE_TBL_NAME("mst_employees"),
        MST_CUSTOMER_TBL_NAME("mst_customer");

        private String label;

        db(String label) {
            this.label = label;
        }

        public String getlabel() {
            return label;
        }
    }
}
