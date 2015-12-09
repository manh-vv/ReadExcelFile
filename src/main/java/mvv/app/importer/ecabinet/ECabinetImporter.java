package mvv.app.importer.ecabinet;

import mvv.app.importer.ExcelImporter;
import mvv.app.importer.ecabinet.bean.BandingStockBean;
import mvv.app.importer.ecabinet.bean.ComponentBean;
import mvv.app.importer.ecabinet.bean.StockBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Created by Manh on 12/9/2015.
 */
public class ECabinetImporter extends ExcelImporter {

	private static final Logger log = LogManager.getLogger(ECabinetImporter.class);

	private Sheet componentSheet;
	private Sheet stockSheet;
	private Sheet bandingStockSheet;

	@Override
	protected boolean processData() {
		Sheet componentSheet = workbook.getSheet("SheetComponentListing");
		Sheet stockSheet = workbook.getSheet("SheetStockSummary");
		Sheet bandingStockSheet = workbook.getSheet("BandingStockSummary");

		IfcSheetReader<ComponentBean> componentReader = new SheetReader<ComponentBean>();
		componentReader.readSheet(componentSheet);

		IfcSheetReader<StockBean> stockReader = new SheetReader<StockBean>();
		stockReader.readSheet(stockSheet);

		IfcSheetReader<BandingStockBean> bandingStockReader = new SheetReader<BandingStockBean>();
		bandingStockReader.readSheet(bandingStockSheet);

		return true;
	}
}
