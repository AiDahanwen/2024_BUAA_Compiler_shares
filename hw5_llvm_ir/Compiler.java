import frontend.AST.CompUnit;
import frontend.lexer.TokenLexer;
import frontend.parser.Parser;
import llvm_ir.IRBuilder;
import utils.Printer;
import llvm_ir.Module;

public class Compiler {
    public static void main(String[] args) {
        //词法分析
        TokenLexer lexer = new TokenLexer();
        lexer.paresToken(); //此时将文件内容解析为Token
        //语法分析
        Parser parser = new Parser(lexer.getTokenList());
        CompUnit compUnit = (CompUnit) parser.parseCompUnit(); //此时将Token解析为AST
        //进行所有错误类型的检查,包含符号表的构建
        compUnit.checkError();
        //打印错误信息
        Printer.printError();
        //生成中间代码LLVM IR
        if (Printer.noError()) {
            IRBuilder.mode = IRBuilder.AUTO_INSERT_MODE;
            compUnit.genIR();
            Module module = IRBuilder.getInstance().getModule();
            Printer.printLLVM(module);
        }
        //打印信息

    }
}