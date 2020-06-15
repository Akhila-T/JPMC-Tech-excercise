package UsingBinarySearch;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SortedRotatedArrayTest {

	static SortedRotatedArray sar;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sar= new SortedRotatedArray();
	}

	@Test
	void shouldReturnIndexWhenGivenMultipleNumbersAsInput() {
		int[] nums= new int[] {7,9,11,0,3,5,6};
		int[] targets =new int[] {3,6,11,13};
		
		int[] expectedResult =new int[] {1,3,6,-1};
		int[] actualResult=sar.getOriginalIndices(nums, targets);
		
		assertArrayEquals(expectedResult, actualResult);
	}

	
	@Test
	void shouldReturnIndexWhenGivenTwoNumbersAsInput() {
		int[] nums= new int[] {3,5};
		int[] targets =new int[] {5};
		
		int[] expectedResult =new int[] {1};
		int[] actualResult=sar.getOriginalIndices(nums, targets);
		
		assertArrayEquals(expectedResult, actualResult);
	}
	
	@Test
	void shouldReturnIndexWhenGivenNegativeNumbersAsInput() {
		int[] nums= new int[] {1,5,7,9,-11,-9,-5,-1};
		int[] targets =new int[] {-11,-9,-5,-1,1,5,7,9};
		
		int[] expectedResult =new int[] {0,1,2,3,4,5,6,7};
		int[] actualResult=sar.getOriginalIndices(nums, targets);
		
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	void shouldReturnIndexWhenGivenOneNumberAndMatchingTarget() {
		int[] nums= new int[] {78};
		int[] targets =new int[] {85,78};
		
		int[] expectedResult =new int[] {-1,0};
		int[] actualResult=sar.getOriginalIndices(nums, targets);
		
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	void shouldnotReturnIndexWhenGivenNumberDoesNotMatchTarget() {
		int[] nums= new int[] {56};
		int[] targets =new int[] {86};
		
		int[] expectedResult =new int[] {-1};
		int[] actualResult=sar.getOriginalIndices(nums, targets);
		
		assertArrayEquals(expectedResult, actualResult);
	}
	
	@Test
	void shouldReturnMatchingFirstIndexWhenGivenTwoNumbers() {
		int[] nums= new int[] {1,3};
		int[] targets =new int[] {1};
		
		int[] expectedResult =new int[] {0};
		int[] actualResult=sar.getOriginalIndices(nums, targets);
		
		assertArrayEquals(expectedResult, actualResult);
	}
}


