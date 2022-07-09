package member1.level1;

import java.util.*;
public class ReceivingReportResults2 {
    
    /**
     * 난이도 : 1
     * 문제명: 신고결과받기
     * */
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 2;


        int[] solution = solution(id_list, report, k);
        for (int i : solution)
        {
            System.out.println("i = " + i);
        }

    }

    public static int[] solution(String[] id_list, String[] report, int k) {

            Map<String, List<String>> map = new HashMap<>();
            Map<String, Integer> mail_map = new HashMap<>();

            for (String user : id_list) {
                List<String> list = new LinkedList<>();
                map.put(user, list);
                mail_map.put(user, 0);
            }


            for(String temp: report){
                String[] split_str = temp.split(" ");
                String human1 = split_str[0]; // 신고자
                String human2 = split_str[1]; // 범인
                List<String> list = map.get(human2);

                if(list.contains(human1)){
                    continue;
                }
                list.add(human1);
                map.put(human2,list);
            }

            for(String data: map.keySet()){
                List<String> list = map.get(data);
                if(list.size()>=k){

                    for(String user: list){
                        int count = mail_map.get(user) + 1;
                        mail_map.put(user,count);
                    }
                }
            }
            int i=0;
            int[] answer = new int[id_list.length];
            for(String data: id_list){
                answer[i]= mail_map.get(data);
                i++;
            }
            return answer;
    }
}
