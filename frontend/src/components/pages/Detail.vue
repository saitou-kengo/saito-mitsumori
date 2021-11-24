<template>
<div>
  <h1>見積詳細</h1>
  <InputEstimateForm/>
  <router-link :to="{ name:'edit',params:{ id : estimate.id }}">編集</router-link>
  <button v-on:click="deleteEstimate">削除</button>
  <EstimatesDatailList/>
</div>
</template>

<script>
import InputEstimateForm from '../modules/InputEstimateForm.vue'
import EstimatesDatailList from '../modules/EstimatesDatailList.vue'
import axios from 'axios'

export default {
  components: {
    InputEstimateForm,
    EstimatesDatailList
  },
  data() {
    return {
      estimateId: ""
    }
  },
  methods: {
    deleteEstimate: function() {
      axios
      .delete("/api/v1/estimates/{id}", estimateId)
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