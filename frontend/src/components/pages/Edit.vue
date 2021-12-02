<template>
<div class="container">
  {{ estimate }}
  <h1>見積編集</h1>
  <edit-estimate-form :estimate="estimate"/>
  <input-item-form/>
  <button @click="updataEstimate" class="btn btn-warning">見積更新</button>
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
      details: null
    }
  },
  computed: {
    overAmount: function() {
      return this.estimate.budgetedAmount - this.estimate.amount;
    }
  },
  methods: {
    updataEstimate: function() {
      let params = new URLSearchParams();
      params.append('id', this.estimateId);
      params.append('name', this.estimate.estimateName);
      params.append('amount', this.estimate.amount);
      params.append('budgetedAmount', this.estimate.budgetedAmount);
      params.append('customerCd', this.estimate.customerCd);
      params.append('employeeCd', this.estimate.employeeCd);
      params.append('status', this.estimate.status);
      this.$axios
      .put('http://localhost:8080/api/v1/estimates/:id', params)
      .then((res) => {
        this.$router.push('/');
        alert('見積情報を更新しました')
        console.log(res);
      })
      .catch((err) => {
        alert('見積情報の更新に失敗')
        console.log("エラー：" + err);
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
        console.log('エラー：' + err);
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
        console.log(res.data);
    })
    .catch(err => {
        console.log('エラー：' + err);
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
      alert('明細を削除しました')
      console.log(res.data + 'delete EstimateDetail');
    })
    .catch(err => {
      console.log('エラー：', err);
    })
    },
    insertDetail() {
        this.$axios
        .get('http://localhost:8080/api/v1/estimate-details', {
            params: {
                estimateId: this.estimateId,
                productCd: this.productCd,
                quantity: this.quantity
            }
            })
        .then(res => {
            console.log(res.data + 'create new EstimateDetail');
        })
        .catch(err => {
            console.log('エラー：' + err);
        })
    }
  },
  created: function() {
    this.getEstimateById();
    this.getEstimateDetailsListById();
  }
}
</script>

<style>

</style>