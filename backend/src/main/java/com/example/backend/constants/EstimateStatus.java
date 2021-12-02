package com.example.backend.constants;

public enum EstimateStatus {
    MAKING(1, "1:見積中"),
    COMPLETION(2, "2:見積完了"),
    ORDERED(3, "3:受注中");

    private int id;
    private String label;

    private EstimateStatus(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }
    public String getlabel() {
        return label;
    }

    public static EstimateStatus findByIndex(int id) {
        for(EstimateStatus statsu : values()) {
            if (id == statsu.getId()) {
                return statsu;
            }
        }
        return null;
    }
}
