package xml_pack;

import java.util.List;

public class Operation {
	
	String opname;
	 List<Part> input;
	 List<Part> output;
	 List<Part> precond;
	 List<Part> postcond;
	 
	
	 public Operation(String opname, List<Part> input, List<Part> output,List<Part> precond, List<Part> postcond) {
		super();
		
		this.opname = opname;
        this.input = input;
		this.output = output;
		this.precond = precond;
		this.postcond = postcond;
	}
	
	 
	
}
