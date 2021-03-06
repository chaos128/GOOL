package gool.ast.type;

import gool.generator.GoolGeneratorController;

/**
 * Represents a generic object in the target language.
 */
public final class TypeObject extends ReferenceType {

	/**
	 * A static instance to avoid the creation of new objects.
	 */
	public static final TypeObject INSTANCE = new TypeObject();
	
	private TypeObject(){}

	@Override
	public String callGetCode() {
		return getName();
	}
	
	@Override
	public String getName() {
		return GoolGeneratorController.generator().getCode(this);
	}

}
