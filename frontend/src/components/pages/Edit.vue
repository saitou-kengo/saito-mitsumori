<template>
<div>
  <h1>見積編集</h1>
  <InputEstimateForm/>
  <InputItemForm/>
  <button v-on:click="updataEstimate">見積更新</button>
  <EstimatesDatailList/>
</div>
</template>

<script>
import InputEstimateForm from '../modules/InputEstimateForm.vue'
import InputItemForm from '../modules/InputItemForm.vue'
import EstimatesDatailList from '../modules/EstimatesDatailList.vue'
import ProductSearchDialog from '../modules/ProductSearchDialog.vue'
import axios from 'axios'

export default {
  
  components: {
    InputEstimateForm,
    InputItemForm,
    EstimatesDatailList,
    ProductSearchDialog
  },
  data() {
    return {
      estimateId: "",
      estimateName: "",
      status: "",
      customerName: "",
      employeeName: "",
      budgetedAmount: "",
      estimateAmount: "",
      totalPrice: ""
    }
  },
  methods: {
    updataEstimate: function() {
      axios
      .put("/api/v1/estimates/{id}", {
        estimateId: this.estimateId,
        estimateName: this.estimateName,
        status: this.status,
        customerName: this.customerName,
        employeeName: this.employeeName,
        budgetedAmount: this.budgetedAmount,
        estimateAmount: this.estimateAmount,
      })
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log("エラー：" + err);
      })
    }
  }
}
</script>

<style>

</style>