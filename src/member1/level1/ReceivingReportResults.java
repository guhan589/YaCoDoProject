package member1.level1;

import java.util.*;
import java.util.stream.Collectors;

public class ReceivingReportResults {
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
        int[] answer = {};
        answer = new int[id_list.length];
        List<String> list;
        List<String> collect = Arrays.stream(report).distinct().collect(Collectors.toList());
        Map<String, Integer> reportCnt = new HashMap<>();
        Map<String, List<String>> reportLog = new HashMap<>();
        /**
         * 1. 먼저 신고한 사람들의 목록 list를 담고 있어야함
         * 2. 신고당한 사람들의 횟수를 담는 map을 가지고 있어야함*/
        for (String s : collect) {
            String[] split_str = s.split(" ");

            /**신고를 당한 횟수 put*/
            if (reportCnt.get(split_str[1]) == null) {
                reportCnt.put(split_str[1], 1);
            } else {
                reportCnt.put(split_str[1], reportCnt.get(split_str[1]) + 1);
            }
            if (reportLog.get(split_str[0]) == null) {
                list = new ArrayList<>();
                list.add(split_str[1]);
                reportLog.put(split_str[0], list);
                
            } else {
                list = reportLog.get(split_str[0]);
                list.add(split_str[1]);
                reportLog.put(split_str[0], list);
            }
        }

        for (String s : reportCnt.keySet()) {
            if (reportCnt.get(s) >= k) { //신고 총건수가 k보다 크거나 같을경우
                for (String s1 : reportLog.keySet()) {
                    if (reportLog.get(s1).contains(s)) {
                        for (int i = 0; i < id_list.length; i++) {
                            if (id_list[i].equals(s1)) {
                                answer[i] +=1;
                            }
                        }
                    }
                }
            }

        }

        


        return answer;
    }
}
