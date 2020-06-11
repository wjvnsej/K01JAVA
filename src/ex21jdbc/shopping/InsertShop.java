package ex21jdbc.shopping;

import ex21jdbc.connect.IConnectImpl;

public class InsertShop extends IConnectImpl{
	
	public InsertShop() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		
		try {
			
			String sql = "INSERT INTO sh_goods (g_idx, goods_name, goods_price, p_code)"
					+ "	VALUES (goods_seq.nextval, ?, ?, ?) ";
			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, scanValue("상품명"));
			psmt.setInt(2, Integer.parseInt(scanValue("상품가격")));
			psmt.setString(3, scanValue("상품코드"));
			
			int affected = psmt.executeUpdate();
			if(affected == 0) {
				System.out.println("오류발생 : 입력실패");
			}
			else {
				System.out.println(affected + "행 입력 성공");
			}
			
		} 
		catch (Exception e) {
			System.out.println("InsertShop중 예외발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {
		
		new InsertShop().execute();

	}

}
