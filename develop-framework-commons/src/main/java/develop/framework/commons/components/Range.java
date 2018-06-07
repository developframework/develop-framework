package develop.framework.commons.components;

import develop.framework.commons.exceptions.RangeException;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qiushui on 2018-06-07.
 * @since 0.3
 */
@Data
public class Range<Y extends Comparable<? super Y>> implements Serializable {

	private String fieldName;

	private Y from;

	private Y to;

	public Range(Y from, Y to) {
		this.from = from;
		this.to = to;

		if(from != null && to != null && from.compareTo(to) > 0 ) {
			throw new RangeException("The \"from\" value must less than or equal to \"to\" value.");
		} else if(from == null && to == null) {
			throw new RangeException("The \"from\" value and \"to\" value can't be all null.");
		}
	}

	public boolean isBetween() {
		return from != null && to != null;
	}

	public boolean isOnlyFrom() {
		return from != null && to == null;
	}

	public boolean isOnlyTo() {
		return from == null && to != null;
	}
}
