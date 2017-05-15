package whut.inis.show.util;

public class PageUtil {
	private int size;//��ҳÿҳ��ʾ����Ŀ��  �Զ���
	private int num;//�û�ѡ���ҳ��  ��ǰ̨�û����ݶ���
	private int rowCount;//�ôβ�ѯ��Ϣ������  �����ݿ��ѯ����
	
	private int pageCount;
	private int first = 1;
	private int last;
	private int prev;
	private int next;
	
	private int startRow;//��ѯ��ʼ���к� ��limit �����һ������
	
	private int start;//��������ʼλ��
	private int end;//����������λ��
	
	private int numCount = 20;//��������ʾ��ҳ����
	
	/**
	 * �������ҳ������Ҫ������
	 */
	public PageUtil(int size,String str_num,int rowCount){
		this.size = size;
		this.num = 1;
		if(str_num != null){
			this.num = Integer.parseInt(str_num);
		}
		this.rowCount = rowCount;
		
		this.pageCount = (int) Math.ceil((double)this.rowCount/this.size);
		
		this.last = this.pageCount;
		
		/*
		 * ֻҪҳ��������Χ  ����ʾ��һҳ����
		 */
//		if(this.num < 1 || this.num > this.last){
//			this.num = 1;
//		}
		
		/*
		 * ҳ��С��1 ��ʾ��һҳ  ҳ���������һҳ ��ʾ���һҳ
		 */
		this.num = Math.max(this.num, this.first);
		
		this.num = Math.min(this.last, this.num);
		
		this.next = this.num + 1;
		
		this.prev = this.num - 1;
		
		this.startRow = (this.num-1)*this.size;
		
		this.start = Math.max(this.first, this.num - this.numCount/2);
		
		this.end = Math.min(this.last, this.start + this.numCount);
		
		if(this.end - this.start < 10){
			this.start = Math.max(this.first, this.end - this.numCount);
		}
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getNumCount() {
		return numCount;
	}

	public void setNumCount(int numCount) {
		this.numCount = numCount;
	}
}
