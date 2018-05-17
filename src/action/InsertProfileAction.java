package action;

import data.ProfileData;
import utility.CommandRead;

public class InsertProfileAction implements Action{
	@Override
	public void execute() {
		System.out.println("連絡先番号を入力してください");
		System.out.print("＞");
		int readNo = CommandRead.readNo();

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
		data.insertProfile(readNo,readName,readKana,readTel);

		System.out.println("-------------------------");
		System.out.println("連絡先を登録しました");
		System.out.println("-------------------------");
	}

}
