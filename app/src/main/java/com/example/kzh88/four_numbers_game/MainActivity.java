package com.example.kzh88.four_numbers_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


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
    private int max = 9, min = 0;

    /**
     *
     * Four numbers
     */

    private String one  = "";
    private String two = "";
    private String three = "";
    private String four = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    /**
     * 初始化控件
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
        left_bracket = (Button) findViewById(R.id.left_bracket);
        right_bracket = (Button) findViewById(R.id.right_bracket);
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
     * 点击事件
     * @param v  点击的控件
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            /**
             * numbers
             */
            case R.id.random_one:
                existedText = isAllowed(existedText,one);
                break;
            case R.id.random_two:
                existedText = isAllowed(existedText,Integer.toString(numberStore[1]));
                break;
            case R.id.random_three:
                existedText = isAllowed(existedText,Integer.toString(numberStore[2]));
                break;
            case R.id.random_four:
                existedText = isAllowed(existedText,Integer.toString(numberStore[3]));
                break;

            /**
             * 运算符
             */
            case R.id.plus_btn:

//                if (!existedText.contains("e")) {
//
//                    if (judgeExpression()) {
//                        existedText = getResult();
//                        if (existedText.equals("error")){
//
//                        } else {
//                            existedText += "+";
//                        }
//                    } else {
//
//                        if (isCounted) {
//                            isCounted = false;
//                        }
//
//                        if ((existedText.substring(existedText.length() - 1)).equals("-")) {
//                            existedText = existedText.replace("-", "+");
//                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
//                            existedText = existedText.replace("×", "+");
//                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
//                            existedText = existedText.replace("÷", "+");
//                        } else if (!(existedText.substring(existedText.length() - 1)).equals("+")) {
//                            existedText += "+";
//                        }
//                    }
//                } else {
//                    existedText = "0";
//                }

                break;
            case R.id.minus_btn:

//                if (!existedText.contains("e")) {
//                    if (judgeExpression()) {
//                        existedText = getResult();
//                        if (existedText.equals("error")){
//
//                        } else {
//                            existedText += "-";
//                        }
//                    } else {
//
//                        if (isCounted) {
//                            isCounted = false;
//                        }
//
//                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
////                    Log.d("Anonymous", "onClick: " + "进入减法方法");
//                            existedText = existedText.replace("+", "-");
//                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
//                            existedText = existedText.replace("×", "-");
//                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
//                            existedText = existedText.replace("÷", "-");
//                        } else if (!(existedText.substring(existedText.length() - 1)).equals("-")) {
//                            existedText += "-";
//                        }
//                    }
//                } else {
//                    existedText = "0";
//                }
                break;
            case R.id.multiply_btn:

//                if (!existedText.contains("e")) {
//                    if (judgeExpression()) {
//                        existedText = getResult();
//                        if (existedText.equals("error")){
//
//                        } else {
//                            existedText += "×";
//                        }
//
//                    } else {
//
//                        if (isCounted) {
//                            isCounted = false;
//                        }
//
//                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
//                            existedText = existedText.replace("+", "×");
//                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
//                            existedText = existedText.replace("-", "×");
//                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
//                            existedText = existedText.replace("÷", "×");
//                        } else if (!(existedText.substring(existedText.length() - 1)).equals("×")) {
//                            existedText += "×";
//                        }
//                    }
//                } else {
//                    existedText = "0";
//                }
                break;
            case R.id.division_btn:

