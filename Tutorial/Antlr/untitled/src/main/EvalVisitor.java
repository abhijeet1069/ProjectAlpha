package main;

import gen.ExpressionBaseVisitor;
import gen.ExpressionParser;

public class EvalVisitor extends ExpressionBaseVisitor<Integer> {

    @Override
    public Integer visitParens(ExpressionParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    /** expr op=(MUL| DIV) expr */
    @Override
    public Integer visitMulDiv(ExpressionParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == ExpressionParser.MUL ) return left * right;
        return left / right;
    }

    /** expr op=(ADD| SUB) expr */
    @Override
    public Integer visitAddSub(ExpressionParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == ExpressionParser.ADD ) return left + right;
        return left - right;
    }

    /** INT */
    @Override
    public Integer visitInt(ExpressionParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }
}

