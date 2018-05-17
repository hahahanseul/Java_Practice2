package control;

import action.Action;
import action.BackupProfileAction;
import action.DeleteProfileAction;
import action.InsertProfileAction;
import action.ProfileListAction;
import action.SearchProfileAction;
import action.UpdateProfileAction;
import utility.CommandRead;
public class ControlProfile {

	public static void main(String[] args) {
		System.out.println("[メニュー]　全件検索：0、ナンバー検索：1、登録：2、削除：3、編集：4、バッグアップ：5");
		System.out.println(">");
		int command = CommandRead.readNo();
		Action action = null;
		if (command == 0) {
			action = new ProfileListAction();
		} else if (command == 1) {
			action = new SearchProfileAction();
		} else if (command == 2) {
			action = new InsertProfileAction();
		} else if (command == 3) {
			action = new DeleteProfileAction();
		} else if (command == 4) {
			action = new UpdateProfileAction();
		} else if (command == 5) {
			action = new BackupProfileAction();
		}
		action.execute();
	}
}