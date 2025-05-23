package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException {
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, username, password);
    }

    private void executeStatement(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws Exception {

            String sql = String.format(
                    "CREATE TABLE IF NOT EXISTS %s ()",
                    tableName
            );
            executeStatement(sql);
            System.out.println(getTableScheme(tableName));
    }

    public void dropTable(String tableName)  throws Exception {

            String sql = String.format(
                    "DROP TABLE %s",
                    tableName
            );
            executeStatement(sql);
            System.out.println("table deleted");
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {

            String sql = String.format(
                    "ALTER TABLE %s ADD COLUMN %s %s",
                    tableName,
                    columnName,
                    type
            );
            executeStatement(sql);
            System.out.println(getTableScheme(tableName));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {

            String sql = String.format(
                    "ALTER TABLE %s DROP COLUMN %s",
                    tableName,
                    columnName
            );
            executeStatement(sql);
            System.out.println(getTableScheme(tableName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {

            String sql = String.format(
                    "ALTER TABLE %s RENAME COLUMN %s TO %s",
                    tableName,
                    columnName,
                    newColumnName
            );
            executeStatement(sql);
            System.out.println(getTableScheme(tableName));
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            TableEditor table = new TableEditor(config);
            table.createTable("shops");
            table.addColumn("shops", "name_shop", "varchar(255)");
            table.addColumn("shops", "type", "varchar(255)");
            table.renameColumn("shops", "type", "type_shop");
            table.dropColumn("shops", "type_shop");
            table.dropTable("shops");
            table.close();
        }
    }
}
