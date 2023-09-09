import javax.swing.*;

public class Calculator {
    private JTextPane textPane;
    private String outputString = "";
    private String firstNum = "";
    private boolean firstLock = false;
    private String secondNum = "";
    private String operator = "";
    private boolean intMode = false;

    public Calculator(JTextPane textPane){
        this.textPane = textPane;
        this.textPane.setText(outputString);
    }

    public void setIntMode(boolean bool){
        if(bool != this.intMode){
            this.intMode = bool;
            clear();
        }
    }

    public void numInput(int input){
        outputString += input;
        if(!firstLock){
            firstNum += input;
        } else {
            secondNum += input;
        }
        update();
    }

    public void del(){
        if(secondNum != ""){
            secondNum = secondNum.substring(0, secondNum.length()-1);
            outputString = firstNum + " " + operator + " " + secondNum;
        } else if(operator != ""){
            operator = "";
            firstLock = false;
            outputString = firstNum;
        } else {
            firstNum = firstNum.substring(0, firstNum.length()-1);
            firstLock = false;
            outputString = firstNum;
        }
        update();
    }
    public void decimalPoint(){
        if(!intMode){
            if(!firstLock && !firstNum.contains(".")){
                firstNum += ".";
                outputString += ".";
            } else if(firstLock && !secondNum.contains(".")){
                secondNum += ".";
                outputString += ".";
            }
            update();
        }
    }

    public void clear(){
        outputString = "";
        firstNum = "";
        firstLock = false;
        secondNum = "";
        operator = "";
        update();
    }

    public void mult(){
        if(operator == "" && firstNum != ""){
            firstLock = true;
            outputString += " * ";
            operator = "*";
            update();
        }
    }

    public void add(){
        if(operator == "" && firstNum != ""){
            firstLock = true;
            outputString += " + ";
            operator = "+";
            update();
        }
    }

    public void sub(){
        if(operator == "" && firstNum != ""){
            firstLock = true;
            outputString += " - ";
            operator = "-";
            update();
        }
    }

    public void div(){
        if(operator == "" && firstNum != ""){
            firstLock = true;
            outputString += " / ";
            operator = "/";
            update();
        }
    }

    public void sqrt(){
        if(!intMode || Math.sqrt(Integer.valueOf(firstNum)) == ((int) Math.sqrt(Integer.valueOf(firstNum)))){
            if(operator == "" && firstNum != ""){
                operator = "sqrt";
                enter();
            }
        } else {
            textPane.setText("Try a different operator");
        }
    }

    public void square(){
        if(operator == "" && firstNum != ""){
            operator = "^2";
            enter();
        }
    }

    public void inverse(){
        if(!intMode || 1/(Integer.valueOf(firstNum)) == ((int) 1/(Integer.valueOf(firstNum)))){
            if(operator == "" && firstNum != ""){
                operator = "1/x";
                enter();
            }
        } else {
            textPane.setText("Try a different operator");
        }
    }

    public void enter(){
        if(secondNum != "" || operator == "sqrt" || operator == "^2" || operator == "1/x"){
            String result = "";
            switch(operator){
                case "*":
                    result = ""+(Double.valueOf(firstNum)*Double.valueOf(secondNum));
                    break;
                case "+":
                    result = ""+(Double.valueOf(firstNum)+Double.valueOf(secondNum));
                    break;
                case "-":
                    result = ""+(Double.valueOf(firstNum)-Double.valueOf(secondNum));
                    break;
                case "/":
                    result = ""+(Double.valueOf(firstNum)/Double.valueOf(secondNum));
                    break;
                case "sqrt":
                    result = ""+(Math.sqrt(Double.valueOf(firstNum)));
                    break;
                case "^2":
                    result = ""+(Double.valueOf(firstNum)*Double.valueOf(firstNum));
                    break;
                case "1/x":
                    result = ""+(1.0/Double.valueOf(firstNum));
                    break;
            }
            if(intMode){
                switch(operator){
                    case "*":
                        result = ""+(Integer.valueOf(firstNum)*Integer.valueOf(secondNum));
                        break;
                    case "+":
                        result = ""+(Integer.valueOf(firstNum)+Integer.valueOf(secondNum));
                        break;
                    case "-":
                        result = ""+(Integer.valueOf(firstNum)-Integer.valueOf(secondNum));
                        break;
                    case "/":
                        result = ""+(Integer.valueOf(firstNum)/Integer.valueOf(secondNum));
                        break;
                    case "sqrt":
                        result = ""+((int) Math.sqrt(Integer.valueOf(firstNum)));
                        break;
                    case "^2":
                        result = ""+(Integer.valueOf(firstNum)*Integer.valueOf(firstNum));
                        break;
                    case "1/x":
                        result = ""+(1/Integer.valueOf(firstNum));
                        break;
                }
            }
            outputString = result;
            firstNum = result;
            firstLock = true;
            System.out.println(firstNum+", "+operator+", "+secondNum);

            operator = "";
            secondNum = "";
            update();
        }
    }

    private void update(){
        textPane.setText(outputString);
    }

}
