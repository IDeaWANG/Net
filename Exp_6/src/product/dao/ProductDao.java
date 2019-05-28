package product.dao;

import product.model.Product;
import product.util.DBUtil;

import java.sql.*;
import java.util.*;

public class ProductDao {
    private static List<Product> products = new ArrayList<Product>();

    public List<Product> findAll() {// 得到所有产品
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = null;
        sql = "select * from product";
        try {
            conn = DBUtil.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrices(rs.getFloat("price"));
                p.setDate(rs.getDate("date"));
                products.add(p);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return products;
        }
    }

    public List<Product> findByName(String name) { // 根据名称(支持模糊查找)查找产品
        List<Product> products = new ArrayList<Product>();

        Connection conn = null;
        PreparedStatement statement = null;
                ResultSet rs = null;
        String sql = null;
        sql = "select * from product where name like ?";
        try {
            conn = DBUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+name+"%");
            rs = statement.executeQuery();

            while (rs.next()) {
                Product product = new Product();
//                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrices(rs.getFloat("price"));
                product.setDate(rs.getDate("date"));
                products.add(product);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return products;
        }
    }


    public Product findById(int id) {// 根据id查找产品
        Product p = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = null;
        sql = "select * from product where id =? ";
        try {
            conn = DBUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            while (rs.next()) {
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrices(rs.getFloat("price"));
                p.setDate(rs.getDate("date"));
//                    products.add(product);
                break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return p;
        }
    }


    public boolean insert(String name, String price, String date) {// 插入产品
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = null;
        sql = "insert into product(name,price,date) values(?,?,?)";
        try {
            conn = DBUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setFloat(2, Float.parseFloat(price));
            statement.setDate(3, java.sql.Date.valueOf(date));
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    public boolean update(int id, String name, String price, String date) {// 修改产品
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "update product set name = ?,price =?,date = ? where id = ?";
        try {
            conn = DBUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setFloat(2, Float.parseFloat(price));
            statement.setDate(3, java.sql.Date.valueOf(date));
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return true;
    }


    public boolean delete(int id) {//删除产品
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "delete  from product where id = ? ";

        try {
            conn = DBUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
