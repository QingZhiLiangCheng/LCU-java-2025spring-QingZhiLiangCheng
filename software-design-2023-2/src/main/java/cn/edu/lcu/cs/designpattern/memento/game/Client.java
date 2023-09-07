package cn.edu.lcu.cs.designpattern.memento.game;

public class Client {

	public static void main(String[] args) {
		//创建游戏角色
		GameRole gameRole = new GameRole();
		gameRole.setVitality(100);
		gameRole.setDefence(100);
		
		System.out.println("和boss大战前的状态");
		gameRole.display();
		
		//把当前状态保存caretaker
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(gameRole.createMemento());
		
		System.out.println("和boss大战~~~");
		gameRole.setDefence(30);
		gameRole.setVitality(30);
		
		gameRole.display();
		
		System.out.println("大战后，使用备忘录对象恢复到站前");
		
		gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
		System.out.println("恢复后的状态");
		gameRole.display();
	}

}
