package com.alison.winter.scray;

import com.alison.winter.scray.domain.po.App;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Date;

/**
 * @author huangyong
 * @version: 0.1
 **/
public class scrayIconForInternet {
    @Test
    public void saveIcon() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String URL = "jdbc:mysql://192.168.3.104:3306/jaqen?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String passwd = "winteriscoming";
        Connection conn = DriverManager.getConnection(URL, username, passwd);
        conn.setAutoCommit(false);
        String querySql = "select * from app where name = ?";
        String saveSql = "insert into app(icon, name, create_time, update_time)  values(?,?,?,?)";

        File[] files = new File("D:\\icon1").listFiles((dir, name) -> name.substring(name.lastIndexOf(".")).equals(".png"));
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
            PreparedStatement psmt = conn.prepareStatement(querySql);
            psmt.setString(1, fileName);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                psmt.close();
                continue;
            }
            PreparedStatement save_psmt = conn.prepareStatement(saveSql);

            byte[] icon = null;
            try {
                FileInputStream input = new FileInputStream(file);
                icon = IOUtils.toByteArray(input);
                App app = new App();
                app.setName(fileName);
                app.setIcon(icon);
                app.setCreateTime(new Date());
                app.setUpdateTime(new Date());
                Blob iconBlob = new SerialBlob(app.getIcon());
                save_psmt.setBlob(1, iconBlob);
                save_psmt.setString(2, app.getName());
                save_psmt.setTimestamp(3, new Timestamp(app.getCreateTime().getTime()));
                save_psmt.setTimestamp(4, new Timestamp(app.getUpdateTime().getTime()));
                Boolean bool = save_psmt.execute();
                System.out.println(bool);
                input.close();
                psmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        conn.commit();
    }
}
