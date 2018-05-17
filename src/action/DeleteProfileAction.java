package action;

import data.ProfileData;
import utility.CommandRead;

public class DeleteProfileAction implements Action{

	@Override
	public void execute() {
		System.out.println("連絡先番号を入力してください");
		System.out.print("＞");
		int readNo = CommandRead.readNo();

		ProfileData data = new ProfileData();
		data.deleteProfile(readNo);
		System.out.println("-------------------------");
		System.out.println("連絡先を削除しました");
		System.out.println("-------------------------");

	}

}
