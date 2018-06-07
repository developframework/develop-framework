package develop.framework.commons.components;

import develop.framework.commons.exceptions.RangeException;
import develop.framework.commons.utils.Sugar;
import lombok.NonNull;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 日期时间范围
 *
 * @author qiushui on 2018-06-07.
 * @since 0.3
 */
public class DateRange extends Range<Date> {

	public static final DateRange parse(@NonNull String fromDateStr, @NonNull String toDateStr, @NonNull String pattern) {
		Date from;
		try {
			from = Sugar.useElseDefault(DateUtils.parseDate(fromDateStr, pattern), null);
		} catch (ParseException e) {
			throw new RangeException("\"%s\" invalid.", fromDateStr);
		}
		Date to;
		try {
			to = Sugar.useElseDefault(DateUtils.parseDate(toDateStr, pattern), null);
		} catch (ParseException e) {
			throw new RangeException("\"%s\" invalid.", fromDateStr);
		}
		return new DateRange(from, to);
	}

	public DateRange(Date from, Date to) {
		super(from, to);
	}
}
