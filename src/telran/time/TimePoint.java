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
	    int totalSeconds = this.amount * this.timeUnit.value;
	    return new TimePoint(totalSeconds / unit.value, unit);
	}

	public TimePoint with(TimePointAdjuster adjuster) {
	    return adjuster.adjust(this);
	}

	@Override
	public int compareTo(TimePoint other) {
	    int secondsThis = this.getAmount() * this.getTimeUnit().getValue();
	    int secondsOther = other.getAmount() * other.getTimeUnit().getValue();
	    return Integer.compare(secondsThis, secondsOther);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    TimePoint other = (TimePoint) obj;
	    return this.compareTo(other) == 0;
	}	
}