package com.zrdh;

import com.zrdh.utils.JDBCUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/30 17:12
 *  poi导入数据库脚本
 */
public class JDBCTest {


    public void insert(List<Map<String,String>> paramList) {
        if(paramList == null){
            return;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        for (Map<String, String> paramMap : paramList) {
            try {
                String name = paramMap.get("name");
                Integer id = null;
                try {
                     id = Integer.parseInt(paramMap.get("id"));
                } catch (Exception e) {

                }
                conn = JDBCUtil.getConnection();
                String sql = "INSERT INTO table_name (列1, 列2,...) VALUES (?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,name);
                ps.setInt(2,id);
                int i = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.close(rs, stmt, conn);
            }
        }
    }


    public void readPOI() throws Exception{
        // 判断文件是否存在
        File file = new File("C:\\Users\\17645\\Desktop\\guanxi\\小区ID对照表.xlsx");
        if (!file.exists()) {
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在！");
        }
        HSSFWorkbook wb = null;
        FileInputStream fis=null;
        List<Map<String,String>> paramList = new ArrayList<>();
        try {
            fis = new FileInputStream(file);
            // 去读Excel
            wb = new HSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            // 获取最后行号
            int lastRowNum = sheet.getLastRowNum();
            if (lastRowNum > 0) { // 如果>0，表示有数据
//                out("\n开始读取名为【" + sheet.getSheetName() + "】的内容：",showInfo);
                System.out.println("总行数:"+lastRowNum);
            }
            Row row = null;
            // 循环读取
            for (int i = 1; i <= lastRowNum ; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    System.out.println("第" + (i + 1) + "行："+row.toString());
                    // 获取每一单元格的值
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        String name = row.getCell(0).getStringCellValue();
                        String id = row.getCell(1).getStringCellValue();
                        hashMap.put("name",name);
                        hashMap.put("id",id);
                        paramList.add(hashMap);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            wb.close();
        }
        insert(paramList);
    }

    public void readPOI2() throws Exception{
        // 判断文件是否存在
        File file = new File("C:\\Users\\17645\\Desktop\\guanxi\\房卡号地址信息.xlsx");
        if (!file.exists()) {
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在！");
        }
        HSSFWorkbook wb = null;
        FileInputStream fis=null;
        List<Map<String,String>> paramList = new ArrayList<>();
        try {
            fis = new FileInputStream(file);
            // 去读Excel
            wb = new HSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            // 获取最后行号
            int lastRowNum = sheet.getLastRowNum();
            if (lastRowNum > 0) { // 如果>0，表示有数据
//                out("\n开始读取名为【" + sheet.getSheetName() + "】的内容：",showInfo);
                System.out.println("总行数:"+lastRowNum);
            }
            Row row = null;
            // 循环读取
            for (int i = 1; i <= lastRowNum ; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    System.out.println("第" + (i + 1) + "行："+row.toString());
                    // 获取每一单元格的值
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        String C_BoroughName = row.getCell(0).getStringCellValue();
                        String C_BuildingName = row.getCell(1).getStringCellValue();
                        String C_CardNum = row.getCell(2).getStringCellValue();
                        String C_EnrolAddress = row.getCell(3).getStringCellValue();
                        String C_RoomNum = row.getCell(4).getStringCellValue();
                        String I_Cell = row.getCell(5).getStringCellValue();
                        String I_BoroughID = row.getCell(6).getStringCellValue();
                        String I_BuildingID = row.getCell(7).getStringCellValue();
                        String I_RoomID = row.getCell(8).getStringCellValue();
                        hashMap.put("C_BoroughName",C_BoroughName);
                        hashMap.put("C_BuildingName",C_BuildingName);
                        hashMap.put("C_CardNum",C_CardNum);
                        hashMap.put("C_EnrolAddress",C_EnrolAddress);
                        hashMap.put("C_RoomNum",C_RoomNum);
                        hashMap.put("I_Cell",I_Cell);
                        hashMap.put("I_BoroughID",I_BoroughID);
                        hashMap.put("I_BuildingID",I_BuildingID);
                        hashMap.put("I_RoomID",I_RoomID);
                        paramList.add(hashMap);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            wb.close();
        }
        insert2(paramList);
    }

    public void insert2(List<Map<String,String>> paramList) {
        if(paramList == null){
            return;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        for (Map<String, String> paramMap : paramList) {
            try {
                String C_BoroughName = paramMap.get("C_BoroughName");
                String C_BuildingName = paramMap.get("C_BuildingName");
                String C_CardNum_s = paramMap.get("C_CardNum");
                String C_EnrolAddress = paramMap.get("C_EnrolAddress");
                String C_RoomNum = paramMap.get("C_RoomNum");
                String I_Cell = paramMap.get("I_Cell");
                String I_BoroughID_s = paramMap.get("I_BoroughID");
                String I_BuildingID_s = paramMap.get("I_BuildingID");
                String I_RoomID_s = paramMap.get("I_RoomID");
                Integer I_BoroughID = null;
                try {
                    I_BoroughID = Integer.parseInt(paramMap.get("I_BoroughID_s"));
                } catch (Exception e) {

                }
                Integer I_RoomID = null;
                try {
                    I_RoomID = Integer.parseInt(paramMap.get("I_RoomID_s"));
                } catch (Exception e) {

                }
                Integer C_CardNum = null;
                try {
                    C_CardNum = Integer.parseInt(paramMap.get("C_CardNum_s"));
                } catch (Exception e) {

                }
                Integer I_BuildingID = null;
                try {
                    I_BuildingID = Integer.parseInt(paramMap.get("I_BuildingID_s"));
                } catch (Exception e) {

                }
                conn = JDBCUtil.getConnection();
                String sql = "INSERT INTO table_name (列1, 列2,...) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,C_BoroughName);
                ps.setString(2,C_BuildingName);
                ps.setInt(3,C_CardNum);
                ps.setString(4,C_EnrolAddress);
                ps.setString(5,C_RoomNum);
                ps.setString(6,I_Cell);
                ps.setInt(7,I_BoroughID);
                ps.setInt(8,I_BuildingID);
                ps.setInt(9,I_RoomID);
                int i = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.close(rs, stmt, conn);
            }
        }
    }
}
