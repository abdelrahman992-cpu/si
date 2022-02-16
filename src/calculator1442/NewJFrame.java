/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator1442;

import java.awt.Image;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author darag
 */
public class NewJFrame extends javax.swing.JFrame {
 
 DecimalFormat format = new DecimalFormat("0.###############");
 int counter = 0;
 int NumberofMarks=0;
private String st; 

private double no1 = 0.0; 
 
private double no2 = 0.0; 
 
private double total = 0.0; 
 private double totel = 0.0;
private Double Memory ; 


 private void Calculation(int n,double in[])
{
       	double sum=0;  
	for(int i=0;i<n;i++) 
	{
		sum=sum+in[i];
	}
	double mean=sum/n;
       	System.out.println("Mean :"+mean);
	sum=0;
	for(int i=0;i<n;i++) 
	{
		sum+=Math.pow((in[i]-mean),2);
	}
	mean=sum/(n-1);
	double deviation=Math.sqrt(mean);
	System.out.println("standard deviation :"+deviation);
}

private int factorial(int n){    
  if (n == 0)    
    return 1;    
  else    
    return(n * factorial(n-1));    
 }


private int convertoctaltodecimal(int octal)
{
    int decimalNumber=0, i=0;
    while(octal!=0){
        decimalNumber +=(octal%10)*Math.pow(8,i);
        ++i;
        octal/=10;
    }
    return decimalNumber;
}
 private double calculate(String str) {
 
        return new Object() {
            int pos = -1, ch;
 
            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
 
            boolean eat(int charToEat) {
                while (ch == ' ') {
                    nextChar();
                }
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
 
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                return x;
            }
 
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) {
                        x += parseTerm();
                    }
                    else if (eat('-')) {
                        x -= parseTerm();
                    }
                    else {
                        return x;
                    }
                }
            }
 
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('×')) {
                        x *= parseFactor();
                    }
                    else if (eat('÷')) {
                        x /= parseFactor();
                    }
                    else if (eat('%')) {
                        x %= parseFactor();
                    }
                    else {
                        return x;
                    }
                }
            }
 
            double parseFactor() {
                if (eat('+')) {
                    return parseFactor();
                }
                if (eat('-')) {
                    return -parseFactor();
                }
                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                }
                else if (eat('e')) {
                    x = Math.E;
                }
                else if (eat('π')) {
                    x = Math.PI;
                }
                else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                }
                else if (ch >= 'a' && ch <= 'z' || ch == '√') {
                    while (ch >= 'a' && ch <= 'z' || ch == '√') {
                        nextChar();
                    }
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    switch (func) {
                        case "√":
                            x = Math.sqrt(x);
                            break;
                        case "sin":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "cos":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "tan":
                            x = Math.tan(Math.toRadians(x));
                            break;
                        default:
                            throw new RuntimeException("Unknown function: " + func);
                    }
                }
                else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                if (eat('^')) {
                    x = Math.pow(x, parseFactor());
                }
                return x;
 
            }
 
        }.parse();
    }

