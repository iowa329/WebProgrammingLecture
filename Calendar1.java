package html1;

import java.util.Calendar;

public class Calendar1 {

    /*
     * 달력 출력
     *
     * firstDayOfWeek: 1일의 요일
     *    일:1, 월:2, 화:3, ... 토:7
     *
     * lastDay: 마지막 날짜
     */
    static void printCalendar(int firstDayOfWeek, int lastDay) {
    	for(int i=1; i<firstDayOfWeek; i++) {
    		System.out.print("  " + " ");
    	}

    	int drawer = firstDayOfWeek;
    	for(int day=1; day<=lastDay; day++) {
    		if(day < 10) {
    			System.out.print(" " + day + " ");
    		} else {
    			System.out.print(day + " ");
    		}

    		// 토요일(7)에 도달 했을 경우 한 줄을 내린다.
    		if(drawer == 7 && day != lastDay) {
    			System.out.println("");
    			drawer = 1;
    		} else {
    			drawer++;
    		}
    	}
    }

    public static void main(String[] args) {
        // year년 month월
        int year = 2020, month = 3;

        // year년 month월 1일의 요일 구하기
        Calendar calendar = Calendar.getInstance();
        // 월의 경우 해당 월의 -1로 해야한다. (1월의 경우 0 부터 시작)
        calendar.set(year, month - 1, 1, 0, 0);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // year년 month월의 마지막 날짜 구하기
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        int lastDay = calendar.get(Calendar.DATE);

        // 달력 출력
        System.out.println(year + "년 " + month + "월");
        printCalendar(firstDayOfWeek, lastDay);
    }
}