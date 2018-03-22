package TR;

import java.util.Scanner;

public class CPlayer {
	//이름 공격력 체력을 한데모아서 생성해주고 값을 받을것.	
	private CInfo m_tInfo = new CInfo();
	
	public CInfo GetInfo() { // m_tInfo의 값들을 돌려줄 함수
		return m_tInfo;
	}
	
	public void SetDamage(int iAttack) {
		m_tInfo.iHp -= iAttack;
	}
	
	public void SetHp(int iHp) {
		m_tInfo.iHp = iHp; //플레이어가 죽었을때 쓸 함수
	}
	
	public void SelectJob() { //직업선택함수
		System.out.print("직업을 선택하세요(1.기사 2.마법사 3.도둑) : ");
		int iInput = 0;
		Scanner sin = new Scanner(System.in);
		iInput = sin.nextInt();
		
		switch(iInput) {
		case 1 :
			m_tInfo.strName = "기사";
			m_tInfo.iAttack = 10;
			m_tInfo.iHp = 100;
			break;
		case 2 :
			m_tInfo.strName = "오크";
			m_tInfo.iAttack = 10;
			m_tInfo.iHp = 100;
			break;
		case 3 :
			m_tInfo.strName = "호빗";
			m_tInfo.iAttack = 10;
			m_tInfo.iHp = 100;
			break;
		}
			
			
		}
	public void Render() {
		System.out.println("=======================================");
		System.out.println("직업이름 : "+m_tInfo.strName);
		System.out.println("체력 : "+m_tInfo.iHp + "\t공격력 : "+m_tInfo.iAttack);		
	}
	
	public CPlayer() {}

}
