package action;

import data.Profile;
import data.ProfileData;
import utility.CommandRead;

public class SearchProfileAction implements Action {

	@Override
	public void execute() {
		System.out.println("連絡先番号を入力してください");
		System.out.print("＞");
		int readNo = CommandRead.readNo();
		ProfileData data = new ProfileData();
		Profile profile = data.getProfileByNo(readNo);
		if (profile != null) {
			System.out.println("-------------------------");
			System.out.println("NO．　　　：" + profile.getNo());
			System.out.println("氏名　　　：" + profile.getName());
			System.out.println("かな　　　：" + profile.getKana());
			System.out.println("電話番号　：" + profile.getTel());
			System.out.println("-------------------------");

		} else {
			System.out.println("-------------------------");
			System.out.println("連絡先は見つかりませんでした");
			System.out.println("-------------------------");
		}
	}

}
