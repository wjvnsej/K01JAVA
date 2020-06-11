package ex21jdbc.shopping;

import java.text.NumberFormat;

import ex21jdbc.connect.IConnectImpl;

public class SelectShop extends IConnectImpl {

	public SelectShop() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		
		try {
			String g_idx = null;
			String goods_name = null;
			String goods_price = null;
			String regidate = null;
			String p_code = null;
			String search_name = scanValue("검색할 상품명");
			NumberFormat nf = NumberFormat.getNumberInstance();
			
			stmt = con.createStatement();
			String query = "SELECT g_idx, goods_name, goods_price, "
					+ " to_char(regidate, 'yyyy-mm-dd hh24:mi') regidate,"
					+ "	p_code "
					+ "	FROM sh_goods"
					+ " WHERE goods_name LIKE '%" + search_name + "%'";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				g_idx = rs.getString("g_idx");
				goods_name = rs.getString("goods_name");
				goods_price = nf.format(rs.getInt("goods_price"));
				regidate = rs.getString("regidate");
				p_code = rs.getString("p_code");
			
				System.out.printf("일련번호 : %s / 상품명 : %s / 상품가격 : %s / 등록일 : %s / 상품코드 : %s\n"
								, g_idx, goods_name, goods_price, regidate, p_code);
			}
			
		}
		catch (Exception e) {
			System.out.println("SelectShop 중 예외발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {
		new SelectShop().execute();
	}

}
