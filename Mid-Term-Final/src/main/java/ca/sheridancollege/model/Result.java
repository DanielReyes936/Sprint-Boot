package ca.sheridancollege.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ca.sheridancollege.DataArray.DataArray;



@Entity
@Table(name = "Result")
public final class Result {
	public Result(int i) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(int SumTotal) {
		
DataArray db = new DataArray();
		
		this.sumTotal = db.getSum();
		
	}

	public int getSumTotal() {
		return sumTotal;
	}

	public void setSumTotal(int sumTotal) {
		this.sumTotal = sumTotal;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private  int sumTotal;
	
	

	

	
	




	
	
}
