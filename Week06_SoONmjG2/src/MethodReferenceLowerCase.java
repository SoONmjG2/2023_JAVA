import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferenceLowerCase {

	public static void main(String[] args) {
		List<String> listOfNames=Arrays.asList(new String[]
				{"Apple","Banana","Cherry"});
		List<String> lowerCaseNames=listOfNames.stream()
				.map(String::toLowerCase)
				.collect(Collectors.toList()); 
		System.out.println(lowerCaseNames);

	}

}
