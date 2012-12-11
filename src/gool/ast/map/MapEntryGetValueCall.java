package gool.ast.map;

import gool.ast.constructs.Expression;
import gool.ast.constructs.MapEntryMethCall;
import gool.ast.type.TypeVoid;
import gool.generator.GoolGeneratorController;

public class MapEntryGetValueCall extends MapEntryMethCall {

	public MapEntryGetValueCall(Expression target) {
		super(TypeVoid.INSTANCE, target);
	}
	
	@Override
	public String callGetCode() {
		return GoolGeneratorController.generator().getCode(this);		
	}

}
