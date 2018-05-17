package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfileData {
	public ArrayList<Profile> getProfileList() {
		ArrayList<Profile> profileList = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:65534/phone_book?useSSL=false", "jdbc", "jdbc");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select no, name, kana, tel from profile");
			while (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String kana = rs.getString("KANA");
				String tel = rs.getString("TEL");
				Profile profile = new Profile(no, name, kana, tel);
				profileList.add(profile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {

			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

			}
		}

		return profileList;
	}
	public Profile getProfileByNo(int readNo) {
		Profile profile = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:65534/phone_book?useSSL=false", "jdbc", "jdbc");
			pst = con.prepareStatement("select no, name, kana, tel from profile where no = ?");
			pst.setInt(1, readNo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String kana = rs.getString("KANA");
				String tel = rs.getString("TEL");
				profile = new Profile(no, name, kana, tel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {

			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

			}
		}
		return profile;
	}
	public void insertProfile(int readNo, String readName, String readKana, String readTel) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:65534/phone_book?useSSL=false", "jdbc", "jdbc");
			pst = con.prepareStatement("insert into profile values(?,?,?,?)");
			pst.setInt(1, readNo);
			pst.setString(2, readName);
			pst.setString(3, readKana);
			pst.setString(4, readTel);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}finally {
			try {
				if(pst != null) {pst.close();}
				if(con != null) {con.close();}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	public void deleteProfile(int readNo) {
	Connection con = null;
	PreparedStatement pst = null;
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:65534/phone_book?useSSL=false", "jdbc", "jdbc");
		pst = con.prepareStatement("delete from profile where no = ?");
		pst.setInt(1,readNo);
		pst.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(pst != null) {
				pst.close();
			}
		}catch(SQLException e) {

		}try {
			if(con != null) {
				con.close();
			}}catch(SQLException e) {

			}
		}
	}
	public void updateProfile(int readNo, String readName, String readKana, String readTel)  {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:65534/phone_book?useSSL=false", "jdbc", "jdbc");
			pst = con.prepareStatement("update profile set name = ?, kana = ?, tel = ? where no = ?");
			pst.setString(1, readName);
			pst.setString(2, readKana);
			pst.setString(3, readTel);
			pst.setInt(4, readNo);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}finally {
			try {
				if(pst != null) {pst.close();}
				if(con != null) {con.close();}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	public void backupProfileList(String path) {
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(path+"\\profileList.csv");
			bw = new BufferedWriter(fw);
			ArrayList<Profile> profileList = this.getProfileList();
			bw.write("no, name, kana, tel");
			bw.newLine();
			for (Profile profile : profileList) {
				int no =profile.getNo();
				String name = profile.getName();
				String kana = profile.getKana();
				String tel = profile.getTel();
				bw.write(no+ "," + name + "," + kana+ "," + tel);
				bw.newLine();
				bw.flush();
			}
			bw.close();
			fw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

