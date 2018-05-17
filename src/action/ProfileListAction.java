package action;

import java.util.ArrayList;

import data.Profile;
import data.ProfileData;

public class ProfileListAction implements Action {

	@Override
	public void execute() {
		ProfileData data = new ProfileData();
		ArrayList<Profile> profileList = data.getProfileList();
		System.out.println("[連絡先一覧]");
		System.out.println("===============================");
		for (Profile profile : profileList) {
			int no = profile.getNo();
			String name = profile.getName();
			String kana = profile.getKana();
			System.out.println(no + "：" + name + "：" + kana);
		}

		System.out.println("===============================");
	}

}
