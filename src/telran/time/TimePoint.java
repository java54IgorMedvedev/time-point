package telran.time;

public class TimePoint implements Comparable<TimePoint>{
	int amount;
	TimeUnit timeUnit;
	public TimePoint(int amount, TimeUnit timeUnit) {
		this.amount = amount;
		this.timeUnit = timeUnit;
	}
	public int getAmount() {
		return amount;
	}
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
	public TimePoint convert(TimeUnit unit) {
		
		//returns new TimePoint with a given TimeUnit
		return new TimePoint(amount * timeUnit.getValue() / unit.getValue(), unit);
	}
	public TimePoint with(TimePointAdjuster adjuster) {
		return adjuster.adjust(this);
	}
	@Override
	public int compareTo(TimePoint o) {
		
		return Integer.compare(amount, o.convert(timeUnit).amount);
	}
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj != null && obj instanceof TimePoint) {
			result = compareTo((TimePoint)obj) == 0;
		}
		return result;
	}
	
	
}