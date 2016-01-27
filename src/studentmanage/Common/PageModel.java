package studentmanage.Common;

public class PageModel {

	/**
	 * @author Administrator ��ǰҳ��* /
	 */
	private int _curPageIndex = 1;

	/**
	 * @author Administrator ��ҳ��* /
	 */
	private int _toTal = 0;

	/**
	 * ÿҳ��С
	 */
	private int _pageSize = 10;

	/**
	 * ����
	 */
	private String _url = null;

	public PageModel(int pageIndex, int total, String url, int pageSize) {
		this._curPageIndex = pageIndex;
		this._toTal = total;
		this._url = url;
		this._pageSize = pageSize;
	}

	public String GetPager() {
		int totalPage = 0; // ��ȡ���ܵķ�ҳ��
		if (_toTal % _pageSize == 0)
			totalPage = _toTal / _pageSize;
		else
			totalPage = (_toTal / _pageSize) + 1;

		String strPager = "<ul class=\"pagination\">";

		if (_curPageIndex == 1)
			strPager += "<li class='disabled'><a href='javascript:void(0);'>��һҳ</a></li>";
		else
			strPager += "<li><a href='" + this._url + "?p=" + (_curPageIndex - 1) + "'>��һҳ</a></li>";

		if (totalPage <= 10) {
			// С��10ҳ����ʾ����
			for (int i = 1; i <= totalPage; i++) {
				if (_curPageIndex == i) {
					strPager += "<li class='active'><a href='" + this._url + "?p=" + i + "'>" + i + "</a></li>";
				} else
					strPager += "<li><a href='" + this._url + "?p=" + i + "'>" + i + "</a></li>";
			}
		} else {
			 
			// ���ҳ�����10ҳ
			for (int i = _curPageIndex - 5; i <= _curPageIndex + 5; i++) {
				if (i <= totalPage&&i>0) {
					if (_curPageIndex == i) {
						strPager += "<li class='active'><a href='" + this._url + "?p=" + i + "'>" + i + "</a></li>";
					} else
						strPager += "<li><a href='" + this._url + "?p=" + i + "'>" + i + "</a></li>";
				}
			}
		}

		if (_curPageIndex == totalPage)
			strPager += "<li class='disabled'><a href='javascript:void(0);'>��һҳ</a></li>";
		else
			strPager += "<li><a href='" + this._url + "?p=" + (_curPageIndex + 1) + "'>��һҳ</a></li>";

		strPager += "</ul>";
		return strPager;
	}
}
