package test;
import java.util.ArrayList;

import data.Profile;
import data.ProfileData;
class TestProfileData {
	public static void main(String[] args) {
		// ProfileData型の変数dataを宣言して、ProfileDataクラスの
		// インスタンスを生成して代入する
		ProfileData data = new ProfileData();
		// 変数dataの参照するインスタンスのgetProfileListメソッドを呼び出し
		// 戻り値を変数profileListに代入する
		ArrayList<Profile> profileList = data.getProfileList();
		// 変数profileListが参照するインスタンスの値を表示する
		System.out.println("[連絡先一覧]");
		System.out.println("===================================");
		for (Profile profile : profileList) {
			int no = profile.getNo();
			String name = profile.getName();
			String kana = profile.getKana();
			System.out.println(no + "：" + name + "：" + kana);
		}
		System.out.println("===================================");
	}
}
