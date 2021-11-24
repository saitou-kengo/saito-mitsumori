<template>
<div>
  <h1>見積登録</h1>
  <InputEstimateForm/>
  <InputItemForm/>
  <button v-on:click="insertEstimate">見積登録</button>
</div>
</template>

<script>
import InputEstimateForm from '../modules/InputEstimateForm.vue'
import InputItemForm from '../modules/InputItemForm.vue'
import axios from 'axios'

export default {
  components: {
    InputEstimateForm,
    InputItemForm
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
        insertEstimate: function() {
            axios
            .post("/api/v1/estimates", {
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