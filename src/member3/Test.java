package member3;

import common.Review;

public class Test {
    public static void main(String[] args) {
        Class aClass;
        {
            try {
                aClass = Class.forName("member3.Test");
                Review review = Review.getInstance();
                review.show(aClass.getPackageName());

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
