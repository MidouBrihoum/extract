package xml_pack;

import java.io.File;

public class OpandKey {

GetOperation Operations;
GetKeyword Keywords;


public OpandKey(GetOperation operations, GetKeyword keywords) {
	super();
	File ibc = new File("IBC.xml");
	Operations = operations;
	Keywords = keywords;
}
}
