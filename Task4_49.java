/*
Name: Lamar Kamal
No. 49
 */
package task4_49;

import java.util.*;

public class Task4_49 {

    public static String ones(int ones) {
        switch (ones) {
            case 48:
                return "";
            case 49:
                return "one";
            case 50:
                return "two";
            case 51:
                return "three";
            case 52:
                return "four";
            case 53:
                return "five";
            case 54:
                return "six";
            case 55:
                return "seven";
            case 56:
                return "eight";
            case 57:
                return "nine";
            default:
                return teen(10);
        }

    }
//---------------------------------------------------------------

    public static String tens(int tens) {
        switch (tens) {
            case 48:
                return "";
            case 50:
                return "Twenty ";
            case 51:
                return "half ";
            case 52:
                return "Forty ";
            case 53:
                return "Fifty ";

            default:
                return "rong input";
        }

    }
//---------------------------------------------------------------

    public static String teen(int teen) {
        switch (teen) {

            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";

            case 18:
                return "Eighteen";

            default:
                return "Nineteen";
        }

    }
//---------------------------------------------------------------

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String time = input.next();

        String hour = "";
        String strHour = "";
        String minutes = "";
        String strtens = "";
        String strones = "";

        //hours
        int c = 0;
        while (time.charAt(c) != ':') {
            if (time.charAt(c + 1) != ':') {
                hour += time.charAt(c) + "" + time.charAt(c + 1);
                strHour = teen(Integer.parseInt(hour));
                break;
            } else {
                hour += time.charAt(c);
                strHour = ones(time.charAt(c));
                break;
            }

        }

        // minutes
        for (int i = 0; i < time.length(); i++) {

            if (time.charAt(i) == ':') {
                int tens = (int) time.charAt(i + 1);
                if (tens == 49) {

                    minutes += time.charAt(i + 1) + "" + time.charAt(i + 2);
                    strtens = teen(Integer.parseInt(minutes));
                } else {

                    strtens = tens(tens);
                    int ones = time.charAt(i + 2);
                    strones = ones(ones);
                    minutes += time.charAt(i + 1) + "" + time.charAt(i + 2);
                    break;
                }
            }

        }

        //printing
        if (Integer.parseInt(hour) > 12 || Integer.parseInt(hour) <= 0) {
            System.out.println("wrong hour input");
            System.exit(0);
        }
        if (Integer.parseInt(minutes) >= 60) {
            System.out.println("wrong minutes input");
            System.exit(0);

        } else if (Integer.parseInt(minutes) == 0) {
            System.out.println(strHour + " o' clock");
            System.out.println();

        } else if (Integer.parseInt(minutes) == 30) {
            System.out.println("half past " + strHour);
        } else if (Integer.parseInt(minutes) < 30) {
            if (Integer.parseInt(minutes) == 15) {
                System.out.println("quarter past " + strHour);

            } else {
                System.out.println(strtens + "" + strones + " minutes past " + strHour);
            }

        } else if (Integer.parseInt(minutes) > 30) {

            if (Integer.parseInt(minutes) == 45) {
                if (time.charAt(c + 1) != ':') {
                    hour = time.charAt(c) + "" + time.charAt(c + 1);
                    strHour = teen(Integer.parseInt(hour) + 1);
                    if (strHour.equalsIgnoreCase("Thirteen")) {
                        strHour = "one";
                    }
                } else {

                    strHour = ones(time.charAt(c) + 1);

                }
                System.out.println("quarter to " + strHour);

            } else {

                if (time.charAt(c + 1) != ':') {
                    hour = time.charAt(c) + "" + time.charAt(c + 1) ;
                    strHour = teen(Integer.parseInt(hour) + 1);
                    if (strHour.equalsIgnoreCase("Thirteen")) {
                        strHour = "one";
                    }
                } else {
                    hour += time.charAt(c) + 1;
                    strHour = ones(time.charAt(c) + 1);

                }

                Integer rest = 60 - Integer.parseInt(minutes);
                char charrest = rest.toString().charAt(0);
                if (charrest == 49) {
                    if (rest == 1) {
                        strones = ones(49);
                        System.out.println(strones + " minute to " + strHour);
                    } else {
                        strtens = teen(rest);
                        System.out.println(strtens + " minutes to " + strHour);
                    }

                } else if (rest >= 20) {
                    strtens = tens(rest.toString().charAt(0));
                    strones = ones(rest.toString().charAt(1));
                    System.out.println(strtens + "" + strones + " minutes to " + strHour);
                } else if (rest > 1 && rest < 10) {
                    strones = ones(rest.toString().charAt(0));
                    System.out.println(strones + " minutes to " + strHour);
                }

            }
        }
    }

}
