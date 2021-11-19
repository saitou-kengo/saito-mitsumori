<template>
<div>
  <h1>見積詳細</h1>
  <InputEstimateForm/>
  <input type="button" value="編集" id="edit"/>
  <input type="button" value="削除" id="delete"/>
    <EstimatesDatailList/>
</div>
</template>

<script>
import InputEstimateForm from '../modules/InputEstimateForm.vue'
import EstimatesDatailList from '../modules/EstimatesDatailList.vue'

export default {
  components: {
    InputEstimateForm,
    EstimatesDatailList
  }

}
</script>

<style>

</style>