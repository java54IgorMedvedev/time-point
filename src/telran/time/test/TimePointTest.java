package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import telran.time.*;

class TimePointTest {

	@Test
	void testBetween() {
		TimePoint point1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint point2 = new TimePoint(3600 * 20, TimeUnit.SECOND);
		TimePoint point3 = TimeUnit.MINUTE.between(point1, point2);
		assertEquals(600, point3.getAmount());
		TimePoint point4 = TimeUnit.SECOND.between(point1, point2);
		assertEquals(36000, point4.getAmount());
		TimePoint point5 = TimeUnit.HOUR.between(point1, point2);
		assertEquals(10, point5.getAmount());
	}
	@Test
	void convertTest() {
		TimePoint timePoint = new TimePoint(10, TimeUnit.HOUR);
		TimePoint point1Actual = timePoint.convert(TimeUnit.SECOND);
		assertEquals(36000, point1Actual.getAmount());
	}
	@Test
	void plusAdjusterTest() {
		TimePoint timePoint1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint timePoint2 = new TimePoint(60, TimeUnit.MINUTE);
		TimePoint actual = timePoint2.with(new PlusAdjuster(timePoint1));
		assertEquals(660, actual.getAmount());
		assertEquals(TimeUnit.MINUTE, actual.getTimeUnit());
	}
	@Test
	void timePointEqualsTest() {
	    TimePoint timePoint1 = new TimePoint(1, TimeUnit.HOUR);
	    TimePoint timePoint2 = new TimePoint(60, TimeUnit.MINUTE);
	    TimePoint timePoint3 = new TimePoint(3600, TimeUnit.SECOND);
	    assertTrue(timePoint1.equals(timePoint2));
	    assertTrue(timePoint2.equals(timePoint3));
	    assertTrue(timePoint1.equals(timePoint3));
	    TimePoint timePoint4 = new TimePoint(2, TimeUnit.HOUR);
	    assertFalse(timePoint1.equals(timePoint4));
	}

	@Test
	void timePointCompareToTest() {
	    TimePoint timePoint1 = new TimePoint(1, TimeUnit.HOUR);
	    TimePoint timePoint2 = new TimePoint(30, TimeUnit.MINUTE); 
	    TimePoint timePoint3 = new TimePoint(90, TimeUnit.MINUTE); 
	    assertTrue(timePoint1.compareTo(timePoint2) > 0);
	    assertTrue(timePoint1.compareTo(timePoint3) < 0);
	    assertEquals(0, timePoint1.compareTo(new TimePoint(60, TimeUnit.MINUTE)));
	}

	@Test
	void futureProximityAdjusterTest() {
	    TimePoint point = new TimePoint(14, TimeUnit.HOUR);
	    TimePoint[] timePoints = {
	        new TimePoint(11, TimeUnit.HOUR),
	        new TimePoint(12, TimeUnit.HOUR),
	        new TimePoint(13, TimeUnit.HOUR),
	        new TimePoint(17, TimeUnit.HOUR),
	        new TimePoint(20, TimeUnit.HOUR)
	    };
	    FutureProximityAdjuster adjuster = new FutureProximityAdjuster(timePoints);
	    TimePoint closestFuture = point.with(adjuster);
	    assertEquals(17, closestFuture.getAmount()); 
	}

}