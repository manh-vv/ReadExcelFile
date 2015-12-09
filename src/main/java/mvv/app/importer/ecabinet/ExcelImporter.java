package mvv.app.importer.ecabinet;

import mvv.app.importer.AbsImporter;
import mvv.app.importer.ecabinet.bean.BandingStockBean;
import mvv.app.importer.ecabinet.bean.ComponentBean;
import mvv.app.importer.ecabinet.bean.StockBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Manh on 12/9/2015.
 */
public class ExcelImporter extends AbsImporter {

	private static final Logger log = LogManager.getLogger(ExcelImporter.class);

	private Sheet componentSheet;
	private Sheet stockSheet;
	private Sheet bandingStockSheet;

	@Override
	protected boolean readFile(Path path) throws IOException {
		File file = path.toFile();
		String fileName = file.getName().toLowerCase();

		Workbook workbook = null;

		if (fileName.endsWith(".xls")) {
			workbook = new HSSFWorkbook(new FileInputStream(file));
		} else if (fileName.endsWith(".xlsx")) {
			workbook = new XSSFWorkbook(new FileInputStream(file));
		} else {
			log.error("Unrecognized file [{}]", file.getName());
		}

		this.componentSheet = workbook.getSheet("SheetComponentListing");
		this.stockSheet = workbook.getSheet("SheetStockSummary");
		this.bandingStockSheet = workbook.getSheet("BandingStockSummary");

		return true;
	}

	@Override
	protected boolean processData() {
		IfcReadSheet<ComponentBean> componentReader = new ReadSheet<ComponentBean>();
		componentReader.readSheet(componentSheet);

		IfcReadSheet<StockBean> stockReader = new ReadSheet<StockBean>();
		stockReader.readSheet(stockSheet);

		IfcReadSheet<BandingStockBean> bandingStockReader = new ReadSheet<BandingStockBean>();
		stockReader.readSheet(bandingStockSheet);

		return true;
	}
}
