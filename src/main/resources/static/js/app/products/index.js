var m = Modal.default;
var app = new Vue({
  el: '#app',
  directive : {
	  mask : VueTheMask
  },
  components : {
	  productsList : {
		  props : ['list'],
		  data : function() {
			  return {
				 products : []
			  }
		  },
		  template : `
			  <div class='container'>
			  	<table class='table'>
			  		<thead class='thead-dark'>
			  			<tr>
			  				<slot name='tHead'></slot>
			  			</tr>
			  		</thead>
			  		<tbody>
			  			<slot name='tBody'></slot>
			  		</tbody>
			  	</table>
			  </div>
		  `
	  },
	  productsForm : {
		  props : ['obj'],
		  components : {
			  selectCategory : {
				  props : ['category'],
				  data : function() {
					  return {
						  categories : []
					  }
				  },
				  template : `
					  <div>
					  	<btn color="default">Default</btn>
						  <mdb-select v-model='category'>
						  	<option v-bind:value='null'>-- Selecione --</option>
						  	<option v-for='cat in categories' v-bind:value='cat'>{{ cat.name }}<option>
						  </mdb-select>
					  </div>
				  `,
				  created() {
					  this.loadCategories();
				  },
				  methods : {
					  loadCategories() {
						  axios.get("http://localhost:8080/productsCategories")
						  .then(
								  response => {
									  this.categories = response.data;
								  }
						  )
						  .catch( e => {
							  console.log(e);
						  });
					  }
				  }
			  }
		  },
		  template : `
			  <div>
			  	<h3> Product form</h3>	
			  	<form>
			  		<div class='row'>
				  		<div class='form-group col-sm-12 col-lg-6'>
						  	<label>Name</label>
						  	<input class='form-control' type='text' v-model='obj.name'></input>
						</div>
						<div class='form-group col-sm-12 col-lg-6'>
						  	<label>Quantity</label>
						  	<input class='form-control' type='number' v-model='obj.quantity'></input>
						</div>

						<div class='form-group col-sm-12 col-lg-6'>
							<label>Category</label>
							<select-category v-bind:category='obj.category'></select-category>
						</div>
						
						<div class='form-group col-sm-12 col-lg-6'>
						  	<label>Codebar</label>
						  	<input v-mask="'####.####.##'" class='form-control' type='text' v-model='obj.codebar'></input>
						</div>
					</div>
				</form>
			</div>
		  `
	  }
  },
  data: {
	  products : [],
	  product : Product()
  },
  created : function() {
	  this.loadProducts();
  },
  methods : {
	  resetObj() {
		  this.product = Product();
	  },
	  loadProducts() {
		  axios.get("http://localhost:8080/products").then(
				  response => {
					  console.log(response.data);
					  prods = response.data;
					  this.products = prods;
				  }
		  ).catch(
				  e => {
					  console.log(e)
				  }
		  )
	  },
	  save : function() {
		  axios.post("http://localhost:8080/products", this.product).then(
				  response => {
					  console.log(response);
					  this.loadProducts();
					  this.resetObj();
				  }
		  ).catch(e => {
			  console.log(e)
		  })
	  },
	  cancel : function () {
		  this.product = Product();
	  }
  }
})