<template>
<div class="container">
  <edit-estimate-form :estimate="estimate"/>
  <input-item-form
    @add-detail="addDetails"
  />
  <div class="row">
    <div class="col">
      <button @click="updataComfirm" class="btn btn-warning" id="button">見積更新</button>
    </div>
  </div>
  <edit-estimate-details-list :details="details"
    @delete-detail="deleteDetail"
  />
</div>
</template>

<script>
import EditEstimateForm from '../modules/Form/EditEstimateForm.vue'
import InputItemForm from '../modules/Form/InputItemForm.vue'
import EditEstimateDetailsList from '../modules/ListView/EditEstimateDetailsList.vue'

export default {
  
  components: {
    EditEstimateForm,
    InputItemForm,
    EditEstimateDetailsList
  },
  data() {
    return {
      estimateId: this.$route.params.id,
      estimate: null,
      details: []
    }
  },
  computed: {
    overAmount() {
      return this.estimate.budgetedAmount - this.estimate.amount;
    }
  },
  methods: {
    updataEstimate: function() {
      let form = new FormData();
      form.append('id', this.estimateId);
      form.append('name', this.estimate.estimateName);
      form.append('amount', this.estimate.amount);
      form.append('budgetedAmount', this.estimate.budgetedAmount);
      form.append('customerCd', this.estimate.customerCd);
      form.append('employeeCd', this.estimate.employeeCd);
      form.append('status', this.estimate.status);
      return new Promise(resolve => {
        this.$axios
        .put('http://localhost:8080/api/v1/estimates/:id', form)
        .then((res) => {
          console.log(res + 'update a Estimate by :id');
          resolve();
        })
        .catch((err) => {
          console.log('Error：' + err);
        })
      })
    },
    getEstimateById: function() {
      this.$axios
      .get('http://localhost:8080/api/v1/estimates/:id', {
        params: {
          id: this.estimateId
        }
      })
      .then(res => {
        this.estimate = res.data;
        console.log('retrieve a Estimate by :id');
      })
      .catch(err => {
        console.log('Error：' + err);
      })
    },
    getEstimateDetailsListById: function() {
      this.$axios
      .get('http://localhost:8080/api/v1/estimate-details/:id', {
          params: {
          id: this.estimateId
          }
      })
      .then(res => {
          this.details = res.data;
          console.log('retrieve a Estimate by :id');
      })
      .catch(err => {
          console.log('Error：' + err);
      });
    },
    deleteDetail: function(id) {
      this.$axios
      .delete('http://localhost:8080/api/v1/estimate-details/:id', {
        params: {
          id: id
        }
      })
      .then(res => {
        this.$router.go({path: this.$router.currentRoute.path, force: true});
        console.log(res.data + 'delete EstimateDetail');
      })
      .catch(err => {
        console.log('Error：', err);
      })
    },
    insertDetail(subId, productCd, quantity) {
      let form = new FormData();
      form.append('estimateId', this.estimateId)
      form.append('subId', subId);
      form.append('productCd', productCd);
      form.append('quantity', quantity);
      this.$axios
      .post('http://localhost:8080/api/v1/estimate-details', form)
      .then(res => {
        this.$router.go({path: this.$router.currentRoute.path, force: true})
        console.log(res.data + 'create new EstimateDetail');
      })
      .catch(err => {
        console.log('Error：' + err);
      })
    },
    async addDetails(...inputs) {
        const [inputDetail, inputProduct, totalPrice] = inputs;
        let subId = this.details.length + 1;
        let productCd = inputProduct.productCd;
        let quantity = inputDetail.quantity;
        this.estimate.budgetedAmount += totalPrice;
        await this.updataEstimate();
        this.insertDetail(subId, productCd, quantity);

    },
    async updataComfirm() {
      await this.updataEstimate();
      alert('見積情報を更新しました')
      this.$router.push('/');
    }
  },
  created: function() {
    this.getEstimateById();
    this.getEstimateDetailsListById();
  },
  
}
</script>
