package com.blue.fruits.entity;

public class Page {
	
	private int totalcount;//ȫ������
	private int pagecount=6;//ÿҳ��ʾ������
	private int totalpage;//��ҳ��
	private int dpage;//��ǰҳ��
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
			this.totalpage = totalpage;//����
		}else {
			//���������������µ�һҳ
			this.totalpage = totalcount/pagecount+1;
		}
	}
	public int getDpage() {
		return dpage;
	}
	public void setDpage(int dpage) {
		this.dpage = dpage;
	}

	
//	private int pageSise;  // ÿҳ��ʾ��¼������
//	private int currentPage; //��ǰ�ڼ�ҳ
//	private  int totalPage; //��ҳ��
//	private int totalRecord; //�ܼ�¼����
//	private List<T> datalist; //���ݼ���
//	public Page(int PageNum,int pageSize,List<T> sourceList) {
//		if(sourceList == null) {
//			return;
//		}
//		//�ܼ�¼��
//		this.totalRecord = sourceList.size();
//		//ÿҳ��ʾ��������¼
//		this.pageSise = pageSize;
//		//��ȡ��ҳ��
//		this.totalPage = this.totalRecord/this.pageSise;
//		if(this.totalRecord % this.totalPage != 0) {
//			this.totalPage = this.totalPage+1;
//		}
//		//��ȡ��ǰ�ڼ�ҳ����
//		if(this.totalPage<PageNum) {
//			this.currentPage = this.totalPage;
//		}else {
//			this.currentPage = PageNum;
//		}
//		
//		//��ʼ����
//		int fromIndex = this.pageSise * (this.currentPage-1);
//		//��������
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
