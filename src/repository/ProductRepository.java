package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;
import model.Product;

public class ProductRepository {
	private static final String TAG = "productRepository";
	private static ProductRepository instance = new ProductRepository();
	private ProductRepository() {}
	public static ProductRepository getInstance() {
		return instance;
	}
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Product> findAll() {
		final String SQL = "SELECT id, name, type, price, count FROM product ORDER BY id ASC";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			List<Product> products = new ArrayList<>();
			
			while(rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(rs.getString(3))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}		
	
	public List<Product> findAll가격순() {
		final String SQL = "SELECT id, name, type, price, count FROM product ORDER BY price DESC";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			List<Product> products = new ArrayList<>();
			
			while(rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(rs.getString(3))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll가격순 : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}		
	
	
	
	public List<Product> findAll판매순() {
		final String SQL = "SELECT id, name, type, price, count FROM product ORDER BY count DESC";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			List<Product> products = new ArrayList<>();
			
			while(rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(rs.getString(3))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll판매순 : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}		
	
	public int deleteById(int id) {
		final String SQL = "DELETE FROM product WHERE id =?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"deleteById : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}

		return -1;
	}
	
	

}
