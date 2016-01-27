package studentmanage.Common;

public class PageModel {

	/**
	 * @author Administrator 当前页数* /
	 */
	private int _curPageIndex = 1;

	/**
	 * @author Administrator 总页数* /
	 */
	private int _toTal = 0;

	/**
	 * 每页大小
	 */
	private int _pageSize = 10;

	/**
	 * 参数
	 */
	private String _url = null;

	public PageModel(int pageIndex, int total, String url, int pageSize) {
		this._curPageIndex = pageIndex;
		this._toTal = total;
		this._url = url;
		this._pageSize = pageSize;
	}

	public String GetPager() {
		int totalPage = 0; // 获取了总的分页数
		if (_toTal % _pageSize == 0)
			totalPage = _toTal / _pageSize;
		else
			totalPage = (_toTal / _pageSize) + 1;

		String strPager = "<ul class=\"pagination\">";

		if (_curPageIndex == 1)
			strPager += "<li class='disabled'><a href='javascript:void(0);'>上一页</a></li>";
		else
			strPager += "<li><a href='" + this._url + "?p=" + (_curPageIndex - 1) + "'>上一页</a></li>";

		if (totalPage <= 10) {
			// 小于10页都显示出来
			for (int i = 1; i <= totalPage; i++) {
				if (_curPageIndex == i) {
					strPager += "<li class='active'><a href='" + this._url + "?p=" + i + "'>" + i + "</a></li>";
				} else
					strPager += "<li><a href='" + this._url + "?p=" + i + "'>" + i + "</a></li>";
			}
		} else {
			 
			// 如果页面大于10页
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
			strPager += "<li class='disabled'><a href='javascript:void(0);'>下一页</a></li>";
		else
			strPager += "<li><a href='" + this._url + "?p=" + (_curPageIndex + 1) + "'>下一页</a></li>";

		strPager += "</ul>";
		return strPager;
	}
}
