package TR;

public class CMonster {
	private CInfo m_tMonster; //선언만 해두고 new로 할당안했으니 사용할수 없음 
	public CMonster() {
		m_tMonster = new CInfo(); //함수가 생성되면서 할당을해준다.
	}
	
	public void SetDamage(int iAttack) {
		m_tMonster.iHp -= iAttack;
	}
	
	public void SetMonster(CInfo tMonster) {
//		Info타입으로 다 넘기겟다.
		m_tMonster = tMonster;		
	}
	
	public CInfo GetMonster() {
//		private인 CMonster 타입을 리턴해주기위한함수
		return m_tMonster;
	}
	
	public void Render() {
		System.out.println("=======================================");
		System.out.println("이름 : "+m_tMonster.strName);
		System.out.println("체력 : "+m_tMonster.iHp + "\t공격력 : "+m_tMonster.iAttack);		
	}
	
}
