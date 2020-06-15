package UsingRotationMethodAndBinarySearch;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SortedRotatedArray_RotationTest {

	static SortedRotatedArray_Rotation sar;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sar= new SortedRotatedArray_Rotation();
	}

	@Test
	void shouldReturnIndexWhenGivenMultipleNumbersAsInput() {
		
		ArrayList<Integer> nums= new ArrayList<Integer>() {{  //7,9,11,0,3,5,6
			add(7);add(9);add(11);add(0);add(3);add(5);add(6);  }}; 
			
		ArrayList<Integer> targets =new ArrayList<Integer>() {{  //3,6,11,13
			add(3);add(6);add(11);add(13); }};
			
		ArrayList<Integer> expectedResult =new ArrayList<Integer>() {{ //1,3,6,-1
			add(1);add(3);add(6);add(-1); }};
				
		ArrayList<Integer> actualResult= sar.getResults(nums, targets);
	
		assertEquals(expectedResult, actualResult);
	}


	
	@Test
	void shouldReturnIndexWhenGivenTwoNumbersAsInput() {
		
		ArrayList<Integer> nums= new ArrayList<Integer>() {{  //3,5
			add(3);add(5);  }}; 
			
		ArrayList<Integer> targets =new ArrayList<Integer>() {{  //5
			add(5); }};
			
		ArrayList<Integer> expectedResult =new ArrayList<Integer>() {{ //1
			add(1); }};
				
		ArrayList<Integer> actualResult= sar.getResults(nums, targets);
	
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void shouldReturnIndexWhenGivenNegativeNumbersAsInput() {

		ArrayList<Integer> nums= new ArrayList<Integer>() {{  //1,5,7,9,-11,-9,-5,-1
			add(1);add(5);add(7);add(9);add(-11);add(-9);add(-5);add(-1);  }}; 
			
		ArrayList<Integer> targets =new ArrayList<Integer>() {{  //-11,-9,-5,-1,1,5,7,9
			add(-11);add(-9);add(-5);add(-1);add(1);add(5);add(7);add(9); }};
			
		ArrayList<Integer> expectedResult =new ArrayList<Integer>() {{ //0,1,2,3,4,5,6,7
			add(0);add(1);add(2);add(3);add(4);add(5);add(6);add(7); }};
				
		ArrayList<Integer> actualResult= sar.getResults(nums, targets);
	
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void shouldReturnIndexWhenGivenOneNumberAndMatchingTarget() {
		ArrayList<Integer> nums= new ArrayList<Integer>() {{  //78
			add(78); }}; 
			
		ArrayList<Integer> targets =new ArrayList<Integer>() {{  //85,78
			add(85);add(78); }};
			
		ArrayList<Integer> expectedResult =new ArrayList<Integer>() {{ //-1,0
			add(-1);add(0); }};
				
		ArrayList<Integer> actualResult= sar.getResults(nums, targets);
	
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void shouldnotReturnIndexWhenGivenNumberDoesNotMatchTarget() {
		ArrayList<Integer> nums= new ArrayList<Integer>() {{  //78
			add(78); }}; 
			
		ArrayList<Integer> targets =new ArrayList<Integer>() {{  //65
			add(65); }};
			
		ArrayList<Integer> expectedResult =new ArrayList<Integer>() {{ //-1
			add(-1); }};
				
		ArrayList<Integer> actualResult= sar.getResults(nums, targets);
	
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void shouldReturnIndexWhenGivenTwoNumbersAndMatchingFirstNumber() {
		ArrayList<Integer> nums= new ArrayList<Integer>() {{  //1,3
			add(1);add(3); }}; 
			
		ArrayList<Integer> targets =new ArrayList<Integer>() {{  //1
			add(1); }};
			
		ArrayList<Integer> expectedResult =new ArrayList<Integer>() {{ //1
			add(0); }};
				
		ArrayList<Integer> actualResult= sar.getResults(nums, targets);
	
		assertEquals(expectedResult, actualResult);
	}
	
	
}


