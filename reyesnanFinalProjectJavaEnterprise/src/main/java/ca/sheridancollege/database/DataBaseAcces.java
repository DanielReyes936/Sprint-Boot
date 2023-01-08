package ca.sheridancollege.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Cart;
import ca.sheridancollege.beans.Product;
import ca.sheridancollege.beans.User;

@Repository
public class DataBaseAcces {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public User findUserAccount(String userName) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM sec_user where userName=:userName";
		parameters.addValue("userName", userName);
		ArrayList<User> users = (ArrayList<User>)jdbc.query(query, parameters,
				new BeanPropertyRowMapper<User>(User.class));
		if (users.size()>0)
			return users.get(0);
		else
			return null;
	}
	public List<String> getRolesById(long userId) {
		ArrayList<String> roles = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "select user_role.userId, sec_role.roleName "
				+ "FROM user_role, sec_role "
				+ "WHERE user_role.roleId=sec_role.roleId "
				+ "and userId=:userId";
		parameters.addValue("userId", userId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row : rows) {
			roles.add((String)row.get("roleName"));
		}
		return roles;
	}

	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;

	 public void addUser(String userName, String password) {
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
		 String query = "insert into SEC_User "
		 + "(userName, encryptedPassword, ENABLED)"
		 + " values (:userName, :encryptedPassword, 1)";
		 parameters.addValue("userName", userName);
		 parameters.addValue("encryptedPassword",
		 passwordEncoder.encode(password));
		 jdbc.update(query, parameters);

	 }
	 
	 public void addRole(long userId, long roleId) {
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
		 String query = "insert into user_role (userId, roleId)"
		 + "values (:userId, :roleId);";
		 parameters.addValue("userId", userId);
		 parameters.addValue("roleId", roleId);
		 jdbc.update(query, parameters);
		 
	 }
	 
	 	 
	 public  List<Product> getProductsList(){
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
		 String query = "SELECT * FROM product";
		 return jdbc.query(query, parameters,new BeanPropertyRowMapper<Product>(Product.class));
		 
	 }
	 
	 public  List<Cart> getCartList(){
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
		 String query = "SELECT * FROM cart";
		 return jdbc.query(query, parameters,new BeanPropertyRowMapper<Cart>(Cart.class));
		 
	 }
	public void insertProduct(Product product) {
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
		 String query = "INSERT INTO product(nameProduct,description,price)"+ " VALUES (:nameProduct,:description,:price)";
		 parameters.addValue("nameProduct", product.getNameProduct());
		 parameters.addValue("description", product.getDescription());
		 parameters.addValue("price", product.getPrice());
		 jdbc.update(query, parameters);
	}
	public void deleteProductById(Long productId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		 String query = "DELETE FROM product WHERE productId = :productId";
		 parameters.addValue("productId", productId);
		 jdbc.update(query, parameters);
	}
			
	public void insertCart(String name,String description,int price) {
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
		 String query = "INSERT INTO cart(nameProduct,description,price)"+ " VALUES (:nameProduct,:description,:price)";
		 				 			 	
		 parameters.addValue("nameProduct", name );
		 parameters.addValue("description",description );
		 parameters.addValue("price", price);
		 jdbc.update(query, parameters);
	}
	public void removeProductById(Long productId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		 String query = "DELETE FROM cart WHERE productId = :productId";
		 parameters.addValue("productId", productId);
		 jdbc.update(query, parameters);
	}
	
	
	
}
	
