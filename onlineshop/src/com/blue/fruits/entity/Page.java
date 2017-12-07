package com.blue.fruits.entity;

public class Page {
	
	private int totalcount;//全部条数
	private int pagecount=6;//每页显示的条数
	private int totalpage;//总页数
	private int dpage;//当前页数
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage() {
		if(totalcount%pagecount==0) {
			this.totalpage = totalpage;//整除
		}else {
			//不能整除，创建新的一页
			this.totalpage = totalcount/pagecount+1;
		}
	}
	public int getDpage() {
		return dpage;
	}
	public void setDpage(int dpage) {
		this.dpage = dpage;
	}

	
//	private int pageSise;  // 每页显示记录的条数
//	private int currentPage; //当前第几页
//	private  int totalPage; //总页数
//	private int totalRecord; //总记录条数
//	private List<T> datalist; //数据集合
//	public Page(int PageNum,int pageSize,List<T> sourceList) {
//		if(sourceList == null) {
//			return;
//		}
//		//总计录数
//		this.totalRecord = sourceList.size();
//		//每页显示多少条记录
//		this.pageSise = pageSize;
//		//获取总页数
//		this.totalPage = this.totalRecord/this.pageSise;
//		if(this.totalRecord % this.totalPage != 0) {
//			this.totalPage = this.totalPage+1;
//		}
//		//获取当前第几页数据
//		if(this.totalPage<PageNum) {
//			this.currentPage = this.totalPage;
//		}else {
//			this.currentPage = PageNum;
//		}
//		
//		//起始索引
//		int fromIndex = this.pageSise * (this.currentPage-1);
//		//结束索引
//		int toIndex ;
//		if(this.pageSise*this.currentPage>this.totalRecord) {
//			toIndex = this.totalRecord;
//		}else {
//			toIndex = this.pageSise*this.currentPage;
//		}
//		this.datalist=sourceList.subList(fromIndex, toIndex);
//	}
//	public Page() {}
//	public int getPageSise() {
//		return pageSise;
//	}
//	public void setPageSise(int pageSise) {
//		this.pageSise = pageSise;
//	}
//	public int getCurrentPage() {
//		return currentPage;
//	}
//	public void setCurrentPage(int currentPage) {
//		this.currentPage = currentPage;
//	}
//	public int getTotalPage() {
//		return totalPage;
//	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
//	public int getTotalRecord() {
//		return totalRecord;
//	}
//	public void setTotalRecord(int totalRecord) {
//		this.totalRecord = totalRecord;
//	}
//	public List<T> getDatalist() {
//		return datalist;
//	}
//	public void setDatalist(List<T> datalist) {
//		this.datalist = datalist;
//	}
	

}
