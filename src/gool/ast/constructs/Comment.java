package gool.ast.constructs;

import gool.ast.type.TypeNone;
import gool.generator.GoolGeneratorController;


/**
 * This class captures all the expressions of the intermediate language
 * which we have not bothered to represent in the Abstract Syntax Tree.
 * Its code will compile in the target language just as it is.
 * It is an OOTExpr.
 * @param T is the type of this expression, if known at compile time, otherwise put OOTType. 
 * That way java generics grant us some level of type checking of the generated code at compiler design time.
 * Sometimes we will not be able to use this though, because we will not know T at compiler design time. 
 */
public class Comment extends Expression {

	/**
	 * The constant value.
	 */
	private String value;
	/**
	 * The type of the expression.
	 */

	/**
	 * The type of the return value is T
	 * @param type
	 * @param code 
	 */
	public Comment(String code){
		super(TypeNone.INSTANCE);
		this.value=code;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String callGetCode() {
		return GoolGeneratorController.generator().getCode(this);
	}
	
}
