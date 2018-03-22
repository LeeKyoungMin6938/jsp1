package TR;

import java.util.Scanner;

public class CMainGame {
	// 클래스들을 관리하는 역할 (직업선택하고, 사냥터로갈지 종료할지 결정하고 , ... 루프가 도는 공간
	private CPlayer m_pPlayer = null;
	private CField m_pField = null;
	Scanner sin = new Scanner(System.in);

	public void Initialize() {
		if (m_pPlayer == null) { // null일때만 생성하게끔. 있을때 또생성하면 덮어씌워지니까. 메인함수를 실행할때마다 항상 캐릭터가 레벨1부터 시작되는걸 방지.
			m_pPlayer = new CPlayer();
			m_pPlayer.SelectJob();
		}
	}

	public void Progress() {
		int iInput = 0;

		while (true) {
			m_pPlayer.Render();
			System.out.println("1.사냥터 2.종료 : ");

			iInput = sin.nextInt();

			if (iInput == 2) {
				break;
			}
			if (iInput == 1) {
				if (m_pField == null) {
					// 사냥터생성
					m_pField = new CField();
					// 사냥터엔 몬스터, 플레이어가 필요
					m_pField.SetPlayer(m_pPlayer);
				}
				// 사냥터의 프로그레스 함수를 만들어서 사냥터가 잘 돌아가게끔 
				m_pField.progress();
			}
		}
	}
	
	public CMainGame() {
		
	}

}
