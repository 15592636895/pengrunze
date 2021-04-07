package com.example.myapplication.entity;

public enum Column {
    COLUMN0("id","编号"),
    COLUMN1("name","姓名"),
    COLUMN2("pwd","密码"),
    COLUMN3("gender","性别"),
    COLUMN4("hobby","爱好"),
    COLUMN5("origin","籍贯"),
    ;
    String columnName;
    String columnDesc;

         Column(String columnName,String columnDesc){
              this.columnName=columnName;
              this.columnDesc=columnDesc;
    }

    public String getColumnName() {
        return columnName;
    }
}
