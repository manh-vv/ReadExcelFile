package mvv.app.importer.ecabinet;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * Created by Manh on 12/9/2015.
 */
public interface IfcSheetReader<T extends AbsBean> {
	boolean readSheet(Sheet sheet);
	List<T> getBeanList();
}
