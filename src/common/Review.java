package common;

import java.util.HashMap;
import java.util.Map;

public class Review {
    String packageName;
    static Map<String, String> packMap = new HashMap<>();
    private static Review review = null;
    private Review() {
        packMap.put("member1","구환주임");
        packMap.put("member2","혜연주임");
        packMap.put("member3","아라주임");
        packMap.put("member4","지은주임");

    }
    public static Review getInstance()
    {
        if(review == null)
            review = new Review();
        return review;
    }
    public void show(String packageName)
    {
        if (packMap.get(packageName) == null) {
            System.out.println("사용하시려고 하는 패키지(" + packageName + ")의 소유자가 없습니다.");
            System.out.println("Review 클래스에서 사용자 이름을 등록하세요.");

        } else {
            System.out.println("현재 패키지의 소유자는 " + packMap.get(packageName) + " 입니다");
        }

    }


}
