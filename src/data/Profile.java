package data;

public class Profile {

	private int no;
	private String name;
	private String kana;
	private String tel;

	public Profile(int no,String name,String kana, String tel) {
	this.no=no;
	this.name=name;
	this.kana=kana;
	this.tel=tel;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}