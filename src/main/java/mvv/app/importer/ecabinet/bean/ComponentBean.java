package mvv.app.importer.ecabinet.bean;

import mvv.app.importer.cellparser.CellProcessor;
import mvv.app.importer.cellparser.IntegerCellProcessor;
import mvv.app.importer.cellparser.LengthCellProcessor;
import mvv.app.importer.cellparser.StringCellProcessor;
import mvv.app.importer.ecabinet.AbsBean;

/**
 * Created by Manh on 12/9/2015.
 */
public class ComponentBean extends AbsBean {

	private int qty;
	private String component;
	private String material;
	private double height; /* mm */
	private double width; /* mm */
	private String edgeBanding;
	private String insetCarvings;
	private String name;

	public void readCell(int idx, String stringCellValue) {

		switch (idx) {
			case 0:
				setQty(IntegerCellProcessor.getInstance().parseCellData(stringCellValue));
				break;
			case 1:
				setComponent(stringCellValue);
				break;
			case 2:
				setMaterial(stringCellValue);
				break;
			case 3:
				setHeight(LengthCellProcessor.getInstance().parseCellData(stringCellValue));
				break;
			case 4:
				setWidth(LengthCellProcessor.getInstance().parseCellData(stringCellValue));
				break;
			case 5:
				setEdgeBanding(stringCellValue);
				break;
			case 6:
				setInsetCarvings(stringCellValue);
				break;
			case 7:
				setName(stringCellValue);
				break;
		}
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public String getEdgeBanding() {
		return edgeBanding;
	}

	public void setEdgeBanding(String edgeBanding) {
		this.edgeBanding = edgeBanding;
	}

	public String getInsetCarvings() {
		return insetCarvings;
	}

	public void setInsetCarvings(String insetCarvings) {
		this.insetCarvings = insetCarvings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
