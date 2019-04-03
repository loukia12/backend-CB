package com.example.Model;

	import java.io.Serializable;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.EntityListeners;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import org.springframework.data.jpa.domain.support.AuditingEntityListener;

	




	@Entity
	@Table(name="houses_table")
//	@EntityListeners(AuditingEntityListener.class)
	public class House implements Serializable{
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id", nullable=false)
		private Long id;
		
		@Column(name="size")
		private int size;
		
		@Column(name="price")
		private int price;
		
		
		


		public House(@NotNull int size,@NotNull int price) {
			this.size = size;
			this.price = price;
		}

		public House() {
			
		}
		
		public Long getId() {
			return id;
		}

		

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}


}
