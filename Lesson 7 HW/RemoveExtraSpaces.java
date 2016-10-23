package les7StringRegularExpressions;

public class RemoveExtraSpaces {
	public String removeSpace(String inComeString)
	{String outComeString = inComeString.replaceAll("\\s+", " ");
		return outComeString;
	}
}
