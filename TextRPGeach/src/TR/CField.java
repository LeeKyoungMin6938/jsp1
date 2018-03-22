package TR;

import java.util.Scanner;

public class CField {
	private CPlayer m_pPlayer;
	private CMonster m_pMonster;

	Scanner sin = new Scanner(System.in);

	// 생성된 플레이어정보를 받아주는 함수
	public void SetPlayer(CPlayer pPlayer) {
		m_pPlayer = pPlayer;
	}

	// 몬스터 이름, 체력, 공격력을 받고 생성하는 함수
	CMonster Create(String _strName, int _iHp, int _iAttack) {
		// 몬스터 생성을 전담하는 함수
		CMonster pMonster = new CMonster();
		CInfo tMonster = new CInfo();
		tMonster.strName = _strName;
		tMonster.iHp = _iHp;
		tMonster.iAttack = _iAttack;

		pMonster.SetMonster(tMonster);

		return pMonster;
	}

	public void CreateMonster(int iInput) {
		switch (iInput) {
		case 1:
			m_pMonster = Create("초보몹", 30, 3);
			break;
		case 2:
			m_pMonster = Create("중수몹", 60, 6);
			break;
		case 3:
			m_pMonster = Create("고수몹", 90, 9);
			break;
		}
	}

	public void DrawMap() {
		System.out.println("1.초보맵 2.중수맵 3.고수맵 4.전단계 : ");
		System.out.println("================================");
		System.out.println("맵을 선택하세요");
	}

	public void progress() {
		int iInput = 0;

		while (true) {
			m_pPlayer.Render();
			// 사냥터 맵
			DrawMap();
			iInput = sin.nextInt();
			if (iInput == 4)
				break;
			if (iInput <= 3) {
				// 몬스터생성 , 싸움
				CreateMonster(iInput);
				Fight();
			}

		}
	}

	public void Fight() {
		int iInput = 0;

		while (true) {
			m_pPlayer.Render();
			m_pMonster.Render();

			System.out.print("1.공격 2.도망");
			iInput = sin.nextInt();
			if (iInput == 1) {
				m_pPlayer.SetDamage(m_pMonster.GetMonster().iAttack);
				m_pMonster.SetDamage(m_pPlayer.GetInfo().iAttack);

				if (m_pPlayer.GetInfo().iHp <= 0) {
					m_pPlayer.SetHp(100);
					break;
				}
			}

			if (iInput == 2 || m_pMonster.GetMonster().iHp <= 0) {
				m_pMonster = null;
				break;
			}
		}
	}
}
