package com.company;

public class Strokaa {

    private String[] slovo = new String[3]; // неточность

    private int cl = 0;//количество слов в строке
    private int n;
    private String ss;
    private char c = 'q';

    public Strokaa(String ll) {
        ss = ll;
        n = ss.length();
    }

    public int razbienie() {
        ss = ss + " ";

        for (int i = 1; i <= n; i++) {
            c = ss.charAt(i);//выделение символов

            if ((c == ' ') && (ss.charAt(i - 1) != ' '))
                cl++;
        }

        int l = 0;
        if (cl == 3) {

            for (int i = 0; i < 3; i++) {
                slovo[i] = "";
            }

            for (int i = 1; i <= n; i++) {
                c = ss.charAt(i);//выделение символов

                if (ss.charAt(i - 1) != ' ')
                    slovo[l] = slovo[l] + ss.charAt(i - 1);

                if ((c == ' ') && (ss.charAt(i - 1) != ' '))
                    l++;
            }
        }
        return cl;
    }

    public void proverka() {//проверка на соответствие цифрам(араб и рим)

        String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rim = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] opera = new String[]{"+", "-", "*", "/"};

        int[] aa = new int[2];

        for (int j = 0; j < 10; j++) {
            if (slovo[0].equals(arab[j]))
                ++aa[0];
            if (slovo[2].equals(arab[j]))
                ++aa[0];
        }
        for (int j = 0; j < 4; j++) {
            if (slovo[1].equals(opera[j]))
                ++aa[0];
        }

        for (int j = 0; j < 10; j++) {
            if (slovo[0].equals(rim[j]))
                ++aa[1];
            if (slovo[2].equals(rim[j]))
                ++aa[1];
        }
        for (int j = 0; j < 4; j++) {
            if (slovo[1].equals(opera[j]))
                ++aa[1];
        }

        if (aa[0] == 3) {
            Operacia wq = new Operacia(slovo);
            wq.perevod_arab();
            int result = wq.vichisl();
            System.out.println(result);
        }
        if (aa[1] == 3) {
            Operacia wq = new Operacia(slovo);
            int l = wq.perevod_rim();
            if (!((l == 0)&&(slovo[1].equals(opera[1])))) {//если не(< и -)
                wq.vichisl();
                String result = wq.result_rim();
                System.out.println(result);
            }

        }

    }
}