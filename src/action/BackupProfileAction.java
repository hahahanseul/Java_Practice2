package action;

import data.ProfileData;
import utility.CommandRead;

public class BackupProfileAction implements Action {
	@Override
	public void execute() {
		System.out.println("保存先のパスを入力してください");
		System.out.print("＞");
		String path = CommandRead.readString();
		ProfileData data = new ProfileData();
		data.backupProfileList(path);
		System.out.println("===============================");
		System.out.println("バッグアップファイルを" + path + "\\exam2に出力しました");
		System.out.println("===============================");
	}
}
