package main;

import gen.ExpressionLexer;
import gen.ExpressionParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) {
        String expression = "4*2";
        CharStream charStream = CharStreams.fromString(expression);
        ExpressionLexer lexer = new ExpressionLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        EvalVisitor visitor = new EvalVisitor();
        Integer value = visitor.visit(parser.expr());
        System.out.println(value);
    }
}
