/**
 *
 * @author yangchen
 */
public class uglyNumber {

    static int total;
    static String s;

    public static void main(String[] args) {

        //for local test
        s = "123";
        process();
    }

    static void process() {
    
        total = 0;
        
        //set up first number
        int last = Integer.valueOf(s.substring(0, 1));
        calculateNum('+', last, 1, last);
        System.out.println(total);
    }

    static void calculateNum(char opr, int last, int p, int currentSum) {
    
        //get a new number and check
        if (p == s.length()) {
            if (isUgly(currentSum)) {
                total++;
            }
            return;
        } 
        
        //keep calculate until through all string
        else {
            String firstChar = String.valueOf(s.charAt(p));
            int newLast;
            int newSum;            
            
            newLastPart = (Math.abs(last) * 10) + Integer.valueOf(firstChar);
            
            if (opr == '+') {
                newSum = currentSum - last + newLast;
            } else {
                newSum = currentSum + last - newLast;
            }
            
            //this will move to the end without any opr
            calculateNum(opr, newLast, s, p + 1, newSum);
            
            //jump out and adding, from end
            newLast = Integer.valueOf(firstChar);
            newSum = currentSum + newLast;
            calculateNum('+', newLast, s, p + 1, newSum);
            
            ////jump out and subtracting, from end
            newLast = Integer.valueOf(firstChar);
            newSum = currentSum - newLast;
            calculateNum('-', newLast, s, p + 1, newSum);
        }

    }

    static boolean sUgly(int n) {
    
        //check if the number=0 or divisible by 2 3 5 7
        if (n == 0 || n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0) {
            return true;
        }
        return false;
    }
}
