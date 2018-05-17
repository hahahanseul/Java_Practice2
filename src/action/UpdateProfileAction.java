package action;

import data.ProfileData;
import utility.CommandRead;

public class UpdateProfileAction implements Action{
	@Override
	public void execute() {
		System.out.println("連絡先番号を入力してください");
		System.out.print("＞");
		int readNo = CommandRead.readNo();
		System.out.println("連絡先番号"+readNo+"を編集します");

		System.out.println("氏名を入力してください");
		System.out.print("＞");
		String readName = CommandRead.readString();

		System.out.println("かなを入力してください");
		System.out.print("＞");
		String readKana = CommandRead.readString();

		System.out.println("電話番号を入力してください");
		System.out.print("＞");
		String readTel = CommandRead.readString();

		ProfileData data = new ProfileData();
		data.updateProfile(readNo,readName,readKana,readTel);
		System.out.println("----------------------------------");
		System.out.println("連絡先番号"+readNo+"を編集しました");
		System.out.println("----------------------------------");
	}
}
