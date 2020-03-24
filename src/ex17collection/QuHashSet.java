package ex17collection;
/*
 컬렉션 set에 저장된 객체를 이름으로 검색하자. 해당 정보가 있으면 해당 어벤져스의 정보를 
 출력하고 없으면 "해당 영웅은 없어요ㅜㅜ" 라는 메시지 출력해야 한다.
 검색 부분은 Iterator를 통해 구현하도록 한다.
set계열의 컬렉션은 기본적으로 중복저장을 허용하지 않는다. 
그러나 아래와 같이 새롭게 정의한 클래스에 대해서는 equals(), hashCode() 
메소드를 적절히 오버라이딩 처리해야 중복을 제거할 수 있다. 
메소드 오버라이딩을 통해 hero4 는 입력되지 않도록 Avengers 클래스를 업데이트 하시오.
 */

import java.util.*;


class Avengers {
   String name;
   String heroName;
   String weapon;

   public Avengers(String name, String heroName, String weapon) {
      super();
      this.name = name;
      this.heroName = heroName;
      this.weapon = weapon;
   }

   @Override
   public int hashCode() {
      //객체가 가진 고유한값(참조값)을 int형으로 반환하는 메소드
      int hc1 = name.hashCode();
      int hc2 = heroName.hashCode();
      int hc3 = weapon.hashCode();
      System.out.println(hc1+" "+hc2+" "+hc3);
      int result = hc1+hc2+hc3;
      return result;
   }
   @Override
   public String toString() {
      return "Avengers [본명=" + name + ", 닉네임=" + heroName + ", "
            + "능력=" + weapon +"]";
   }

   @Override
   public boolean equals(Object obj) {
      //형변환
      Avengers avengers =(Avengers)obj;
      if(avengers.name.equals(this.name)&&
            avengers.heroName.equals(this.heroName)) {
         return true;
      }else {
         return false;
      }
   }

   
}

public class QuHashSet {

   public static void main(String[] args) {

      HashSet<Avengers> set = new HashSet<Avengers>();

      Avengers hero1 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
      Avengers hero2 = new Avengers("스티브로져스", "캡틴아메리카", "비브라늄 방패");
      Avengers hero3 = new Avengers("브루스배너", "헐크", "강한피부&점프");
      Avengers hero4 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
      
      set.add(hero1);
      set.add(hero2);
      set.add(hero3);
      set.add(hero4);       

      System.out.println("[최초 전체 정보출력]");
      for(Avengers av : set)
      {
         System.out.println(av.toString());         
      }
      
      //이름으로 검색
      Scanner sc = new Scanner(System.in);
      System.out.print("검색할 이름:");
      String searchName = sc.nextLine();
      
      boolean searchFlag = false;//검색결과 유무 확인
      
      Iterator<Avengers> itr = set.iterator();
      while(itr.hasNext()) {
         Avengers avengers = itr.next();
         if(searchName.equals(avengers.name)) {
            //검색렬과가 있다면 플래그를 변경
            searchFlag = true;
            //toString()메소드를 오버라이딩 했으므로 객체를 즉시 출력가능.
            System.out.println(avengers);
         }
      }
      if(searchFlag == true) {
         System.out.println("요청하신 정보를 찾았습니다.");
      }else {
         System.out.println("해당 영웅은 없어요ㅜㅜ");
      }
   }
}