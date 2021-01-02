package com.example.demo.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfigDataBase {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306?serverTimezone=GMT%2B8";
    //static final String DB_URL = "jdbc:mysql://localhost:3306";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";
    private static Connection mconn=null;
    private static Statement mstmt=null;
    public static void Initial() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName ( "com.mysql.jdbc.Driver" );
            // Class.forName ( "com.mysql.cj.jdbc.Driver" );
            // 打开链接
            System.out.println ( "连接数据库..." );
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println ( " 实例化Statement对象..." );
            stmt = conn.createStatement ();

            mconn=conn;
            mstmt=mstmt;

            CreateDb ( stmt );
            CerateTableLogin(stmt);
            CerateTableComments(stmt);
            CreateStudent(stmt);
            CreateStudentScore(stmt);
            CreateAnnonucement(stmt);
            CreateTeacher(stmt);
            CreateTeacherInfo(stmt);
            CreateApplyCourse(stmt);

            stmt.close ();
            conn.close ();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace ();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace ();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close ();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close ();
            } catch (SQLException se) {
                se.printStackTrace ();
            }
        }
        System.out.println ( "Goodbye!" );
    }
    private  static  void  CreateDb(Statement stmt) throws SQLException {
        String allSql ="CREATE DATABASE IF NOT EXISTS SchoolDB";

        int m = (int) stmt.executeUpdate ( allSql );
        if (m == 0) {
            System.out.print ( " 创建数据库成功......" );
        } else {
            System.out.print ( " 创建数据库失败......" );
        }
    }

    private  static  void CerateTableComments( Statement stmt ) throws SQLException {
        String useDb="use SchoolDB";
        stmt.executeLargeUpdate ( useDb );
        String sql="  CREATE TABLE IF NOT EXISTS Comment (\n" +
                "  id INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  publishedTime DATETIME ,\n" +
                "  userId INT(11) NOT NULL,\n" +
                "  title VARCHAR(100) DEFAULT NULL,\n" +
                "  content VARCHAR(2000) DEFAULT NULL,\n" +
                "  replyId INT(11) DEFAULT NULL,\n" +
                " foreign key(userId) references Login(id),\n" +
                "  PRIMARY KEY (id)\n" +
                ") ENGINE=InnoDB";
        int m = (int) stmt.executeLargeUpdate ( sql );
        if (m == 0) {
            System.out.print ( " 创建数据库表（Comment）成功......" );
        } else {
            System.out.print ( " 创建数据库（Comment）失败......" );
        }
    }


    private  static  void CerateTableLogin( Statement stmt ) throws SQLException {
        String useDb="use SchoolDB";
        stmt.executeLargeUpdate ( useDb );
        String sql="CREATE TABLE IF NOT EXISTS Login (\n" +
                "  id INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  registTime DATETIME ,\n" +
                " name VARCHAR(20) NOT NULL,\n"+
                " nick VARCHAR(20) Default NULL,\n"+
                " saying VARCHAR(100) Default NULL,\n"+
                " Pwd VARCHAR(20) NOT NULL,\n"+
                " PhoneNumber VARCHAR(20) NOT NULL unique,\n"+
                " Photo VARCHAR(20) Default NULL,\n"+
                " Role ENUM('Normal','Admin','Teacher') NOT NULL DEFAULT 'Normal',\n" +
                "  PRIMARY KEY (id)\n" +
                ") ENGINE=InnoDB";
        int m = (int) stmt.executeLargeUpdate ( sql );
        if (m == 0) {
            System.out.print ( " 创建数据库表（Login）成功......" );
        } else {
            System.out.print ( " 创建数据库表（Login）失败......" );
        }
    }

    private static  void CreateStudent( Statement stmt)throws SQLException
    {
        String useDb="use SchoolDB";
        stmt.executeLargeUpdate ( useDb );
        String sql=" CREATE TABLE IF NOT EXISTS students (\n" +
                " id INT(11) NOT NULL AUTO_INCREMENT,\n" +
                " regDate DATETIME ,\n" +
                " name VARCHAR(20) NOT NULL,\n"+
                //" phoneNumber VARCHAR(20) NOT NULL,\n"+
                " ident VARCHAR(20) NOT NULL unique,\n"+
                " number VARCHAR(20),\n"+
                " submitPhone VARCHAR(20) NULL,\n"+
                "  PRIMARY KEY (id)\n" +
                ") ENGINE=InnoDB";
        int m = (int) stmt.executeLargeUpdate ( sql );
        if (m == 0) {
            System.out.print ( " 创建数据库表（Student）成功......" );
        } else {
            System.out.print ( " 创建数据库表（Student）失败......" );
        }
    }

    private static  void CreateAnnonucement( Statement stmt)throws SQLException
    {
        String useDb="use SchoolDB";
        stmt.executeLargeUpdate ( useDb );
        String sql=" CREATE TABLE IF NOT EXISTS announcement (\n" +
                " id INT(11) NOT NULL AUTO_INCREMENT,\n" +
                " publish DATETIME ,\n" +
                " title VARCHAR(20) not NULL,\n"+
                " content VARCHAR(1000) not NULL,\n"+
                " imgurl VARCHAR(200)  NULL,\n"+
                "type ENUM('announce','new') NOT NULL DEFAULT 'new',\n"+
                " Phone VARCHAR(20) NULL,\n"+
                " PRIMARY KEY (id)\n" +
                ") ENGINE=InnoDB";
        int m = (int) stmt.executeLargeUpdate ( sql );
        if (m == 0) {
            System.out.print ( " 创建数据库表（Annonucement）成功......" );
        } else {
            System.out.print ( " 创建数据库表（Annonucement）失败......" );
        }
    }
    private static  void CreateTeacher( Statement stmt)throws SQLException
    {
        String useDb="use SchoolDB";
        stmt.executeLargeUpdate ( useDb );
        String sql=" CREATE TABLE IF NOT EXISTS teachers (\n" +
                " id INT(11) NOT NULL AUTO_INCREMENT,\n" +
                " name VARCHAR(20) not NULL,\n"+
                " pwd VARCHAR(20) not NULL,\n"+
                " subject VARCHAR(20) not NULL,\n"+
                " number VARCHAR(20) not NULL,\n"+
                " imgurl VARCHAR(100)  NULL,\n"+
                "pass ENUM('NO','YES') NOT NULL DEFAULT 'NO',\n"+
                " tel VARCHAR(12) NULL,\n"+
                " PRIMARY KEY (id)\n" +
                ") ENGINE=InnoDB";
        int m = (int) stmt.executeLargeUpdate ( sql );
        if (m == 0) {
            System.out.print ( " 创建数据库表（teachers）成功......" );
        } else {
            System.out.print ( " 创建数据库表（teachers）失败......" );
        }
    }


    private static  void CreateApplyCourse( Statement stmt)throws SQLException
    {
        String useDb="use SchoolDB";
        stmt.executeLargeUpdate ( useDb );
        String sql=" CREATE TABLE IF NOT EXISTS ApplyCourse (\n" +
                " id INT(11) NOT NULL AUTO_INCREMENT,\n" +
                " tname VARCHAR(20) not NULL,\n"+
                " tnumber VARCHAR(20) not NULL,\n"+
                " stuname VARCHAR(20) not NULL,\n"+
                " stunumber VARCHAR(20) not NULL,\n"+
                " tsubject VARCHAR(20) not NULL,\n"+
                " date VARCHAR(30),\n"+
                " tnum  int  not null,\n"+
                "statusenum ENUM('NO','YES') NOT NULL DEFAULT 'NO',\n"+
                "PRIMARY KEY (id)\n" +
                ") ENGINE=InnoDB";
        int m = (int) stmt.executeLargeUpdate ( sql );
        if (m == 0) {
            System.out.print ( " 创建数据库表（ApplyCourse）成功......" );
        } else {
            System.out.print ( " 创建数据库表（ApplyCourse）失败......" );
        }
    }





    private static  void CreateTeacherInfo( Statement stmt)throws SQLException
    {
        String useDb="use SchoolDB";
        stmt.executeLargeUpdate ( useDb );
        String sql=" CREATE TABLE IF NOT EXISTS teacherInfo (\n" +
                " id INT(11) NOT NULL AUTO_INCREMENT,\n" +
                " name VARCHAR(20) not NULL,\n"+
                " subject VARCHAR(20) not NULL,\n"+
                " number VARCHAR(20) not NULL,\n"+
                " imgurl VARCHAR(100)  NULL,\n"+
                "profile VARCHAR(1000)  NULL,\n"+
                "experience VARCHAR(1000)  NULL,\n"+
                "successfulCase VARCHAR(1000)  NULL,\n"+
                " tel VARCHAR(12) NULL,\n"+
                " PRIMARY KEY (id)\n" +
                ") ENGINE=InnoDB";
        int m = (int) stmt.executeLargeUpdate ( sql );
        if (m == 0) {
            System.out.print ( " 创建数据库表（teachers）成功......" );
        } else {
            System.out.print ( " 创建数据库表（teachers）失败......" );
        }
    }

    private static  void CreateStudentScore2( Statement stmt)throws SQLException
    {
        String useDb="use SchoolDB";
        stmt.executeLargeUpdate ( useDb );
        String sql=" CREATE TABLE IF NOT EXISTS StudentScore (\n" +
                " id INT(11) NOT NULL AUTO_INCREMENT,\n" +
                " scoreDate DATE,\n" +
                " ident VARCHAR(20) NOT NULL,\n"+
                " name VARCHAR(20),\n"+
                " score INT(11) NOT NULL,\n"+
                " subject VARCHAR(20) NOT NULL,\n"+
                " class VARCHAR(20), \n"+
                " classId VARCHAR(20) NULL,\n"+
                " submitAuthor VARCHAR(20) NULL,\n"+
                " StduentId VARCHAR(20) Default NULL,\n"+
                " SchoolName VARCHAR(20) Default NULL,\n"+
                "  PRIMARY KEY (id)\n" +
                ") ENGINE=InnoDB";
        int m = (int) stmt.executeLargeUpdate ( sql );
        if (m == 0) {
            System.out.print ( " 创建数据库表（StudentScore）成功......" );
        } else {
            System.out.print ( " 创建数据库表（StudentScore）失败......" );
        }
    }


    private static  void CreateStudentScore( Statement stmt)throws SQLException
    {
        String useDb="use SchoolDB";
        stmt.executeLargeUpdate ( useDb );
        String sql=" CREATE TABLE IF NOT EXISTS StudentScore (\n" +
                " id INT(11) NOT NULL AUTO_INCREMENT,\n" +
                " scoreDate DATE,\n" +
                " name VARCHAR(20),\n"+
                " number VARCHAR(20) not null,\n"+
                " chinese INT(11)  NULL,\n"+
                " math INT(11)  NULL,\n"+
                " english INT(11)  NULL,\n"+
                " physics INT(11)  NULL,\n"+
                " chemistry INT(11)  NULL,\n"+
                " biology INT(11)  NULL,\n"+
                " history INT(11)  NULL,\n"+
                " politics INT(11)  NULL,\n"+
                " geographic INT(11)  NULL,\n"+
                "  PRIMARY KEY (id)\n" +
                ") ENGINE=InnoDB";
        int m = (int) stmt.executeLargeUpdate ( sql );
        if (m == 0) {
            System.out.print ( " 创建数据库表（StudentScore）成功......" );
        } else {
            System.out.print ( " 创建数据库表（StudentScore）失败......" );
        }
    }

}
