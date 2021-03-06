package gool.ast.constructs;

import gool.generator.GoolGeneratorController;

public class For extends While {

	private Statement initializer;
	private Statement updater;

	public For(Statement initializer, Expression condition, Statement updater, Statement statements){
		super(condition, statements);
		this.initializer = initializer;
		this.updater = updater;
	}
	
	public Statement getInitializer() {
		return initializer;
	}
	
	public Statement getUpdater() {
		return updater;
	}
	
	@Override
	public String callGetCode() {
		return GoolGeneratorController.generator().getCode(this);
	}

}
