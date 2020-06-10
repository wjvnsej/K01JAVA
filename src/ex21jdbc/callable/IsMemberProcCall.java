package ex21jdbc.callable;

import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class IsMemberProcCall extends IConnectImpl {

	public IsMemberProcCall() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		
		try {
			csmt = con.prepareCall("{call KosmoMemberAuth(?, ?, ?)}");
			
			csmt.setString(1, scanValue("회원 아이디"));
			csmt.setString(2, scanValue("회원 패스워드"));
			csmt.registerOutParameter(3, Types.NUMERIC);
			csmt.execute();
			
			int outParamResult = csmt.getInt(3);
			switch (outParamResult) {
			case 0:
				System.out.println("회원님 아이디가 없습니다. 회원가입하세요.");
				break;
			case 1:
				System.out.println("패스워드가 일치하지 않습니다. 비번찾기 하세요.");
				break;
			case 2:
				System.out.println("회원님 환영합니다.");
				break;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {
		
		new IsMemberProcCall().execute();
		
	}

}
