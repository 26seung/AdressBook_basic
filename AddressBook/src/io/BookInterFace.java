package io;

import java.util.List;

public interface BookInterFace {

	public List<BookData>getList();
	public List<BookData>insertFile();
	public List<BookData>addData();
	public List<BookData>delData();
	public List<BookData>searchData();
	public void end();
}
