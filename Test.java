import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
//            这里使用无限循环来达到无限次数使用的效果
            System.out.println("==============================\n" +
                    "     欢迎使用密码加密解密系统\n" +
                    "==============================\n" +
                    "请选择操作：\n"+
                    "1. 加密\n" +
                    "2. 解密\n" +
                    "3. 退出\n");
            int number= 0;
            try {
                number = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("您输入了非法字符");
                break;
            }
//            使用try catch语句这样就不用其他的进行筛选，只要不符合规格就抛出
            if (number>=1 && number<=3){

            }else {
                System.out.println("您输入了非法字符");
                break;
            }


            switch (number){
                case  1:
                    method1(sc);
                    break;
                case 2:
                    method2(sc);
                    break;
                case  3:
                    System.exit(0);
            }
        }


    }

    private static void method1(Scanner scanner) {
        System.out.println("请输入要加密的数字");
        String s=scanner.next();
        int[]arr=new int[s.length()];
        if (check(s)) return;
//        检验是不是合格的

        for (int i = 0; i < s.length(); i++) {
            arr[i]=Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        int temp=arr[arr.length-1];
        arr[arr.length-1]=arr[arr.length-2];
        arr[arr.length-2]=temp;

        for (int i = 0; i < arr.length; i++) {
            arr[i]+=5;
            arr[i]%=10;
            arr[i]*=2;
        }

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        sb.reverse();
        System.out.println("加密后的数字是"+sb);
    }

    private static void method2(Scanner scanner) {
        System.out.println("请输入要解密的数字");
        String s=scanner.next();
        if (check(s)) return;
        StringBuilder sb=new StringBuilder(s);
        StringBuilder stringBuilder=new StringBuilder();
        int []arr=new int[sb.length()];
        sb.reverse();
        for (int i = 0; i < sb.toString().length(); i++) {
            int temp=99999;
            if (temp==i-1){
                continue;
            }
            if (sb.toString().charAt(i)==49){
                temp=i;
                stringBuilder.append(magic(String.valueOf(sb.toString().charAt(i+1))));
            }else {
                stringBuilder.append(Integer.valueOf(String.valueOf(sb.toString().charAt(i)))/2);
            }
        }
        for (int i = 0; i < stringBuilder.toString().length(); i++) {
            int number=Integer.parseInt(String.valueOf(stringBuilder.toString().charAt(i)));
            number/=2;
            number+=10;
            number-=5;
            arr[i]=number;
        }
        int temp=arr[arr.length-1];
        arr[arr.length-1]=arr[arr.length-2];
        arr[arr.length-2]=temp;
        StringBuilder stringBuilder1=new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder1.append(arr[i]);
        }
        System.out.println("要加密的数字是"+stringBuilder1);






    }

    private static String magic(String s) {
        switch (s){
            case "0":
                return "5";
            case "2":
                return "6";
            case "3":
                return "7";
            case "4":
                return "8";
            case "5":
                return "9";


        }



return null;
    }


        private static boolean check(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.length()==1){
                return true;
            }
            char temp= s.charAt(i);
            if (temp>=48 && temp<=57){

            }else {
                System.out.println("加密的必须是数字");
                return true;
            }
        }
        return false;
    }
}
