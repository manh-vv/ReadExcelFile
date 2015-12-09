package mvv.app.importer.cellparser;

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by Manh on 12/9/2015.
 */
public abstract class AbsCellProcessor<T> implements CellProcessor<T> {

	private T defaultValue;

	protected AbsCellProcessor(T defaultValue) {
		this.defaultValue = defaultValue;
	}

	public T parseCellData(String str) {
		if (str == null) {
			return defaultValue;
		}

		str = str.trim();

		if (str.length() < 1) {
			return defaultValue;
		}

		return parse(str);
	}

	protected abstract T parse(String str);
}
