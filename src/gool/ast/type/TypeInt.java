package gool.ast.type;

import gool.generator.GoolGeneratorController;

/**
 * This is the basic type Int of the intermediate language.
 */
public final class TypeInt extends PrimitiveType {

	public static final TypeInt INSTANCE = new TypeInt();
	
	private TypeInt(){}

	@Override
	public String callGetCode() {
		return getName();
	}
	
	@Override
	public String getName() {
		return GoolGeneratorController.generator().getCode(this);
	}
}
