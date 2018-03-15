package entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class EzbShopcar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7351168385077222970L;
	private List<EzbShopLine> lines= new ArrayList<EzbShopLine>();
	@SuppressWarnings("unused")
	private double total;
	private int sumcount;
	public EzbShopcar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EzbShopcar(List<EzbShopLine> shoplist, double total) {
		super();
		this.lines = shoplist;
		this.total = total;
	}
	public List<EzbShopLine> getShoplist() {
		return lines;
	}
	public List<EzbShopLine> getLines() {
		return lines;
	}
	public void setLines(List<EzbShopLine> lines) {
		this.lines = lines;
	}
	public void setShoplist(List<EzbShopLine> shoplist) {
		this.lines = shoplist;
	}
	
	public int getSumcount() {
		sumcount=0;
		for(EzbShopLine lm:lines){
			sumcount+=lm.getAmount();
		}
		return sumcount;
	}
	public void setSumcount(int sumcount) {
		this.sumcount = sumcount;
	}
	public double getTotal() {
		double sum=0;
		for(EzbShopLine l:lines){
			sum+=l.getSubtotal();
		}
		return sum;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public void add(EzbShopLine line){
		for(EzbShopLine l:lines){
			if(l.getProduct().getEpId()==line.getProduct().getEpId()){
				l.setAmount(l.getAmount()+1);
				return;
			}
		}
		lines.add(line);
	}
	public void delete(int id){
		for(EzbShopLine l:lines){
			if(l.getProduct().getEpId()==id){
				lines.remove(l);
				return;
			}
		}		
	}
	public void clear(){
		lines.clear();
	}
	public void update(int epId,int num){
		for(EzbShopLine l:lines){
			if(l.getProduct().getEpId()==epId){
				l.setAmount(num);
			}
		}
	}
}