public static int hextodecimal(String hex)
{int decimalvalue=0;
for(int i=0; i<hex.length();i++){
char hexchar=hex.charAt(i);
decimalvalue=decimalvalue*16+hexchartodecimal(hexchar);}
return decimalvalue;}
    public static int hexchartodecimal(char ch){
    if(ch>='A'&&ch<='F')
        return 10+ch-'A';
    else if (ch>='a'&&ch<='f')
        return 10+ch-'a';
    else
        return ch-'0';
    }
    public void sin_isClicked(){
     
     String   l=inputField.getText();
        double no1=Double.parseDouble( inputField.getText());
double x=Math.toRadians(no1);
double y=Math.round(Math.sin(x)*1000)/1000.0;
String z= Double.toString(y);
inputField.setText("sin("+l+") ="+z);
        
 
 
 
    }
 
    // ?? ???? ???? ?? ??????????? × ????? ??? ??? ?????? cos ???? ????? ?????? cos ??? ????? ??? ????
    public void cos_isClicked(){
 
     String   l=inputField.getText();
        double no1=Double.parseDouble(inputField.getText());
 
 
double x=Math.toRadians(no1);
double y=Math.round(Math.cos(x)*1000)/1000.0;
String z= Double.toString(y);
inputField.setText("cos("+l+") ="+z);
    }
 
    // ?? ???? ???? ?? ??????????? × ????? ??? ??? ?????? tan ???? ????? ?????? tan ??? ????? ??? ????
    public void tan_isClicked(){
       
        
     String   l=inputField.getText();
        double no1;
         no1 = Double.parseDouble(inputField.getText());
double x=Math.toRadians(no1);
double y=Math.sin(x);
double z=Math.cos(x);
double r=y/z;
if(r!=0){
    String f=Double.toString(r);
    inputField.setText("tan("+l+") ="+f);
}
else{
JOptionPane.showMessageDialog(null,"infinty");
 
 
    }   
 
     
        
    }
    public void sqrt_isClicked(){
        autoAddOrRemove("symbol");
        inputField.setText(inputField.getText() + "v");
    }
 
    // ?? ???? ???? ?? ??????????? × ???? ??? ??? ?????? e ???? ????? e ??? ????? ??? ????
    public void exponential_isClicked(){
        autoAddOrRemove("symbol");
        inputField.setText(inputField.getText() + "e");
    }
 
    // ?? ???? ???? ?? ??????????? × ???? ??? ??? ?????? p ???? ????? p ??? ????? ??? ????
    public void pi_isClicked(){
        autoAddOrRemove("symbol");
        inputField.setText(inputField.getText() + "π");
    }
      public void parentesesLeft_isClicked(){
        autoAddOrRemove("symbol");
        inputField.setText(inputField.getText() + "(");
    }
       public void parentesesRight_isClicked(){
        autoAddOrRemove("symbol");
        inputField.setText(inputField.getText() + ")");
    }
 
    // ??? ????? ??? ?? ?????? ( ?? ??????? ) ???? ????? ???? ?? ???? ???? ?? ????? 0 ????? ?? ??? ??? ???? ???? ??????
    public void comma_isClicked(){
        String str = inputField.getText();
        if (inputField.getText().isEmpty()) {
            inputField.setText("0.");
        }
        else {
            int lastPointIndex = str.lastIndexOf(".");
            int lastPlusIndex = str.lastIndexOf("+");
            int lastMinusIndex = str.lastIndexOf("-");
            int lastMultipleIndex = str.lastIndexOf("×");
            int lastDivideIndex = str.lastIndexOf("÷");
            int lastModuloIndex = str.lastIndexOf("%");
 
            if (lastPointIndex <= lastPlusIndex ||
                lastPointIndex <= lastMinusIndex ||
                lastPointIndex <= lastMultipleIndex ||
                lastPointIndex <= lastDivideIndex ||
                lastPointIndex <= lastModuloIndex ) {
                    autoAddOrRemove("point");
                    inputField.setText(inputField.getText() + ".");
            }
        }
    }
    public void back_isClicked(){
        String temp = inputField.getText();
        if (temp.equals("Error") || temp.equals("cannot divide by 0")) {
            inputField.setText("");
        }
        else if (!temp.isEmpty()) {
            temp = inputField.getText().substring(0, inputField.getText().length() - 1);
            if (temp.length() >= 2) {
                switch (temp.substring(temp.length() - 2)) {
                    case "co":
                    case "si":
                    case "ta":
                        temp = temp.substring(0, temp.length() - 2);
                        break;
                }
            }
            inputField.setText(temp);
        }
    }
    public  void autoAddOrRemove(String button) {
 
       
        if (!inputField.getText().isEmpty()) {
            Character lastCharacter = inputField.getText().charAt(inputField.getText().length() - 1);
 
            switch (button) {
 
               
                case "symbol":
                    switch (lastCharacter) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case 'e':
                        case 'p':
                            inputField.setText(inputField.getText() + "×");
                            break;
                        case '.':
                            inputField.setText(inputField.getText() + "0×");
                            break;
                    }
                    break;
 
                // ???? ????? ????? × ???? ,p ?? e ?? lastCharacter ??? ?? ????? ??? ??? ? ??? ????? ?????? ?? ??????
                // ????? ?? 0 ?? ???? ?? ???? ???? ??? lastCharacter ? ??? ?? ????? ??? ??? ? ??? ??? ??? ???? ?? ??????
                case "number":
                    switch (lastCharacter) {
                        case 'e':
                        case 'p':
                            inputField.setText(inputField.getText() + "×");
                            break;
                        case '0':
                            String str = inputField.getText();
                            if ( str.equals("0") ||
                                 str.endsWith("+0") ||
                                 str.endsWith("-0") ||
                                 str.endsWith("×0") ||
                                 str.endsWith("÷0") ||
                                 str.endsWith("%0") ||
                                 str.endsWith("^0") ||
                                 str.endsWith("v0") ||
                                 str.endsWith("(0") ||
                                 str.endsWith("cos0") ||
                                 str.endsWith("sin0") ||
                                 str.endsWith("tan0") )
                                inputField.setText(inputField.getText().substring(0, inputField.getText().length()-1));
                        break;
                    }
                break;
 
                // ?? ??? ??????? ??????? ?? ???? ???? ???? lastCharacter ??? ?? ????? ??? ???? ? ??? ????? ?????? ?? ??????
                // ???? ??????? ?? ?????? ???????? ??? ???? ?? ?????? ???? ??? ?? ??? ???? ??????? ??? ????
                case "operand":
                    switch (lastCharacter) {
                        case '+':
                        case '-':
                        case '×':
                        case '÷':
                        case '%':
                        case '.':
                        inputField.setText(inputField.getText().substring(0, inputField.getText().length()-1));
                        break;
                    }
                break;
 
                // ?? ??? ?????????? ??????? lastCharacter ??? ?? ????? ??? ?????? ? ??? ????? ?????? ?? ??????
                // ???? ????? 0 ?? 0× ?????, ?? ??? ?????? ????? ??? ???? ?????? ???? ???
                case "point":
                    switch (lastCharacter) {
                        case '+':
                        case '-':
                        case '×':
                        case '÷':
                        case '%':
                        case '(':
                        case 'v':
                        case 'p':
                        case 's':
                        case 'n':
                        case '^':
                            inputField.setText(inputField.getText() + "0");
                            break;
                        case ')':
                            inputField.setText(inputField.getText() + "×0");
                            break;
                        case '.':
                            inputField.setText(inputField.getText().substring(0, inputField.getText().length()-1));
                            break;
                    }
                break;
 
            }
        }
    }
 
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        inputField = new javax.swing.JTextField();
        one = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        six = new javax.swing.JButton();
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        plus = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        mul = new javax.swing.JButton();
        div = new javax.swing.JButton();
        equal = new javax.swing.JButton();
        pow = new javax.swing.JButton();
        sine = new javax.swing.JButton();
        cose = new javax.swing.JButton();
        tane = new javax.swing.JButton();
        sqr = new javax.swing.JButton();
        comma = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        back = new javax.swing.JButton();
        forward = new javax.swing.JButton();
        or = new javax.swing.JButton();
        log = new javax.swing.JButton();
        and = new javax.swing.JButton();
        no = new javax.swing.JButton();
        parentesesLeft = new javax.swing.JButton();
        parentesesRight = new javax.swing.JButton();
        modulo = new javax.swing.JButton();
        ex = new javax.swing.JButton();
        pi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        historyText = new javax.swing.JTextArea();
        plns = new javax.swing.JButton();
        log10 = new javax.swing.JButton();
        exp = new javax.swing.JButton();
        hextodeci = new javax.swing.JButton();
        tohex = new javax.swing.JButton();
        decitobin = new javax.swing.JButton();
        bitodec = new javax.swing.JButton();
        hextobi = new javax.swing.JButton();
        bitohexa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        answer = new javax.swing.JButton();
        sinh = new javax.swing.JButton();
        cosh = new javax.swing.JButton();
        tanh = new javax.swing.JButton();
        asin = new javax.swing.JButton();
        acos = new javax.swing.JButton();
        atan = new javax.swing.JButton();
        fact = new javax.swing.JButton();
        decitooct = new javax.swing.JButton();
        bitooct = new javax.swing.JButton();
        octodec = new javax.swing.JButton();
        octtobi = new javax.swing.JButton();
        calmean = new javax.swing.JButton();
        counto = new javax.swing.JTextField();
        sum = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        addomean = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        devia = new javax.swing.JButton();
        a = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        caldeg2 = new javax.swing.JButton();
        x = new javax.swing.JTextField();
        y = new javax.swing.JTextField();
        caldeg1 = new javax.swing.JButton();
        plns1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        view = new javax.swing.JMenu();
        history = new javax.swing.JCheckBoxMenuItem();
        exit = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        copyHistory = new javax.swing.JMenuItem();
        clearHistory = new javax.swing.JMenuItem();
        printHistory = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

        jButton3.setText("jButton3");

        jToggleButton1.setText("jToggleButton1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem4.setText("jMenuItem4");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu4.setText("jMenu4");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        inputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFieldActionPerformed(evt);
            }
        });

        one.setText("1");
        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneActionPerformed(evt);
            }
        });

        two.setText("2");
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoActionPerformed(evt);
            }
        });

        three.setText("3");
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeActionPerformed(evt);
            }
        });

        four.setText("4");
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourActionPerformed(evt);
            }
        });

        five.setText("5");
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveActionPerformed(evt);
            }
        });

        six.setText("6");
        six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixActionPerformed(evt);
            }
        });

        seven.setText("7");
        seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenActionPerformed(evt);
            }
        });

        eight.setText("8");
        eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightActionPerformed(evt);
            }
        });

        nine.setText("9");
        nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nineActionPerformed(evt);
            }
        });

        zero.setText("0");
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });

        plus.setText("+");
        plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusActionPerformed(evt);
            }
        });

        minus.setText("-");
        minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusActionPerformed(evt);
            }
        });

        mul.setText("*");
        mul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mulActionPerformed(evt);
            }
        });

        div.setText("/");
        div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divActionPerformed(evt);
            }
        });

        equal.setText("=");
        equal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalActionPerformed(evt);
            }
        });

        pow.setText("p");
        pow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powActionPerformed(evt);
            }
        });

        sine.setText("sin");
        sine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sineActionPerformed(evt);
            }
        });

        cose.setText("cos");
        cose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coseActionPerformed(evt);
            }
        });

        tane.setText("tan");
        tane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taneActionPerformed(evt);
            }
        });

        sqr.setText("√");
        sqr.setPreferredSize(new java.awt.Dimension(46, 23));
        sqr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqrActionPerformed(evt);
            }
        });

        comma.setText(".");
        comma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commaActionPerformed(evt);
            }
        });

        clear.setText("CE");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        back.setText("<-");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        forward.setText("->");

        or.setText("|");
        or.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orActionPerformed(evt);
            }
        });

        log.setText("log");
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });

        and.setText("&");
        and.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                andActionPerformed(evt);
            }
        });

        no.setText("~");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        parentesesLeft.setText("(");
        parentesesLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentesesLeftActionPerformed(evt);
            }
        });

        parentesesRight.setText(")");
        parentesesRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentesesRightActionPerformed(evt);
            }
        });

        modulo.setText("%");
        modulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduloActionPerformed(evt);
            }
        });

        ex.setText("e");
        ex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exActionPerformed(evt);
            }
        });

        pi.setText("b");
        pi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piActionPerformed(evt);
            }
        });

        historyText.setColumns(20);
        historyText.setRows(5);
        jScrollPane1.setViewportView(historyText);

        plns.setText("+-");

        log10.setText("Log10");
        log10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log10ActionPerformed(evt);
            }
        });

        exp.setText("E");
        exp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expActionPerformed(evt);
            }
        });

        hextodeci.setText("hextodeci");
        hextodeci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hextodeciActionPerformed(evt);
            }
        });

        tohex.setText("tohex");
        tohex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tohexActionPerformed(evt);
            }
        });

        decitobin.setText("decitobin");
        decitobin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decitobinActionPerformed(evt);
            }
        });

        bitodec.setText("bitodec");
        bitodec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitodecActionPerformed(evt);
            }
        });

        hextobi.setText("hextobi");
        hextobi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hextobiActionPerformed(evt);
            }
        });

        bitohexa.setText("bitohexa");
        bitohexa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitohexaActionPerformed(evt);
            }
        });

        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        answer.setText("Ans");
        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });

        sinh.setText("sinh");
        sinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinhActionPerformed(evt);
            }
        });

        cosh.setText("cosh");
        cosh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coshActionPerformed(evt);
            }
        });

        tanh.setText("tanh");
        tanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanhActionPerformed(evt);
            }
        });

        asin.setText("asin");
        asin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asinActionPerformed(evt);
            }
        });

        acos.setText("acos");
        acos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acosActionPerformed(evt);
            }
        });

        atan.setText("atan");
        atan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atanActionPerformed(evt);
            }
        });

        fact.setText("fact");
        fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factActionPerformed(evt);
            }
        });

        decitooct.setText("decitooct");
        decitooct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decitooctActionPerformed(evt);
            }
        });

        bitooct.setText("bitooct");
        bitooct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitooctActionPerformed(evt);
            }
        });

        octodec.setText("octodec");
        octodec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                octodecActionPerformed(evt);
            }
        });

        octtobi.setText("octtobi");
        octtobi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                octtobiActionPerformed(evt);
            }
        });

        calmean.setText("calmean");
        calmean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calmeanActionPerformed(evt);
            }
        });

        counto.setText("0");

        sum.setText("0");

        jScrollPane2.setViewportView(jList1);

        addomean.setText("addomean");
        addomean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addomeanActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        devia.setText("devia");
        devia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deviaActionPerformed(evt);
            }
        });

        b.setText("     ");

        c.setText("      ");

        d.setText("          ");
        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });

        jLabel1.setText("x2+");

        jLabel2.setText("x +");

        jLabel3.setText("=");

        caldeg2.setText("caldeg2");
        caldeg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caldeg2ActionPerformed(evt);
            }
        });

        x.setText(" ");

        y.setText(" ");

        caldeg1.setText("caldeg1");
        caldeg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caldeg1ActionPerformed(evt);
            }
        });

        plns1.setText("n!");
        plns1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plns1ActionPerformed(evt);
            }
        });

        jButton2.setText("Normal Dis");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        view.setText("View");

        history.setSelected(true);
        history.setText("History");
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });
        view.add(history);

        exit.setText("exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        view.add(exit);

        jMenuBar1.add(view);

        edit.setText("Edit");

        copy.setText("copy");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        edit.add(copy);

        paste.setText("paste");
        paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });
        edit.add(paste);
        edit.add(jSeparator1);

        copyHistory.setText("copyHistory");
        copyHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyHistoryActionPerformed(evt);
            }
        });
        edit.add(copyHistory);

        clearHistory.setText("clearHistory");
        clearHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearHistoryActionPerformed(evt);
            }
        });
        edit.add(clearHistory);

        printHistory.setText("printHistory");
        printHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printHistoryActionPerformed(evt);
            }
        });
        edit.add(printHistory);

        jMenuBar1.add(edit);

        help.setText("Help");

        jMenuItem11.setText("keyboardShortcuts");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        help.add(jMenuItem11);

        jMenuItem12.setText("about");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        help.add(jMenuItem12);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(counto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(calmean, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addomean)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(reset))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(atan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(decitooct)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bitooct)))
                        .addGap(18, 18, 18)
                        .addComponent(devia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fact)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(y)
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(sinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bitodec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cosh, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tanh)
                                                .addGap(22, 22, 22)
                                                .addComponent(asin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(acos))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(hextobi)
                                                .addGap(18, 18, 18)
                                                .addComponent(bitohexa)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(answer, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(octodec)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(octtobi))))
                                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(caldeg1)
                                            .addComponent(caldeg2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(parentesesLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(parentesesRight, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(modulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ex, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(pi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(log10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(exp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(hextodeci)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(tohex)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(decitobin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(and, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(plns1))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(equal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(pow, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(eight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(plus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(minus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addComponent(cose)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addGap(60, 60, 60)
                                                                        .addComponent(or, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(13, 13, 13)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(sqr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(mul, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(sine)
                                                        .addGap(65, 65, 65)
                                                        .addComponent(tane))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addComponent(forward, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(div, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(plns)
                                            .addComponent(comma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 152, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {acos, addomean, answer, asin, atan, bitodec, bitohexa, bitooct, calmean, cosh, decitobin, decitooct, devia, exp, fact, hextobi, hextodeci, jButton1, log10, octodec, octtobi, reset, sinh, tanh, tohex});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {and, back, clear, comma, cose, div, eight, equal, ex, five, forward, four, log, minus, modulo, mul, nine, no, one, or, parentesesLeft, parentesesRight, pi, plns, plns1, plus, pow, seven, sine, six, sqr, tane, three, two, zero});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(one)
                            .addComponent(two)
                            .addComponent(three)
                            .addComponent(four)
                            .addComponent(five)
                            .addComponent(six)
                            .addComponent(seven))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eight)
                            .addComponent(nine)
                            .addComponent(zero)
                            .addComponent(plus)
                            .addComponent(minus)
                            .addComponent(mul)
                            .addComponent(div))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(equal)
                            .addComponent(pow)
                            .addComponent(sine)
                            .addComponent(cose)
                            .addComponent(sqr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tane)
                            .addComponent(plns))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clear)
                            .addComponent(back)
                            .addComponent(forward)
                            .addComponent(log)
                            .addComponent(or)
                            .addComponent(no)
                            .addComponent(comma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(parentesesLeft)
                            .addComponent(parentesesRight)
                            .addComponent(modulo)
                            .addComponent(ex)
                            .addComponent(pi)
                            .addComponent(and)
                            .addComponent(plns1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(log10)
                            .addComponent(exp)
                            .addComponent(hextodeci)
                            .addComponent(tohex)
                            .addComponent(decitobin))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(answer)
                            .addComponent(jButton1)
                            .addComponent(bitohexa)
                            .addComponent(hextobi)
                            .addComponent(bitodec))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sinh)
                            .addComponent(cosh)
                            .addComponent(tanh)
                            .addComponent(asin)
                            .addComponent(acos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(decitooct)
                            .addComponent(bitooct)
                            .addComponent(octodec)
                            .addComponent(octtobi)
                            .addComponent(atan))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calmean)
                            .addComponent(addomean)
                            .addComponent(reset)
                            .addComponent(devia)
                            .addComponent(fact))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(counto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(caldeg1)
                                .addGap(8, 8, 8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(caldeg2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(266, 266, 266))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
if(history.isSelected())
                this.setSize(1200, 1400);
            else
                this.setSize(1200, 1200);
        // TODO add your handling code here:
    }//GEN-LAST:event_historyActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
 String temp = inputField.getText();
        if (temp.equals("Error") || temp.equals("cannot divide by 0")) {
            inputField.setText("");
        }
        else if (!temp.isEmpty()) {
            temp = inputField.getText().substring(0, inputField.getText().length() - 1);
            if (temp.length() >= 2) {
                switch (temp.substring(temp.length() - 2)) {
                    case "co":
                    case "si":
                    case "ta":
                        temp = temp.substring(0, temp.length() - 2);
                        break;
                }
            }
            inputField.setText(temp);}
    }//GEN-LAST:event_backActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
    inputField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void orActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orActionPerformed

        no1=Double.parseDouble( inputField.getText( ));
st=or.getText();
inputField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_orActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed

        no1=Double.parseDouble(inputField.getText( ));
 
 
        if(no1==1.0){
           inputField.setText("0.0");
                String historyNewText = historyText.getText();
    historyText.setText(historyNewText +"~"+ no1+"="+"0.0"+"\n");
        }
        else if (no1==0.0){
           inputField.setText("1.0");
                  String historyNewText = historyText.getText();
    historyText.setText(historyNewText +"~"+ no1+"="+"1.0"+"\n");
        }
        else {
             inputField.setText("error");
                   String historyNewText = historyText.getText();
    historyText.setText(historyNewText + "error"+"\n");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_noActionPerformed

    private void andActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_andActionPerformed
        no1=Double.parseDouble( inputField.getText( ));
st=and.getText();
inputField.setText("");
    }//GEN-LAST:event_andActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed

     inputField.selectAll();
            inputField.copy();
            inputField.setCaretPosition(inputField.getText().length());
        // TODO add your handling code here:
    }//GEN-LAST:event_copyActionPerformed

    private void pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteActionPerformed
inputField.paste();
        // TODO add your handling code here:
    }//GEN-LAST:event_pasteActionPerformed

    private void copyHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyHistoryActionPerformed

            historyText.selectAll();
            historyText.copy();
            inputField.setCaretPosition(inputField.getText().length());
        // TODO add your handling code here:
    }//GEN-LAST:event_copyHistoryActionPerformed

    private void clearHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearHistoryActionPerformed
 historyText.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_clearHistoryActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

       String str = "<html>"
                        + "<ul>"
                        + "<li>Press <b>v</b> to add <b>v</b>.</li>"
                        + "<li>Press <b>p</b> to add <b>p</b>.</li>"
                        + "<li>Press <b>c</b> to add <b>cos</b>.</li>"
                        + "<li>Press <b>s</b> to add <b>sin</b>.</li>"
                        + "<li>Press <b>t</b> to add <b>tan</b>.</li>"
                        + "<li>Press <b>=</b> or <b>Enter</b> to get the result</li>"
                        + "<li>Press <b>BackSpace</b> to clear last character entered.</li>"
                        + "<li>Press <b>Delete</b> to clear all characters entered.</li>"
                        + "</ul>"
                        + "<html>";
 
            JOptionPane.showMessageDialog(null, str, "Keyboard Shortcuts", JOptionPane.PLAIN_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

      String str = "<html>"
                        + "<big>Advanced Scientific Calculator</big><br><br>"
                        + "<p>Prepared by <b>Mhamad Harmush- abdelrahman darrage - ahmad manaa - muhamad Hashim</b><br><br>"
                        + "If you have any comments, ideas.. just let know<br><br>"
                        + "email:   abdelrahmanmuhamad2016@gmail.com<br>"
                        + " facebook: ????????? ???? ?????  @<br><br>"
                        + "<u>Note</u><br>"
                        + "I used JDK 8 to compile the source code.<br><br><br>"
                        + "<p><i>from  harmash.com - All Rights Reserved</i></p>"
                        + "<html>";
 
            JOptionPane.showMessageDialog(null, str, "About", JOptionPane.PLAIN_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusActionPerformed
no1=Double.parseDouble( inputField.getText( ));
st=plus.getText();
inputField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_plusActionPerformed

    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed
 no1=Double.parseDouble( inputField.getText( ));
st=minus.getText();
inputField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_minusActionPerformed

    private void mulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mulActionPerformed
 no1=Double.parseDouble( inputField.getText( ));
st=mul.getText();
inputField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_mulActionPerformed

    private void divActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divActionPerformed
 no1=Double.parseDouble( inputField.getText( ));
st=div.getText();
inputField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_divActionPerformed

    private void powActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powActionPerformed
 no1=Double.parseDouble( inputField.getText( ));
st=pow.getText();
inputField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_powActionPerformed

    private void equalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalActionPerformed

            String historyNewText = historyText.getText();
           
  
       

        no2=Double.parseDouble(inputField.getText());
  char type = st.charAt(0);
switch(type){
    case '+':
     total=no1+no2;
    inputField.setText(Double.toString(total));
     historyText.setText(historyNewText + no1+"+"+no2+"="+total+"\n");
break;
     case '-':
total=no1-no2;
    inputField.setText(Double.toString(total));
    historyText.setText(historyNewText + no1+"-"+no2+"="+total+"\n");
break;
      case '*':
    total=no1*no2;
    inputField.setText(Double.toString(total));
    historyText.setText(historyNewText + no1+"*"+no2+"="+total+"\n");
break;
    case '/':
    total=no1/no2;
    inputField.setText(Double.toString(total));
    historyText.setText(historyNewText + no1+"/"+no2+"="+total+"\n");
break;
case 'p':
    total=Math.pow(no1,no2);
    inputField.setText(Double.toString(total)); 
    historyText.setText(historyNewText + no1+"power"+no2+"="+total+"\n");
        break;
    case'|':
        if(no1==0 &&no2==0){
     inputField.setText("0.0");
    historyText.setText(historyNewText + no1+"|"+no2+"="+"0.0"+"\n");
}
else if (no1==0 && no2==1){
     inputField.setText("1.0");
    historyText.setText(historyNewText + no1+"|"+no2+"="+"1.0"+"\n");
}
else if (no1==1 && no2==1){
     inputField.setText("1.0");
    historyText.setText(historyNewText + no1+"|"+no2+"="+"1.0"+"\n");
}
else if (no1==1 && no2==0){
     inputField.setText("1.0");
         
    historyText.setText(historyNewText + no1+"|"+no2+"="+"1.0"+"\n");
}
else{
      inputField.setText("error");
          
    historyText.setText(historyNewText + "error"+"\n");
}
   break;
   case'&':
       if(no1==0 &&no2==0){
     inputField.setText("0.0");
    
    historyText.setText(historyNewText + no1+"|"+no2+"="+"0.0"+"\n");
}
else if (no1==0 && no2==1){
     inputField.setText("0.0");
         
    historyText.setText(historyNewText + no1+"|"+no2+"="+"0.0"+"\n");
}
else if (no1==1 && no2==1){
     inputField.setText("1.0");
        
    historyText.setText(historyNewText + no1+"|"+no2+"="+"1.0"+"\n");
}
else if (no1==1 && no2==0){
     inputField.setText("0.0");
          
    historyText.setText(historyNewText + no1+"|"+no2+"="+"0.0"+"\n");
}
else{
      inputField.setText("error");
      
    historyText.setText(historyNewText + "error"+"\n");
}
       case'%':
            total=no1%no2;
    inputField.setText(Double.toString(total));
    historyText.setText(historyNewText + no1+"%"+no2+"="+total+"\n");
        // T
   
        
        
} 
        // TODO add your handling code here:
    }//GEN-LAST:event_equalActionPerformed

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
String s1= inputField.getText()+"0";
inputField.setText(s1);
        // TODO add your handling code here:
    }//GEN-LAST:event_zeroActionPerformed

    private void oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
String s1= inputField.getText()+"1";
inputField.setText(s1);
        // TODO add your handling code here:
    }//GEN-LAST:event_oneActionPerformed

    private void twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
String s1= inputField.getText()+"2";
inputField.setText(s1);
        // TODO add your handling code here:
    }//GEN-LAST:event_twoActionPerformed

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
String s1= inputField.getText()+"3";
inputField.setText(s1);
    }//GEN-LAST:event_threeActionPerformed

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
String s1= inputField.getText()+"4";
inputField.setText(s1);
        // TODO add your handling code here:
    }//GEN-LAST:event_fourActionPerformed

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
String s1= inputField.getText()+"5";
inputField.setText(s1);
        // TODO add your handling code here:
    }//GEN-LAST:event_fiveActionPerformed

    private void sixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
