package gen;// Generated from /Users/satyam/Personal/ProjectAlpha/Tutorial/Antlr/untitled/src/Expression.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ExpressionParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ExpressionParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ExpressionParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ExpressionParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ExpressionParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ExpressionParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(ExpressionParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(ExpressionParser.IntContext ctx);
}