package ex13interface;

/*
추상클래스를 interface로 변경하기
	abstract class => interface
	
	메소드의 경우 public abstract를 제거
	
	멤버상수인 경우 public static final을 제거
 */

//프로젝트 전체에서 기준이 될 수 있는 추상클래스 정의
interface PersonalNumberStorageInter {
	void addPersnalInfo(String juminNum, String name);
	String searchPersnalInfo(String juminNum);
}

/*
사람의 정보를 저장 할 용도의 DTO클래스. 혹은 VO클래스 라고도 한다.
 */
class PersonalInfoVO {
	
	//멤버변수
	private String name;
	private String juminNum;
	
	//생성자
	public PersonalInfoVO(String name, String juminNum) {
		this.name = name;
		this.juminNum = juminNum;
	}
	
	//getter메소드
	String getName() { return name; }
	String getJuminNum() { return juminNum; }
}

/*
클래스가 클래스를 상속받을 때  => extends 사용
클래스가 인터페이스를 상속받을 때 => implements 사용
인터페이스가 인터페이스를 상속받을 때 => extends 사용

extends는 '상속'이라 표현하고, implements는 '구현'이라 표현한다.
 */
class PersonalNumberStorageImpl implements 
					PersonalNumberStorageInter {
	
	//멤버변수
	PersonalInfoVO[] personalArr;//정보저장용 객체배열
	int numOfPerInfo;//입력정보 카운트용 변수
	
	//생성자
	public PersonalNumberStorageImpl(int arrSize) {
		personalArr = new PersonalInfoVO[arrSize];
		numOfPerInfo = 0;
	}
	
	/*
	전달받은 인자를 통해 PersonalInfoVO 객체를 생성 후 객체배열에 저장한다.
	 */
	@Override
	public void addPersnalInfo(String juminNum, String name) {
		personalArr[numOfPerInfo] = 
				new PersonalInfoVO(name, juminNum);
		numOfPerInfo ++;
	}
	
	/*
	주민번호를 인자로 전달받아 객체배열에 저장된 정보를 검색한 후
	일치하는 경우에만 이름을 반환한다.
	 */
	@Override
	public String searchPersnalInfo(String juminNum) {
		for (int i = 0; i < numOfPerInfo; i++) {
			if(juminNum.compareTo
					(personalArr[i].getJuminNum()) == 0) {
				
				//getter를 통홰 이름을 반환한다.
				return personalArr[i].getName();
			}
		}
		return null; //검색결과가 없는경우 null반환
	}
}

public class E02AbstractToInterface2 {

	public static void main(String[] args) {
		
		PersonalNumberStorageInter storage = 
				new PersonalNumberStorageImpl(10);
		
		//정보저장
		storage.addPersnalInfo("901234-2222222", "김태희");
		storage.addPersnalInfo("901234-1111111", "정지훈");
		
		//검색
		System.out.println
			(storage.searchPersnalInfo("901234-2222222"));
		System.out.println
			(storage.searchPersnalInfo("901234-1111111"));
		System.out.println
			(storage.searchPersnalInfo("001024-1090333"));		
	}
}