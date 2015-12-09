package mvv.app.importer.ecabinet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Manh on 12/9/2015.
 */
public class ReadSheet<T extends AbsBean> implements IfcReadSheet<T> {
	private static final Logger log = LogManager.getLogger(ReadSheet.class);

	protected List<T> beanList;
	private Class<T> persistentClass;

	public boolean readSheet(Sheet sheet) {
		if (sheet == null) {
			log.error("sheet is null");
			return false;
		}

		beanList = new LinkedList<T>();

		int rowIdx = 0;
		for (Row row : sheet) {

			if (rowIdx == 0) {
				continue;
			}

			// Begin: fill value to bean
			T bean = createBean();
			int idx = 0;
			for (Cell cell : row) {
				bean.readCell(idx++, cell.getStringCellValue());
			}

			beanList.add(bean);
			// End  : fill value to bean

			rowIdx++;
		}

		return true;
	}

	private T createBean() {
		if (persistentClass == null) {
			persistentClass = (Class<T>)
					((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}

		try {
			return persistentClass.newInstance();
		} catch (InstantiationException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

	public List<T> getBeanList() {
		return beanList;
	}
}
