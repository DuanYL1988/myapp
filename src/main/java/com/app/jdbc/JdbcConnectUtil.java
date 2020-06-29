package com.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class JdbcConnectUtil {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";

    private static final String USERNAME = "fireemblem";

    private static final String PASSWORD = "fireemblem";

    private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/duanyl?serverTimezone=JST";

    private static final String USERNAME_MYSQL = "root";

    private static final String PASSWORD_MYSQL = "root";

    private static final String TAB = "\t";

    private Connection conn;

    private Statement st;

    public static int DB_ORACLE = 1;

    public static int DB_MYSQL = 2;

    public int mode = 2;

    /**
     * 执行SQL
     *
     * @param query
     */
    public List<Map<String, String>> excuteSelectQuery(String query) {
        ResultSet result = excuteQuery(query);
        String[] cols = getColumns(result);
        List<Map<String, String>> rst = new ArrayList<Map<String, String>>();
        try {
            while (result.next()) {
                Map<String, String> values = new HashMap<String, String>();
                for (int i = 1; i <= cols.length; i++) {
                    // 字段属性
                    String key = result.getMetaData().getColumnName(i);
                    String val = "";
                    // 取得字段值
                    val = result.getString(i);
                    // 控制台输出结果
                    System.out.print(val + TAB);
                    // Map<数据库字段名,单元格值>
                    values.put(key, val);
                }
                // 换行
                System.out.println();
                // [<col1,val>,<col2,val>]这样存放检索出的数据
                rst.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rst;
    }

    public Boolean excuteInsertOrUpdateSQL(String sql) {
        getStatement();
        Boolean result = null;
        try {
            result = st.execute(sql);
        } catch (SQLException e) {
            System.out.println("-> Excute SQL Error!");
        }
        closeConnection();
        return result;
    }

    private ResultSet excuteQuery(String query) {
        getStatement();
        ResultSet result = null;
        try {
            System.out.println(query);
            result = st.executeQuery(query);
            System.out.println("-> Excute SQL SUCCESS!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("-> Excute SQL Error!");
            System.out.println("-> SQL : " + query);
        }
        return result;
    }

    private void getStatement() {
        getConnection();
        try {
            st = conn.createStatement();
            System.out.println("-> Create Statement SUCCESS");
        } catch (SQLException e) {
            System.out.println("-> Create Statement Error!");
        }
    }

    /**
     * Get Database Connection
     */
    private void getConnection() {
        try {
            if (mode == 1) {
                System.out.println("-> CONNECT TO ORACLE");
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } else {
                System.out.println("-> CONNECT TO MYSQL");
                Class.forName(DRIVER_MYSQL);
                conn = DriverManager.getConnection(URL_MYSQL, USERNAME_MYSQL,
                        PASSWORD_MYSQL);
            }
        } catch (SQLException e) {
            System.out.println("-> Get Connection Error!");
        } catch (ClassNotFoundException e) {
            System.out.println("-> Load Oracle Driver Error!");
        }
    }

    /**
     * Close DB Connection
     */
    private void closeConnection() {
        try {
            if (null != st) {
                st.close();
            }
            if (null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get Select Columns
     *
     * @param query
     * @return
     */
    private String[] getColumns(ResultSet result) {
        String[] cols = null;
        try {
            // 取得SQL结果列数
            int colCount = result.getMetaData().getColumnCount();
            cols = new String[colCount];
            for (int i = 0; i < colCount; i++) {
                // 取得列名
                cols[i] = result.getMetaData().getColumnName(i + 1);
            }
        } catch (SQLException e) {
            System.out.println("->ResultSet.getColumnName Error!!");
        }
        if (null!=cols) {
            for (String col : cols) {
                System.out.print(col + TAB);
            }
        }
        System.out.println("\r" + "---------------------------------------------------");
        return cols;
    }

    /**
     * 执行Desc SQL取得Entity所有字段信息 只能执行DESC 文,请注意
     *
     * @param descQuery
     * @return
     */
    public List<FieldInfo> getFieldInfo(String tableName) {
        // 数据库判断
        String descQuery = "";
        if (DB_MYSQL == this.mode) {
            descQuery = "DESC " + tableName;
        } else if (DB_ORACLE == this.mode) {
            // oracle时查询表结构SQL文
            StringBuilder query = new StringBuilder();
            query.append("SELECT COLUMN_NAME");
            query.append(",DATA_TYPE AS COLUMN_TYPE");
            query.append(",NULLABLE AS IS_NULLABLE");
            query.append(",'' AS COLUMN_KEY");
            query.append(",DATA_DEFAULT AS COLUMN_DEFAULT");
            query.append(",'' AS EXTRA ");
            query.append("FROM USER_TAB_COLS ");
            query.append("WHERE TABLE_NAME ='"+tableName+"'");
            descQuery = query.toString();
            System.out.println(descQuery);
        }

        // 执行sql
        List<Map<String,String>> rows = excuteSelectQuery(descQuery);

        List<FieldInfo> fields = new ArrayList<FieldInfo>();
        for (Map<String,String> row : rows) {
            Set<String> keySet = row.keySet();
            FieldInfo field = new FieldInfo();
            for(String key : keySet) {
                String value = row.get(key);
                if ("COLUMN_NAME".equals(key)) {
                    field.setName(value);
                } else if ("COLUMN_TYPE".equals(key)) {
                    if (value.indexOf("(") > 0) {
                        String type = value.substring(0, value.indexOf("("));
                        int size = Integer.parseInt(value.substring(value.indexOf("(") + 1, value.indexOf(")")));
                        field.setType(type);
                        field.setSize(size);
                    } else {
                        field.setType(value);
                    }
                } else if ("IS_NULLABLE".equals(key)) {
                    boolean isNull = false;
                    if ("YES".equals(value)) {
                        isNull = true;
                    }
                    field.setNull(isNull);
                } else if ("COLUMN_KEY".equals(key)) {
                    field.setKeyInfo(value);
                } else if ("COLUMN_DEFAULT".equals(key)) {
                    field.setDefaultValue(value);
                } else if ("EXTRA".equals(key)) {
                    field.setExtra(value);
                }
            }
            fields.add(field);
        }
        return fields;
    }

}
