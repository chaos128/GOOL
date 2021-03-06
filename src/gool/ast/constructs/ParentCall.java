package gool.ast.constructs;

import gool.ast.type.IType;
import gool.generator.GoolGeneratorController;

public class ParentCall extends InitCall {

	private ParentCall(IType type, Expression target) {
		super(type, target);
	}

	public ParentCall(IType type) {
		super(type, null);
	}

	@Override
	public String callGetCode() {
		return GoolGeneratorController.generator().getCode(this);		
	}

}