//                if (!existedText.contains("e")) {
//                    if (judgeExpression()) {
//                        existedText = getResult();
//                        if (existedText.equals("error")){
//
//                        } else {
//                            existedText += "÷";
//                        }
//
//                    } else {
//
//                        if (isCounted) {
//                            isCounted = false;
//                        }
//
//                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
//                            existedText = existedText.replace("+", "÷");
//                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
//                            existedText = existedText.replace("-", "÷");
//                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
//                            existedText = existedText.replace("×", "÷");
//                        } else if (!(existedText.substring(existedText.length() - 1)).equals("÷")) {
//                            existedText += "÷";
//                        }
//                    }
//                } else {
//                    existedText = "0";
//                }
                break;
            case R.id.check:
                existedText = getResult();
                break;
            /**
             * 其他
             */

            case R.id.delete_btn:
                /**
                 * 字符串长度大于 0 时才截取字符串
                 * 如果长度为 1，则直接把字符串设置为 0
                 */
                if (existedText.equals("error")){
                    existedText = "0";
                } else if (existedText.length() > 0){
                    if (existedText.length() == 1) {
                        existedText = "0";
                    } else {
                        existedText = existedText.substring(0,existedText.length()-1);
                    }
                }
                break;
            case R.id.ac_btn:
                existedText = "";
                break;
        }
        /**
         * 设置显示
         */
        mResultText.setText(existedText);
    }



    /**
     * 进行运算，得到结果
     * @return  返回结果
     */
    private String getResult() {

        /**
         * 结果
         */
        String tempResult = null;
        /**
         * 两个String类型的参数
         */
        String param1 = null;
        String param2 = null;
        /**
         * 转换后的两个double类型的参数
         */
        double arg1 = 0;
        double arg2 = 0;
        double result = 0;

//        getCondition();

        /**
         * 如果有运算符，则进行运算
         * 没有运算符，则把已经存在的数据再传出去
         */

            tempResult = existedText;


        return tempResult;
    }


    /**
     * 先判断是否按过等于号
     * 是 按数字则显示当前数字
     * 否 在已有的表达式后添加字符
     *
     * 判断数字是否就是一个 0
     * 是 把字符串设置为空字符串。
     *   1、打开界面没有运算过的时候，AC键归零或删除完归零的时候，会显示一个 0
     *   2、当数字是 0 的时候，设置成空字符串，再按 0 ，数字会还是 0，不然可以按出 000 这种数字
     * 否 添加按下的键的字符
     *
     * 判断数字是否包含小数点
     * 是 数字不能超过十位
     * 否 数字不能超过九位
     *
     * 进行上面的判断后，再判断数字是否超过长度限制
     * 超过不做任何操作
     * 没超过可以再添数字
     */
    private String isAllowed(String existedText, String s) {
        return existedText + s;
    }


    /**
     * 使用java正则表达式去掉多余的.与0
     * @param s 传入的字符串
     * @return 修改之后的字符串
     */
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    /**
     * 判断表达式
     *
     * 为了按等号是否进行运算
     * 以及出现两个运算符（第一个参数如果为负数的符号不计）先进行运算再添加运算符
     */
//    private boolean judgeExpression() {
//
//        getCondition();
//
//        String tempParam2 = null;
//
//        if ( startWithOperator || noStartWithOperator || startWithSubtract) {
//
//            if (existedText.contains("+")) {
//                /**
//                 * 先获取第二个参数
//                 */
//                tempParam2 = existedText.substring(existedText.indexOf("+") + 1);
//                /**
//                 * 如果第二个参数为空，表达式不成立
//                 */
//                if (tempParam2.equals("")) {
//                    return false;
//                } else {
//                    return true;
//                }
//            } else if (existedText.contains("×")) {
//
//                tempParam2 = existedText.substring(existedText.indexOf("×") + 1);
//
//                if (tempParam2.equals("")) {
//                    return false;
//                } else {
//                    return true;
//                }
//
//            } else if (existedText.contains("÷")) {
//
//                tempParam2 = existedText.substring(existedText.indexOf("÷") + 1);
//
//                if (tempParam2.equals("")) {
//                    return false;
//                } else {
//                    return true;
//                }
//
//            } else if (existedText.contains("-")) {
//
//                /**
//                 * 这里是以最后一个 - 号为分隔去取出两个参数
//                 * 进到这个方法，必须满足有运算公式
//                 * 而又避免了第一个参数是负数的情况
//                 */
//                tempParam2 = existedText.substring(existedText.lastIndexOf("-") + 1);
//
//                if (tempParam2.equals("")) {
//                    return false;
//                } else {
//                    return true;
//                }
//
//            }
//        }
//        return false;
//    }

    /**
     * 取得判断条件
     */
//    private void getCondition() {
//        /**
//         * 以负号开头，且运算符不是是减号
//         * 例如：-21×2
//         */
//        startWithOperator = existedText.startsWith("-") && ( existedText.contains("+") ||
//                existedText.contains("×") || existedText.contains("÷") );
//        /**
//         * 以负号开头，且运算符是减号
//         * 例如：-21-2
//         */
//        startWithSubtract = existedText.startsWith("-") && ( existedText.lastIndexOf("-") != 0 );
//        /**
//         * 不以负号开头，且包含运算符
//         * 例如：21-2
//         */
//        noStartWithOperator = !existedText.startsWith("-") && ( existedText.contains("+") ||
//                existedText.contains("-") || existedText.contains("×") || existedText.contains("÷"));
//    }

}
