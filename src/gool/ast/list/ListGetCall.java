package gool.ast.list;

import gool.ast.constructs.Expression;
import gool.ast.constructs.ListMethCall;
import gool.ast.type.TypeVoid;
import gool.generator.GoolGeneratorController;

public class ListGetCall extends ListMethCall {

	public ListGetCall(Expression target) {
		super(TypeVoid.INSTANCE, target);
	}
	
	@Override
	public String callGetCode() {
		return GoolGeneratorController.generator().getCode(this);		
	}

}
