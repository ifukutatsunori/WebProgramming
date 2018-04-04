package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	public User findByLoginInfo(String loginId, String password) {
		//入力されたログインIDとパスワードをテーブル内から検索して正/否を判断するメソット//
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}
			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public List<User> findAll() {
		//テーブル内に数値又は文字列を格納しているメソット//
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user where login_id not in ('admin')";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
				user.setBirthDateFmt(birthDate);
				user.setCreateDateFmt(createDate);
				user.setUpdateDateFmt(updateDate);

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public List<User> findSearch(String loginId1, String name1, String birthDate1, String birthDate2) {
		//入力された数値又は文字列からテーブル内を検索するメソット//
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user where login_id not in ('admin')";

			if (!loginId1.equals("")) {
				sql += " and login_id = '" + loginId1 + "'";
			} else if (!name1.equals("")) {
				sql += " and name like '%" + name1 + "%'";
			} else if (!birthDate1.equals("")) {
				sql += " and  birth_date >= '" + birthDate1 + "'";
			} else if (!birthDate2.equals("")) {
				sql += " and  birth_date =< '" + birthDate2 + "'";
			}

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

				userList.add(user);
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	//↓↓既存のテーブルに入力された値をセットする処理↓↓

	public void signUp(String loginId, String password, String name, String birthDate) {
		//テーブルに入力された数値又は文字列を格納するメソット//
		Connection conn = null;

		try {

			conn = DBManager.getConnection();

			String sql = "INSERT INTO user (login_id,password,name,birth_date,create_date,update_date) VALUES(?,MD5(?),?,?,now(),now())";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			pStmt.setString(3, name);
			pStmt.setString(4, birthDate);
			pStmt.executeUpdate();

			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<User> findByUserInfo(String selectId) {
		//指定したIDのテーブルデータを参照するメソット//
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, selectId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
				user.setBirthDateFmt(birthDate);
				user.setCreateDateFmt(createDate);
				user.setUpdateDateFmt(updateDate);

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}

			}
		}
		return userList;
	}

	public void upDate(String password, String name, String birthDate, String id) {
		//テーブル内に格納されているデータを更新上書きするメソット//
		Connection conn = null;

		try {

			conn = DBManager.getConnection();

			String sql = "UPDATE user SET password = ?, name = ?,birth_date = ?, update_date = now() WHERE id= ? ";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, password);
			pStmt.setString(2, name);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, id);
			pStmt.executeUpdate();

			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void delete(String deleteId) {
		//テーブル内の指定したIDのテーブルデータを削除するメソット//
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "DELETE FROM user WHERE id= ? ";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, deleteId);
			pStmt.executeUpdate();
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String findByLoginIdCheck(String loginId) {
		//テーブル内に入力されたログインIDが既に存在しているか検索するメソット//
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				return null;
			} else {
				return loginId;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}
}