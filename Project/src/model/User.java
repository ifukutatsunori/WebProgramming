package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

	private int id;
	private String loginId;
	private String name;
	private Date birthDate;
	private String birthDateFmt;
	private String password;
	private String createDate;
	private String createDateFmt;
	private String updateDate;
	private String updateDateFmt;

	public User(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}

	public User(String loginId) {
		this.loginId = loginId;
	}

	public User(int id, String loginId, String name, Date birthDate, String password, String createDate,
			String updateDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getBirthDateFmt() {
		return birthDateFmt;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getCreateDateFmt() {
		return createDateFmt;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public String getUpdateDateFmt() {
		return updateDateFmt;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public void setBirthDateFmt(Date birthDate) {
		// userListからbirthDateを取得してString型に変換するメソット//
		DateFormat df1 = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		String sDate = df1.format(birthDate);
		this.birthDateFmt = sDate;
	}

	public void setCreateDateFmt(String createDate) {
		// userListからcreateDateを取得してDate型に変換するメソット//
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dDate = null;
		try {
			dDate = df2.parse(createDate);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		DateFormat df1 = new SimpleDateFormat("yyyy'年'MM'月'dd'日'HH:mm:ss");
		String sDate = df1.format(dDate);
		this.createDateFmt = sDate;
	}

	public void setUpdateDateFmt(String updateDate) {
		// userListからupdateDateを取得してDate型に変換するメソット//
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dDate = null;
		try {
			dDate = df.parse(updateDate);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		DateFormat df1 = new SimpleDateFormat("yyyy'年'MM'月'dd'日'HH:mm:ss");
		String sDate = df1.format(dDate);
		this.updateDateFmt = sDate;
	}
}
