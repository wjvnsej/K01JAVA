package ex21jdbc.shopping;

import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class UpdateShop extends IConnectImpl {

	public UpdateShop() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		
		try {
			csmt = con.prepareCall("{call ShopUpdateGoods(?,?,?,?,?)}");
			csmt.setString(1, scanValue("수정할 상품명"));
			csmt.setString(2, scanValue("수정할 가격"));
			csmt.setString(3, scanValue("수정할 제품코드"));
			csmt.setString(4, scanValue("수정할 일련번호"));
			csmt.registerOutParameter(5, Types.VARCHAR);
			csmt.execute();
			
			System.out.println("수정프로시저 실행결과 : " + csmt.getString(5));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {
		new UpdateShop().execute();
	}

}
