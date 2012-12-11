package gool.ast.system;

import gool.ast.constructs.GoolCall;
import gool.ast.type.TypeVoid;
import gool.generator.GoolGeneratorController;

public class SystemOutPrintCall extends GoolCall {

	public SystemOutPrintCall() {
		super(TypeVoid.INSTANCE);
	}
	
	@Override
	public String callGetCode() {
		return GoolGeneratorController.generator().getCode(this);		
	}

}
