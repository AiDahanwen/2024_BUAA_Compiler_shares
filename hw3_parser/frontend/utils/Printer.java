package frontend.utils;

import frontend.AST.SyntaxType;
import frontend.lexer.Token;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Printer {
    private static HashMap<Integer, String> errorMsg = new HashMap<>();
    private static boolean isOn = true;

    public static void printToken(Token token) {
        if (!isOn) {
            return;
        }
        String outputPath = "parser.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, true))) {
            writer.write(token.getType().toString() + " " + token.getValue() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printSyntaxType(SyntaxType type) {
        if (!isOn) {
            return;
        }
        if (type == SyntaxType.BlockItem || type == SyntaxType.Decl) {
            return;
        }
        String outputPath = "parser.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, true))) {
            writer.write("<" + type.toString() + ">\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addError(String type, int lineNum) {
        if (isOn) {
            errorMsg.put(lineNum, type);
        }
    }

    public static void printError() {
        if (errorMsg.isEmpty()) {
            return;
        }
        //先对错误信息根据行号进行排序
        Object[] lineNumbers = errorMsg.keySet().toArray();
        Arrays.sort(lineNumbers);
        String outputPath = "error.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, true))) {
            for (Object lineNum : lineNumbers) {
                writer.write(lineNum + " " + errorMsg.get((Integer) lineNum) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setOn() {
        isOn = true;
    }

    public static void setOff() {
        isOn = false;
    }
}