String s1= inputField.getText()+"6";
inputField.setText(s1);
        // TODO add your handling code here:
    }//GEN-LAST:event_sixActionPerformed

    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
String s1= inputField.getText()+"7";
inputField.setText(s1);
        // TODO add your handling code here:
    }//GEN-LAST:event_sevenActionPerformed

    private void eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
String s1= inputField.getText()+"8";
inputField.setText(s1);
        // TODO add your handling code here:
    }//GEN-LAST:event_eightActionPerformed

    private void nineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineActionPerformed
String s1= inputField.getText()+"9";
inputField.setText(s1);
        // TODO add your handling code here:
    }//GEN-LAST:event_nineActionPerformed

    private void sineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sineActionPerformed
sin_isClicked();
String historyNewText = historyText.getText();
    historyText.setText(historyNewText + inputField.getText()+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_sineActionPerformed

    private void coseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coseActionPerformed
cos_isClicked();
String historyNewText = historyText.getText();
    historyText.setText(historyNewText + inputField.getText()+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_coseActionPerformed

    private void taneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taneActionPerformed
  tan_isClicked();
  String historyNewText = historyText.getText();
    historyText.setText(historyNewText + inputField.getText()+"\n");
    }//GEN-LAST:event_taneActionPerformed

    private void commaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commaActionPerformed
comma_isClicked();
        // TODO add your handling code here:
    }//GEN-LAST:event_commaActionPerformed

    private void parentesesLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parentesesLeftActionPerformed
