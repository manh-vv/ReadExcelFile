package mvv.app.importer.cellparser;

/**
 * Created by Manh on 12/9/2015.
 */
public interface CellProcessor<T> {
	T parseCellData(String str);
}
