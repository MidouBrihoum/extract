package xml_pack;

import java.util.List;

public class Operation {
	
	String opname;
	 List<String> input;
	 List<String> output;
	 List<String> precond;
	 List<String> postcond;
	 
	
	 public Operation(String opname, List<String> input, List<String> output,List<String> precond, List<String> postcond) {
		super();
		
		this.opname = opname;
        this.input = input;
		this.output = output;
		this.postcond = postcond;
		this.precond = precond;
	}
	
	 
	
}