parentesesLeft_isClicked();
        // TODO add your handling code here:
    }//GEN-LAST:event_parentesesLeftActionPerformed

    private void parentesesRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parentesesRightActionPerformed
  if (inputField.getText().matches(".*[^ns√(]$")) {
            int leftParentesesCounter = 0, rightParentesesCounter = 0;
            for(char c: inputField.getText().toCharArray()) {
                if( c == '(' )
                    leftParentesesCounter++;
                else if( c == ')' )
                    rightParentesesCounter++;
            }
            if (leftParentesesCounter > rightParentesesCounter)
                inputField.setText(inputField.getText() + ")");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_parentesesRightActionPerformed

    private void exActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exActionPerformed
  String historyNewText = historyText.getText();
    total=Math.E;
    inputField.setText(Double.toString(total)); 
    historyText.setText(historyNewText + "ex ="+total+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_exActionPerformed

    private void piActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piActionPerformed
  String historyNewText = historyText.getText();
        inputField.setText(Double.toString(Math.PI)); 
historyText.setText(historyNewText + "PI ="+Math.PI+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_piActionPerformed

    private void inputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFieldActionPerformed

    private void sqrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqrActionPerformed
String historyNewText = historyText.getText();
no1=Double.parseDouble( inputField.getText( ));
          total= Math.sqrt(no1);
            inputField.setText(Double.toString(total)); 
       historyText.setText(historyNewText + "√ "+no1+"="+total+"\n");
// TODO add your handling code here:
    }//GEN-LAST:event_sqrActionPerformed

    private void expActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expActionPerformed
no1=Double.parseDouble( inputField.getText( ));
 String historyNewText = historyText.getText();
    total=Math.exp(no1);
    inputField.setText(Double.toString(total)); 
       historyText.setText(historyNewText + "exp "+no1+"="+total+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_expActionPerformed

    private void log10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log10ActionPerformed
no1=Double.parseDouble( inputField.getText( ));
        String historyNewText = historyText.getText();
        total=Math.log10(no1);
        inputField.setText(Double.toString(total)); 
        historyText.setText(historyNewText + "log "+no1+"="+total+"\n");        // TODO add your handling code here:
    }//GEN-LAST:event_log10ActionPerformed

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
no1=Double.parseDouble( inputField.getText( ));
        String historyNewText = historyText.getText();
        total=Math.log(no1);
        inputField.setText(Double.toString(total)); 
        historyText.setText(historyNewText + "log "+no1+"="+total+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_logActionPerformed

    private void hextodeciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hextodeciActionPerformed

      String no3=inputField.getText(); 
      total=hextodecimal(no3);
  String historyNewText = historyText.getText();
inputField.setText(Double.toString(total)); 
historyText.setText(historyNewText + no3+"in deci="+total+"\n");
// TODO add your handling code here:
    }//GEN-LAST:event_hextodeciActionPerformed

    private void tohexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tohexActionPerformed
no1=Integer.parseInt( inputField.getText( ));
String x= Integer.toHexString((int) no1);
inputField.setText(x);
  String historyNewText = historyText.getText();
  historyText.setText(historyNewText + no1+"in hexa="+x+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_tohexActionPerformed

    private void decitobinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decitobinActionPerformed
no1 = Integer.parseInt(inputField.getText());
String x=Integer.toBinaryString((int) no1);
inputField.setText(x);
  String historyNewText = historyText.getText();
  historyText.setText(historyNewText + no1+"in bi="+x+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_decitobinActionPerformed

    private void bitodecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitodecActionPerformed
String binaryString=inputField.getText();
no1=Integer.parseInt(binaryString,2);
String x=Double.toString(no1);
inputField.setText(x);
 String historyNewText = historyText.getText();
  historyText.setText(historyNewText + no1+"in dec="+x+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_bitodecActionPerformed

    private void hextobiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hextobiActionPerformed
  
      String no3=inputField.getText(); 
      totel=hextodecimal(no3.toUpperCase());
      String x = Integer.toBinaryString((int) totel);
  String historyNewText = historyText.getText();
inputField.setText(x); 
historyText.setText(historyNewText + no3+"\t in binary="+x+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_hextobiActionPerformed

    private void bitohexaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitohexaActionPerformed
    String binaryString=inputField.getText();
no1=Integer.parseInt(binaryString,2);
String x= Integer.toHexString((int) no1);
String y = x.toUpperCase();
inputField.setText(y);
 String historyNewText = historyText.getText();
  historyText.setText(historyNewText + binaryString+"  in hexadecimal="+y+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_bitohexaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Memory = Double.parseDouble(inputField.getText());
inputField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerActionPerformed
inputField.setText(Double.toString(Memory));
        // TODO add your handling code here:
    }//GEN-LAST:event_answerActionPerformed

    private void sinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinhActionPerformed
no1=Double.parseDouble( inputField.getText( ));
double x=Math.toRadians(no1);
double y=Math.sinh(x);
inputField.setText(Double.toString(y));
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "sinh "+no1+" ="+y+"\n");


        // TODO add your handling code here:
    }//GEN-LAST:event_sinhActionPerformed

    private void coshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coshActionPerformed
  no1=Double.parseDouble( inputField.getText( ));
double x=Math.toRadians(no1);
double y=Math.cosh(x);
inputField.setText(Double.toString(y));
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "cosh "+no1+" ="+y+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_coshActionPerformed

    private void tanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanhActionPerformed
no1=Double.parseDouble( inputField.getText( ));
double x=Math.toRadians(no1);
double y=Math.sinh(x);
double z=Math.cosh(x);
double r=y/z;
if(r!=0){
    String f=Double.toString(r);
    inputField.setText("tanh("+no1+") ="+f);
}
else{
JOptionPane.showMessageDialog(null,"infinty");
 
 
    }   
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "tanh "+no1+" ="+y+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_tanhActionPerformed

    private void asinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asinActionPerformed
no1=Double.parseDouble( inputField.getText( ));

double y=Math.asin(no1);
double x=Math.toDegrees(y);

inputField.setText(Double.toString(x));
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "asin "+no1+" ="+x+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_asinActionPerformed

    private void acosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acosActionPerformed
no1=Double.parseDouble( inputField.getText( ));

double y=Math.acos(no1);
double x=Math.toDegrees(y);

inputField.setText(Double.toString(x));
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "acos "+no1+" ="+x+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_acosActionPerformed

    private void atanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atanActionPerformed
no1=Double.parseDouble( inputField.getText( ));

double y=Math.atan(no1);
double x=Math.toDegrees(y);

inputField.setText(Double.toString(x));
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "atan "+no1+" ="+x+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_atanActionPerformed

    private void factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factActionPerformed
int no4=Integer.parseInt( inputField.getText( ));
int totol=factorial(no4);

inputField.setText("="+totol);
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "fact "+no4+" ="+totol+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_factActionPerformed

    private void moduloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduloActionPerformed
no1=Double.parseDouble( inputField.getText( ));
st=modulo.getText();
inputField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_moduloActionPerformed

    private void decitooctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decitooctActionPerformed
 int no6=Integer.parseInt( inputField.getText( ));
        String octalString = Integer.toOctalString(no6);
    inputField.setText(octalString);
 
    /* Method 2: 
     * Writing your own logic: Here we will write
     * our own logic for decimal to octal conversion
     */
 
    // For storing remainder
    int rem;
 
    // For storing result
    String str=""; 
 
    // Digits in Octal number system
    char dig[]={'0','1','2','3','4','5','6','7'};
 
    while(no6>0)
    {
       rem=no6%8; 
       str=dig[rem]+str; 
       no6=no6/8;
    }
   
    String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "Method 1: Decimal to octal: " + octalString+"\n"+"Method 2: Decimal to octal: "+str+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_decitooctActionPerformed

    private void bitooctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitooctActionPerformed
String binaryString=inputField.getText();
int no6=Integer.parseInt(binaryString,2);
 String octalString = Integer.toOctalString(no6);
    inputField.setText(octalString);
    // For storing remainder
    int rem;
 
    // For storing result
    String str=""; 
 
    // Digits in Octal number system
    char dig[]={'0','1','2','3','4','5','6','7'};
 
    while(no6>0)
    {
       rem=no6%8; 
       str=dig[rem]+str; 
       no6=no6/8;
    }
   
    String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "Method 1: Decimal to octal: " + octalString+"\n"+"Method 2: Decimal to octal: "+str+"\n");
      
    }//GEN-LAST:event_bitooctActionPerformed

    private void octodecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_octodecActionPerformed
     int no6=Integer.parseInt( inputField.getText( ));
     int decimal =convertoctaltodecimal(no6);
     String decimalString = Integer.toString(decimal);
     inputField.setText(decimalString);
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "dec of  "+no6+" ="+decimalString+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_octodecActionPerformed

    private void octtobiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_octtobiActionPerformed
 int no6=Integer.parseInt( inputField.getText( ));
      int decimal =convertoctaltodecimal(no6);
      String x=Integer.toBinaryString((int) decimal);
       inputField.setText(x);
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "dec of  "+no6+" ="+x+"\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_octtobiActionPerformed

    private void calmeanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calmeanActionPerformed
double Average;
String Answer;
Average=counter/NumberofMarks;
Answer=String.format("%.1f",Average);
  inputField.setText(Answer);
String historyNewText = historyText.getText();
  historyText.setText(historyNewText + "Average ="+Answer+"\n");
   
  // TODO add your handling code here:
    }//GEN-LAST:event_calmeanActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
int c=JOptionPane.showConfirmDialog(null,"ALL System Down","System Down",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
if(c== JOptionPane.YES_OPTION){
    System.exit(0);
}
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated
DefaultListModel Number= new DefaultListModel();
    private void addomeanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addomeanActionPerformed
      int num1= Integer.parseInt(sum.getText());
      Number.addElement(num1);
      jList1.setModel(Number);
      counter=counter+num1;
     NumberofMarks=NumberofMarks+1;
     int count=jList1.getModel().getSize();
     counto.setText(Integer.toString(count));
     
//add your handling code here:
    }//GEN-LAST:event_addomeanActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
     Number.clear();
     jList1.setModel(Number);
     counter = 0;
  NumberofMarks=0;
        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

    private void deviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deviaActionPerformed
int n=Integer.parseInt(counto.getText());
 double num1=Double.parseDouble(sum.getText());
double Average;
String Answer;
Average=counter/NumberofMarks;
  int count=jList1.getModel().getSize();
 NumberofMarks=0;
double m=0;
double[]input= new double[n];
double sum=0,mean,moon;
for(int i=0;i<count;i++){
    input[i]=num1;
    m=m+input[i];
     NumberofMarks=NumberofMarks+1;
}
mean=m/NumberofMarks;
m=0;
for(int i=0;i<count;i++){
      input[i]=num1;
    m+=(input[i]-mean)*(input[i]-mean);
}
  moon=m/count;
  double deviation=Math.sqrt(moon);
  inputField.setText(Double.toString(deviation));
// TODO add your handling code here:
    }//GEN-LAST:event_deviaActionPerformed

    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dActionPerformed

    private void caldeg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caldeg2ActionPerformed
 double a1=Double.parseDouble( a.getText( ));
