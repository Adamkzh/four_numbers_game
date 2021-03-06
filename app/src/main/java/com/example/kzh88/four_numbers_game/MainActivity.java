package com.example.kzh88.four_numbers_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.*;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * numbers
     */
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;

    /**
     * operator
     */
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button division;
    private Button check;
    /**
     * bracket
     */
    private Button left_bracket;
    private Button right_bracket;
    private Button delete;
    private Button ac_btn;
    /**
     * result
     */
    private EditText mResultText;
    /**
     * already entered string
     */
    private String existedText = "";
    private int[] numberStore = new int[4];
    private int max = 13, min = 1;

    /**
     *
     * Four numbers
     */
    private String one;
    private String two ;
    private String three ;
    private String four ;

    /**
     *
     * number already clicked
     */
    private boolean oneClickable = true;
    private boolean twoClickable = true;
    private boolean threeClickable = true;
    private boolean fourClickable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    /**
     * init controller
     */
    private void initView() {
        /**
         * numbers
         */
        num0 = (Button) findViewById(R.id.random_one);
        num1 = (Button) findViewById(R.id.random_two);
        num2 = (Button) findViewById(R.id.random_three);
        num3 = (Button) findViewById(R.id.random_four);

        /**
         * operators
         */
        plus = (Button) findViewById(R.id.plus_btn);
        minus = (Button) findViewById(R.id.minus_btn);
        multiply = (Button) findViewById(R.id.multiply_btn);
        division = (Button) findViewById(R.id.division_btn);
        check = (Button) findViewById(R.id.check);
        /**
         * others
         */
        left_bracket = (Button) findViewById(R.id.left_bracket_btn);
        right_bracket = (Button) findViewById(R.id.right_bracket_btn);
        delete = (Button) findViewById(R.id.delete_btn);
        ac_btn = (Button) findViewById(R.id.ac_btn);
        /**
         * result
         */
        mResultText = (EditText) findViewById(R.id.result_text);
        /**
         * already input string
         */
        existedText = mResultText.getText().toString();

    }

    /**
     * init event
     */
    private void initEvent() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);


        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        division.setOnClickListener(this);
        check.setOnClickListener(this);

        delete.setOnClickListener(this);
        ac_btn.setOnClickListener(this);
        left_bracket.setOnClickListener(this);
        right_bracket.setOnClickListener(this);
        gameInit();

    }

    private void gameInit(){

        //generate 4 numbers at start
        randomGenerator(min,max);

        one = Integer.toString(numberStore[0]);
        two = Integer.toString(numberStore[1]);
        three = Integer.toString(numberStore[2]);
        four = Integer.toString(numberStore[3]);

        num0.setText(one);
        num1.setText(two);
        num2.setText(three);
        num3.setText(four);
    }
    /***
     * generate random number array
     */
    private void randomGenerator(int min, int max){
        for(int i = 0; i < 4; i++){
            numberStore[i] = (int)(Math.random() * ((max - min) + 1)) + min;
        }
    }


    /**
     * click
     * @param v  clicked component
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            /**
             * numbers
             */
            case R.id.random_one:
                if(oneClickable){
                    existedText = isAllowed(existedText,one);
                    oneClickable = false;
                }
                break;
            case R.id.random_two:
                if(twoClickable){
                    existedText = isAllowed(existedText,two);
                    twoClickable = false;
                }
                break;
            case R.id.random_three:
                if(threeClickable){
                    existedText = isAllowed(existedText,three);
                    threeClickable = false;
                }
                break;
            case R.id.random_four:
                if(fourClickable){
                    existedText = isAllowed(existedText,four);
                    fourClickable = false;
                }
                break;

            /**
             * operator
             */
            case R.id.plus_btn:
                existedText = isAllowed(existedText,"+");
                break;
            case R.id.minus_btn:
                existedText = isAllowed(existedText,"-");
                break;
            case R.id.multiply_btn:
                existedText = isAllowed(existedText,"×");
                break;
            case R.id.division_btn:
                existedText = isAllowed(existedText,"÷");
                break;
            case R.id.left_bracket_btn:
                existedText = isAllowed(existedText,"(");
                break;
            case R.id.right_bracket_btn:
                existedText = isAllowed(existedText,")");
                break;

            //check
            case R.id.check:
                existedText = getResult();
                if(existedText.equals("24")){
                    gameInit();
                }else{
                    existedText = "error";
                }

                break;

             //delete
            case R.id.delete_btn:
                if (existedText.equals("error")){
                    existedText = "";
                } else if (existedText.length() > 0){
                    String cur;
                    if(existedText.length() > 1  &&  Character.isDigit(existedText.charAt(existedText.length()-2))){
                        cur = existedText.substring(existedText.length() - 2, existedText.length());
                        existedText = existedText.substring(0,existedText.length()-1);
                    }else{
                        cur =  existedText.substring(existedText.length()-1);
                    }
                        if( cur.equals(one)){
                            oneClickable = true;
                        }else if(cur.equals(two)){
                            twoClickable = true;
                        }else if(cur.equals(three)){
                            threeClickable = true;
                        }else if(cur.equals(four)){
                            fourClickable = true;
                        }
                        existedText = existedText.substring(0,existedText.length()-1);
                }
                break;
            case R.id.ac_btn:
                existedText = "";
                oneClickable = true;
                twoClickable = true;
                threeClickable = true;
                fourClickable = true;

                break;
        }
        /**
         * Set view
         */
        mResultText.setText(existedText);
    }



    /**
     * Operation get result
     * @return  return result
     */
    private String getResult() {
        String s = existedText;
        if (s == null || s.length() == 0) {
            return "0";
        }
        // initialize operator
        char sign = '+';
        Deque<Long> stack1 = new LinkedList<>(); // store digit and '('
        Deque<Character> stack2 = new LinkedList<>(); // store sign before '('
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                long num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                i--;
                stack1.offerFirst(eval(sign, stack1, num));
            } else if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                stack1.offerFirst(Long.MAX_VALUE);
                stack2.offerFirst(sign);
                sign = '+';
            } else if (ch == ')') {
                long num = 0;
                while (stack1.peekFirst() != Long.MAX_VALUE) {
                    num += stack1.pollFirst();
                }
                stack1.pollFirst(); // pop out '(' (Long.MAX_VALUE)
                char operator = stack2.pollFirst();
                stack1.offerFirst(eval(operator, stack1, num));
            } else {
                sign = ch;
            }
        }
        // what we need to do is just sum up all num in stack
        int result = 0;
        while (!stack1.isEmpty()) {
            result += stack1.pollFirst();
        }
        return Integer.toString(result);
    }
    private long eval(char sign, Deque<Long> stack1, long num) {
        if (sign == '+') {
            return num;
        } else if (sign == '-') {
            return -num;
        } else if (sign == '×') {
            return stack1.pollFirst() * num;
        } else {
            return stack1.pollFirst() / num;
        }
    }

    private String isAllowed(String existedText, String s) {
        return existedText + s;
    }
}