double b1=Double.parseDouble( b.getText( ));
double c1=Double.parseDouble( c.getText( ))-Double.parseDouble(d.getText());
double x1=((-1.0*b1)+ Math.sqrt((b1*b1)-(4.0*a1*c1)))/(2.0*a1);
double x2=((-1.0*b1)- Math.sqrt((b1*b1)-(4.0*a1*c1)))/(2.0*a1); 
x.setText(Double.toString(x1));
y.setText(Double.toString(x2));
// TODO add your handling code here:
    }//GEN-LAST:event_caldeg2ActionPerformed

    private void caldeg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caldeg1ActionPerformed
 double b1=Double.parseDouble( b.getText( ));
double c1=Double.parseDouble( c.getText( ))-Double.parseDouble(d.getText());
double y1=(-1*c1)/b1;
x.setText(Double.toString(y1));
// TODO add your handling code here:
    }//GEN-LAST:event_caldeg1ActionPerformed

    private void printHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printHistoryActionPerformed

     try {
         historyText.print();
// TODO add your handling code here:
     } catch (PrinterException ex) {
         Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_printHistoryActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
Image img;
     try {
         img = ImageIO.read(getClass().getResource("calc.png"));
             this.setIconImage(img);

     } catch (IOException ex) {
         Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
     }


        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void plns1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plns1ActionPerformed
  int f = Integer.parseInt(inputField.getText());
  int w=factorial(f);
inputField.setText(Integer.toString(w));
String historyNewText = historyText.getText();
historyText.setText(historyNewText + "fac ="+Integer.toString(w)+"\n");
// TODO add your handling code here:
    }//GEN-LAST:event_plns1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JButton acos;
    private javax.swing.JButton addomean;
    private javax.swing.JButton and;
    private javax.swing.JButton answer;
    private javax.swing.JButton asin;
    private javax.swing.JButton atan;
    private javax.swing.JTextField b;
    private javax.swing.JButton back;
    private javax.swing.JButton bitodec;
    private javax.swing.JButton bitohexa;
    private javax.swing.JButton bitooct;
    private javax.swing.JTextField c;
    private javax.swing.JButton caldeg1;
    private javax.swing.JButton caldeg2;
    private javax.swing.JButton calmean;
    private javax.swing.JButton clear;
    private javax.swing.JMenuItem clearHistory;
    private javax.swing.JButton comma;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem copyHistory;
    private javax.swing.JButton cose;
    private javax.swing.JButton cosh;
    private javax.swing.JTextField counto;
    private javax.swing.JTextField d;
    private javax.swing.JButton decitobin;
    private javax.swing.JButton decitooct;
    private javax.swing.JButton devia;
    private javax.swing.JButton div;
    private javax.swing.JMenu edit;
    private javax.swing.JButton eight;
    private javax.swing.JButton equal;
    private javax.swing.JButton ex;
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton exp;
    private javax.swing.JButton fact;
    private javax.swing.JButton five;
    private javax.swing.JButton forward;
    private javax.swing.JButton four;
    private javax.swing.JMenu help;
    private javax.swing.JButton hextobi;
    private javax.swing.JButton hextodeci;
    private javax.swing.JCheckBoxMenuItem history;
    private javax.swing.JTextArea historyText;
    private javax.swing.JTextField inputField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton log;
    private javax.swing.JButton log10;
    private javax.swing.JButton minus;
    private javax.swing.JButton modulo;
    private javax.swing.JButton mul;
    private javax.swing.JButton nine;
    private javax.swing.JButton no;
    private javax.swing.JButton octodec;
    private javax.swing.JButton octtobi;
    private javax.swing.JButton one;
    private javax.swing.JButton or;
    private javax.swing.JButton parentesesLeft;
    private javax.swing.JButton parentesesRight;
    private javax.swing.JMenuItem paste;
    private javax.swing.JButton pi;
    private javax.swing.JButton plns;
    private javax.swing.JButton plns1;
    private javax.swing.JButton plus;
    private javax.swing.JButton pow;
    private javax.swing.JMenuItem printHistory;
    private javax.swing.JButton reset;
    private javax.swing.JButton seven;
    private javax.swing.JButton sine;
    private javax.swing.JButton sinh;
    private javax.swing.JButton six;
    private javax.swing.JButton sqr;
    private javax.swing.JTextField sum;
    private javax.swing.JButton tane;
    private javax.swing.JButton tanh;
    private javax.swing.JButton three;
    private javax.swing.JButton tohex;
    private javax.swing.JButton two;
    private javax.swing.JMenu view;
    private javax.swing.JTextField x;
    private javax.swing.JTextField y;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}
